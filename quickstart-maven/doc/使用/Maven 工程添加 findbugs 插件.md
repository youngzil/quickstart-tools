pom.xml 添加插件plugin

<build>
    <plugins>
        <!-- findbugs插件 -->
        <plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>findbugs-maven-plugin</artifactId>
            <version>3.0.4</version>
            <configuration>
                <!-- 设置分析工作的等级，可以为Min、Default和Max -->
                <effort>Low</effort>
                <!-- Low、Medium和High (Low最严格) -->
                <threshold>Medium</threshold>
                <failOnError>true</failOnError>
                <includeTests>true</includeTests>
                <!--findbugs需要忽略的错误的配置文件-->
                <excludeFilterFile>findbugs/findbugs-exclude-filter.xml</excludeFilterFile>
            </configuration> 
            <executions>
                <execution>
                    <id>run-findbugs</id>
                    <!-- 在package 阶段触发执行findbugs检查，比如执行 mvn clean package -->
                    <phase>package</phase>
                    <goals>
                        <goal>check</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
findbugs-exclude-filter.xml 内容示例

<?xml version="1.0" encoding="UTF-8"?>
<FindBugsFilter>
    <Match>
        <Class name="~.*\.(model|entity|vo)\..*" />
        <Method name="~(get.*|set.*)" />
        <!-- <Bug pattern="EI_EXPOSE_REP" /> -->
        <Bug code="EI,EI2" />
    </Match>
    <Match>
        <Class name="~.*\.Authorization" />
        <Bug code="EI,EI2" />
    </Match>
</FindBugsFilter>
关于 filter 的其他说明可以查看：http://findbugs.sourceforge.net/manual/filter.html

经常使用的2个命令： 
mvn clean compile findbugs:findbugs 
mvn findbugs:gui

