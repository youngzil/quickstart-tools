在Maven实际使用过程中，有时候在对一些旧有的项目的做从Makefile和ant到Maven迁移时需要对一些步骤做特殊处理，比如说编译JNI代码，虽然Maven有个native插件可以用，但需要将原有项目JNI的编译步骤重写，这在有些时候显然不太适合，比如时间压力比较大的情况下。其实这种情况可以使用Maven的antrun插件来做，这样做的好处就是可以重用原来写好的Makefile，相对来说还是比较简单也是最快的。具体信息可以参考http://maven.apache.org/plugins/maven-antrun-plugin/。

Maven的antrun用起来也是非常简单的，就是在代码里嵌入类似以下代码片段：

	...
	<build>
		<plugins>
			<plugin>
				<artifactId>maven-antrun-plugin</artifactId>
				<executions>
					<execution>
						<id>package</id>
						<phase>package</phase>
						<goals>
							<goal>run</goal>
						</goals>
						<configuration>
							<tasks>
								<echo message="make ..."/>
								<exec dir="src/main/c" executable="make" failonerror="true" />
							</tasks>
						</configuration>
					</execution>
					<execution>
						<id>clean</id>
						<phase>clean</phase>
						<goals>
							<goal>run</goal>
						</goals>
						<configuration>
							<tasks>
								<echo message="make clean ..."/>
								<exec dir="src/main/c" executable="make" failonerror="true">
									<arg line="clean"/>
								</exec>
							</tasks>
						</configuration>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
	...
* 代码中定义了两个execution节点，分别执行原来Makefile中定义的make和make clean。这里可以将tasks节点定义成任意自己想要运行的ant任务；
* 在第一个execution节点下，把phase定义成package，goal定义成run，是为了使在运行"mvn package"的时候自动执行第一个execution节点下的ant任务；

* 在第二个execution节点下，把phase定义成clean，goal定义成run，是为了使在运行"mvn clean"的时候自动执行第二个execution节点下的ant任务；

