项目在使用mvn clean package 打包的时候出现 com.sun.image.codec.jpeg.JPEGCodec 是 Sun 的专用 API 这样的编译错误提示时，我们需要在maven编译插件中指定参数 rt.jar 文件。因为 rt.jar 是jre 中自带的 jar 包，所以才使用编译参数的方式使用。

pom.xml 的代码片段如下：

<build>

    <plugins>

        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>2.5</version>
            <configuration>
                <source>${jdk.version}</source>
                <target>${jdk.version}</target>
                <encoding>UTF-8</encoding>
                <compilerArguments>
                    <verbose />
                    <bootclasspath>${JAVA_HOME}/jre/lib/rt.jar${path.separator}${JAVA_HOME}/jre/lib/jce.jar</bootclasspath>
                </compilerArguments>    
            </configuration>
        </plugin>

        <!-- 你项目中需要的其他插件本例忽略 -->

    </plugins>
</build>
主要我上面的 bootclasspath 参数指定了2个 jar 文件。 
第一是我项目中需要这2个文件编译。 
第二我是为了说明另外一个问题：就是当我们需要指定多个 jar 的时候，中间的分隔符，要使用maven内置变量 ${path.separator} 来指定。因为在windows下，这个分隔符应该是“分号”，而在Linux 下这个分隔符必须是“冒号”，无论我们写死哪一种都是不兼容的，所以maven为我们提供了这样的变量，可以自动根据操作系统来使用对应的分隔符。

所以maven分隔符变量 ${path.separator} 我们可能在其他配置的时候也会使用到，大家回想一下在Linux下和在Windows下配置环境变量时的分隔符就知道了。

