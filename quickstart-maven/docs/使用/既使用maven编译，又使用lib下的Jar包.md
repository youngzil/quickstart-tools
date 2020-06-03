在项目开发中，项目用maven管理，是一个maven项目。 
一般情况下jar包都可以使用pom.xml来配置管理，但也有一些时候，我们项目中使用了一个内部jar文件，但是这个文件我们又没有开放到maven库中。 
我们会将文件当到我们项目WEB-INF/lib中。 
如果我们不对pom.xml进行特殊配置的话，maven打包是不会自动去引用和编译lib中的jar文件的，所以需要我们修改下pom.xml文件。

修改maven-compiler-plugin的配置，如下：

<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.1</version>
    <configuration>
        <source>1.7</source>
        <target>1.7</target>
        <encoding>UTF-8</encoding>
        <compilerArguments>
            <verbose />
            <bootclasspath>${env.JAVA_HOME}/jre/lib/rt.jar</bootclasspath>
            <extdirs>${project.basedir}/src/main/webapp/WEB-INF/lib</extdirs>
        </compilerArguments>
    </configuration>
</plugin>
其他配置是我的原来配置，针对lib引用这个问题，只需要增加的是： 
<extdirs>${project.basedir}/src/main/webapp/WEB-INF/lib</extdirs>

不过在3.1版本以后maven-compiler-plugin将compilerArguments定为过时了，建议大家按下面的方法写。 
其中表示javac平时用空格隔开的的每一个参数。

<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.1</version>
    <configuration>
        <source>1.7</source>
        <target>1.7</target>
        <encoding>UTF-8</encoding>
        <compilerArgs> 
            <arg>-verbose</arg>
            <arg>-Xlint:unchecked</arg>
            <arg>-Xlint:deprecation</arg>
            <arg>-bootclasspath</arg>
            <arg>${env.JAVA_HOME}/jre/lib/rt.jar</arg>
            <arg>-extdirs</arg> 
            <arg>${project.basedir}/src/main/webapp/WEB-INF/lib</arg>
        </compilerArgs> 
    </configuration>
</plugin>
其中${project.basedir}一定要写，不然会出现“在windows”下可以正常编译，在Linux服务器上就“有可能”出现编译找不到jar包的错误。

另外科普一下，maven的目录约定： 
pom.xml所在的目录应为项目的根目录，假设该目录为${proj-dir}，那么Maven有以下假设：
${proj-dir}/src/main/java —— 存放项目的.java文件。
${proj-dir}/src/main/resources —— 存放项目资源文件，如spring, hibernate配置文件。
${proj-dir}/src/test/jave —— 存放所有测试.java文件，如JUnit测试类。
${proj-dir}/src/test/resources —— 测试资源文件。
${proj-dir}/target —— 项目输出位置。

运行一条mvn clean package命令，Maven会帮你清除target目录，重新建一个空的，编译src/main/java类至target/classes，复制src/main/resources的文件至target/classes，编译src/test/java至target/test-classes，复制src/test/resources的文件至target/test-classes；然后运行所有测试；测试通过后，使用jar命令打包，存储于target目录。Maven做的事情一点也不少，只是都对用户隐蔽起来了，它只要求你遵循它的约定。


