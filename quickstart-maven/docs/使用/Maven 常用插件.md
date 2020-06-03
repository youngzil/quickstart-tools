=========Maven Report Plugin========= 
1.源码分析

<artifactId>maven-pmd-plugin</artifactId>  
1
2.代码格式检查

<artifactId>maven-checkstyle-plugin</artifactId>  
1
3.代码相似度检查

<groupId>org.codehaus.mojo</groupId>  
<artifactId>simian-maven-plugin</artifactId>  
1
2
4.格式化统计报告

<groupId>org.codehaus.mojo</groupId>  
<artifactId>jdepend-maven-plugin</artifactId>  
1
2
5.FireBug检查

<groupId>org.codehaus.mojo</groupId>  
<artifactId>findbugs-maven-plugin</artifactId>  
1
2
6.JavaDoc

<artifactId>maven-javadoc-plugin</artifactId>  
1
7.生成java代码交叉引用和源代码的html格式

<artifactId>maven-jxr-plugin</artifactId>  
1
8.代码覆盖率

<groupId>org.codehaus.mojo</groupId>  
<artifactId>cobertura-maven-plugin</artifactId>  

<groupId>org.codehaus.mojo</groupId>  
<artifactId>emma-maven-plugin</artifactId>  
1
2
3
4
5
9.Java代码的度量工具

<groupId>org.codehaus.mojo</groupId>  
<artifactId>javancss-maven-plugin</artifactId>   
1
2
10.单元测试报告

<artifactId>maven-surefire-report-plugin</artifactId>  
1
11.TODO检查报告

<groupId>org.codehaus.mojo</groupId>  
<artifactId>taglist-maven-plugin</artifactId>  
1
2
12.项目总报告

<artifactId>maven-project-info-reports-plugin</artifactId>  
1
=========Maven Common Plugin========= 
1.SCP文件传输

<groupId>com.github.goldin</groupId>  
<artifactId>copy-maven-plugin</artifactId>  
1
2
2.SSH命令

<groupId>com.github.goldin</groupId>  
<artifactId>sshexec-maven-plugin</artifactId>  
1
2
3.Maven Job

<groupId>com.github.goldin</groupId>  
<artifactId>jenkins-maven-plugin</artifactId>  
1
2
4.生成about信息

<groupId>com.github.goldin</groupId>  
<artifactId>about-maven-plugin</artifactId>  
1
2
5.查找重复依赖

<groupId>com.github.goldin</groupId>  
<artifactId>duplicates-finder-plugin</artifactId>  
1
2
6.Maven邮件发送

<groupId>com.github.goldin</groupId>  
<artifactId>mail-maven-plugin</artifactId>  
1
2
7.项目目录查找

<groupId>com.github.goldin</groupId>  
<artifactId>find-maven-plugin</artifactId>  
1
2
8.获取SVN版本

<groupId>com.google.code.maven-svn-revision-number-plugin</groupId>  
<artifactId>maven-svn-revision-number-plugin</artifactId>  
1
2
9.编译C++

<groupId>org.codehaus.mojo</groupId>  
<artifactId>native-maven-plugin</artifactId>  
1
2
10.DDL生成

<groupId>org.codehaus.mojo</groupId>  
<artifactId>hibernate3-maven-plugin</artifactId>  
1
2
11.Eclipse RCP

<groupid>org.sonatype.tycho</groupid>  
<artifactid>target-platform-configuration</artifactid>  
1
2
=========Maven Official Plugin========= 
1.自动定义打包

<artifactId>maven-assembly-plugin</artifactId>  
1
2.ANT

<artifactId>maven-antrun-plugin</artifactId>  
1
=========Maven 全局属性========= 
1.源码编码

<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>  
maven.compile.classpath  
maven.runtime.classpath  
maven.test.classpath  
maven.plugin.classpath  
1
2
3
4
5
2.ClassPath

maven.compile.classpath  
maven.runtime.classpath  
maven.test.classpath  
maven.plugin.classpath 
1
2
3
4
=========Maven 插件报表=========

maven-site-plugin

这个插件是一个负责为Java项目生成静态HTML网站的插件。这个插件非常的有用，里面可以嵌入各种插件，比如用来对代码检查bug的findbugs,检查代码风格的checkstyle,生成testng测试报告的surefire等。

先来看一下关于这个插件的配置的一个例子：

    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-site-plugin</artifactId>
        <version>3.5.1</version>
        <configuration>
            <reportPlugins>
                <plugin>
                    <groupId>org.codehaus.mojo</groupId>
                    <artifactId>findbugs-maven-plugin</artifactId>
                    <version>3.0.1</version>
                </plugin>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-pmd-plugin</artifactId>
                    <version>3.6</version>
                </plugin>
                <plugin>
                    <groupId>org.codehaus.mojo</groupId>
                    <artifactId>taglist-maven-plugin</artifactId>
                    <version>2.4</version>
                    <configuration>
                        <tags>
                            <tag>fixme</tag>
                            <tag>FixMe</tag>
                            <tag>FIXME</tag>
                            <tag>@todo</tag>
                            <tag>todo</tag>
                            <tag>TODO</tag>
                            <tag>@deprecated</tag>
                        </tags>
                    </configuration>
                </plugin>
            </reportPlugins>
        </configuration>
    </plugin>
site 插件例子中还可以添加很多其他插件，然后生成报告。