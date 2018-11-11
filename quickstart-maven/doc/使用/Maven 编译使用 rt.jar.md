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


<plugin>                                                                                                                                      
    <!-- 指定maven编译的jdk版本,如果不指定,maven3默认用jdk 1.5 maven2默认用jdk1.3 -->                                                                           
    <groupId>org.apache.maven.plugins</groupId>                                                                                               
    <artifactId>maven-compiler-plugin</artifactId>                                                                                            
    <version>3.1</version>                                                                                                                    
    <configuration>                                                                                                                           
        <!-- 一般而言，target与source是保持一致的，但是，有时候为了让程序能在其他版本的jdk中运行(对于低版本目标jdk，源代码中不能使用低版本jdk中不支持的语法)，会存在target不同于source的情况 -->                    
        <source>1.8</source> <!-- 源代码使用的JDK版本 -->                                                                                             
        <target>1.8</target> <!-- 需要生成的目标class文件的编译版本 -->                                                                                     
        <encoding>UTF-8</encoding><!-- 字符集编码 -->
        <skipTests>true</skipTests><!-- 跳过测试 -->                                                                             
        <verbose>true</verbose>
        <showWarnings>true</showWarnings>                                                                                                               
        <fork>true</fork><!-- 要使compilerVersion标签生效，还需要将fork设为true，用于明确表示编译版本配置的可用 -->                                                        
        <executable><!-- path-to-javac --></executable><!-- 使用指定的javac命令，例如：<executable>${JAVA_1_4_HOME}/bin/javac</executable> -->           
        <compilerVersion>1.3</compilerVersion><!-- 指定插件将使用的编译器的版本 -->                                                                         
        <meminitial>128m</meminitial><!-- 编译器使用的初始内存 -->                                                                                      
        <maxmem>512m</maxmem><!-- 编译器使用的最大内存 -->                                                                                              
        <compilerArgument>-verbose -bootclasspath ${java.home}\lib\rt.jar</compilerArgument><!-- 这个选项用来传递编译器自身不包含但是却支持的参数选项 -->               
    </configuration>                                                                                                                          
</plugin>                    

---------------------

本文来自 B8613A 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/liupeifeng3514/article/details/80236077?utm_source=copy 

