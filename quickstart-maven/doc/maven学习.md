1、Maven工程标准架构、打包编译命令
2、Maven详解
Maven基本概念：仓库、jar
Maven依赖管理和依赖冲突解决
Maven生命周期
关于scope依赖范围
3、maven中引入测试类，但是打包会报错，最好测试独立，不依赖其他的模块测试类,这是maven的原则
打包排除配置文件，使用maven-jar-plgin或者maven-war-piugin
编译排除部分配置：使用maven-resources-plugin插件和resources配置：maven分环境编译和打包.md

4、Maven概念学习
5、配置本地仓库地址和Mac配置



---------------------------------------------------------------------------------------------------------------------
Maven概念学习

Maven内置了三大特性：属性、Profile和资源过滤来支持构建的灵活性。


1、Maven属性
事实上有六种类型的Maven属性：
1、内置属性：主要有两个常用内置属性——${basedir}表示项目根目录，即包含pom.xml文件的目录;${version}表示项目版本。
2、POM属性：pom中对应元素的值。例如常用的POM属性包括：
    ${project.artifactId}对应了<project><artifactId>元素的值
    ${project.build.sourceDirectory}:项目的主源码目录，默认为src/main/java/.
    ${project.build.testSourceDirectory}:项目的测试源码目录，默认为/src/test/java/.
    ${project.build.directory}:项目构建输出目录，默认为target/.
    ${project.build.outputDirectory}:项目主代码编译输出目录，默认为target/classes/.
    ${project.build.testOutputDirectory}:项目测试代码编译输出目录，默认为target/testclasses/.
    ${project.groupId}:项目的groupId.
    ${project.artifactId}:项目的artifactId.
    ${project.version}:项目的version,于${version}等价
    ${project.build.finalName}:项目打包输出文件的名称，默认为${project.artifactId}${project.version}.
3、自定义属性：在pom中<properties>元素下自定义的Maven属性。
4、Settings属性：与POM属性同理。如${settings.localRepository}指向用户本地仓库的地址。
5、Java系统属性：所有Java系统属性都可以使用Maven属性引用，例如${user.home}指向了用户目录。可以通过命令行mvn help:system查看所有的Java系统属性
6、环境变量属性：所有环境变量都可以使用以env.开头的Maven属性引用。例如${env.JAVA_HOME}指代了JAVA_HOME环境变量的值。也可以通过命令行mvn help:system查看所有环境变量。


2、Maven Profile
每个Profile可以看作是POM的一部分配置，我们可以根据不同的环境应用不同的Profile，从而达到不同环境使用不同的POM配置的目的。

profile可以声明在以下这三个文件中：
pom.xml：很显然，这里声明的profile只对当前项目有效
用户settings.xml：.m2/settings.xml中的profile对该用户的Maven项目有效
全局settings.xml：conf/settings.xml，对本机上所有Maven项目有效


3、资源过滤
默认情况下，Maven属性只有在POM中才会被解析。资源过滤就是指让Maven属性在资源文件(src/main/resources、src/test/resources)中也能被解析。
在POM中添加下面的配置便可以开启资源过滤
从上面的配置中可以看出，我们其实可以配置多个主资源目录和多个测试资源目录。

Maven除了可以对主资源目录、测试资源目录过滤外，还能对Web项目的资源目录(如css、js目录)进行过滤。这时需要对maven-war-plugin插件进行配置





参考
https://blog.csdn.net/bao19901210/article/details/52415402
https://www.cnblogs.com/laobiao/p/5589025.html


---------------------------------------------------------------------------------------------------------------------

配置本地仓库地址和Mac配置


配置本地仓库地址
<localRepository>/Users/yangzl/repo</localRepository>



Mac配置
#maven路径:mvn-v
exportMAVEN_HOME=/Users/yangzl/mysoft/apache-maven-3.5.4
exportPATH=$PATH:$MAVEN_HOME/bin


参考
https://blog.csdn.net/catoop/article/category/5818477


---------------------------------------------------------------------------------------------------------------------
Maven详解

Maven基本概念：仓库、jar
Maven依赖管理和依赖冲突解决
Maven生命周期
关于scope依赖范围


Maven基本概念：仓库、jar

![Maven下载路径](../../docs/images/mavenflow.jpg"ReferencePicture")

中央仓库：该仓库存储了互联网上的jar，由Maven团队来维护，地址是：http://repo1.maven.org/maven2/。

jar的查找坐标：groupId、artifactId、version。
查找：http://search.maven.org/、http://mvnrepository.com/上进行查找确定坐标。

使用Snapshot版本，在开发过程中B发布的版本标志为Snapshot版本，A进行依赖的时候选择Snapshot版本，那么每次B发布的话，会在私服仓库中，形成带有时间戳的Snapshot版本，而A构建的时候会自动下载B最新时间戳的Snapshot版本！

Maven是一个采用纯Java编写的开源项目管理工具。Maven采用了一种被称之为projectobjectmodel(POM)概念来管理项目，所有的项目配置信息都被定义在一个叫做POM.xml的文件中，通过该文件，Maven可以管理项目的整个声明周期，包括编译，构建，测试，发布，报告等等。目前Apache下绝大多数项目都已经采用Maven进行管理。而Maven本身还支持多种插件，可以方便更灵活的控制项目。




Maven依赖管理和依赖冲突解决

mvndependency:tree命令形成依赖树

依赖传递：如果A依赖B，B依赖C，那么引入A，意味着B和C都会被引入。

Maven的最近依赖策略：如果一个项目依赖相同的groupId、artifactId的多个版本，那么在依赖树（mvndependency:tree）中离项目最近的那个版本将会被使用。（从这里可以看出Maven是不是有点小问题呢？能不能选择高版本的进行依赖么？据了解，Gradle就是version+策略）

如何处理依赖冲突：
1、不管如何依赖传递，都可以进行版本锁定：使用<dependencyManagement>[这种主要用于子模块的版本一致性中]
2、去掉我们不想依赖的：使用<exclusions>[在实际中我们可以在IDEA中直接利用插件帮助我们生成]
3、最近依赖策略，直接使用显式依赖指定版本，那不就是最靠近项目的么：使用<dependency>


Maven生命周期：
![Maven生命周期](../../docs/images/lifecycle.jpg"ReferencePicture")

clean：有问题，多清理！
package：打成JarorWar包，会自动进行clean+compile
install：将本地工程Jar上传到本地仓库
deploy：上传到私服


关于scope依赖范围
既然，Maven的生命周期存在编译、测试、运行这些过程，那么显然有些依赖只用于测试，比如junit；有些依赖编译用不到，只有运行的时候才能用到，比如mysql的驱动包在编译期就用不到（编译期用的是JDBC接口），而是在运行时用到的；还有些依赖，编译期要用到，而运行期不需要提供，因为有些容器已经提供了，比如servlet-api在tomcat中已经提供了，我们只需要的是编译期提供而已。

总结来说：
compile：默认的scope，运行期有效，需要打入包中。
provided：编译期有效，运行期不需要提供，不会打入包中。
runtime：编译不需要，在运行期有效，需要导入包中。（接口与实现分离）
test：测试需要，不会打入包中。
system：非本地仓库引入、存在系统的某个路径下的jar。（一般不使用）


---------------------------------------------------------------------------------------------------------------------

Maven工程标准架构
目录	备注
${basedir}	存放pom.xml和所有的子目录
${basedir}/src/main/resources	项目的资源，如spring配置文件，properties资源文件等
${basedir}/src/main/webapps	web项目特有
${basedir}/src/test/java	项目的测试类，比如说JUnit代码、TestNg代码
${basedir}/src/test/resources	测试代码使用的资源


打包：
mvncleancompile-DskipTests-U-X-e

mvncleancompile
mvncleanpackage
mvncleaninstall

-DskipTests
-Dmaven.test.skip=true
-DskipTests=false开启测试

使用-U参数：该参数能强制让Maven检查所有SNAPSHOT依赖更新，确保集成基于最新的状态，如果没有该参数，Maven默认以天为单位检查更新，而持续集成的频率应该比这高很多。
使用-X参数：开启DEBUG模式。
使用-e参数：如果构建出现异常，该参数能让Maven打印完整的stacktrace，以方便分析错误原因。
使用-B参数：该参数表示让Maven使用批处理模式构建项目，能够避免一些需要人工参与交互而造成的挂起状态。

---------------------------------------------------------------------------------------------------------------------

常用maven命令总结：
mvn-v//查看版本
mvnarchetype:create//创建Maven项目
mvncompile//编译源代码
mvntest-compile//编译测试代码
mvntest//运行应用程序中的单元测试
mvnsite//生成项目相关信息的网站
mvnpackage//依据项目生成jar文件
mvninstall//在本地Repository中安装jar
mvn-Dmaven.test.skip=true//忽略测试文档编译
mvnclean//清除目标目录中的生成结果
mvncleancompile//将.java类编译为.class文件
mvncleanpackage//进行打包
mvncleantest//执行单元测试
mvncleandeploy//部署到版本仓库
mvncleaninstall//使其他项目使用这个jar,会安装到maven本地仓库中
mvnarchetype:generate//创建项目架构
mvndependency:list//查看已解析依赖
mvndependency:tree//看到依赖树
mvndependency:analyze//查看依赖的工具
mvnhelp:system//从中央仓库下载文件至本地仓库
mvnhelp:active-profiles//查看当前激活的profiles
mvnhelp:all-profiles//查看所有profiles
mvnhelp:effective-pom//查看完整的pom信息



mvnarchetype：create创建Maven项目
mvncompile编译源代码
mvndeploy发布项目
mvntest-compile编译测试源代码
mvntest运行应用程序中的单元测试
mvnsite生成项目相关信息的网站
mvnclean清除项目目录中的生成结果
mvnpackage根据项目生成的jar
mvninstall在本地Repository中安装jar
mvneclipse:eclipse生成eclipse项目文件
mvnjetty:run启动jetty服务
mvntomcat:run启动tomcat服务
mvncleanpackage-Dmaven.test.skip=true:清除以前的包后重新打包，跳过测试类



---------------------------------------------------------------------------------------------------------------------

maven中引入测试类，但是打包会报错，最好测试独立，不依赖其他的模块测试类,这是maven的原则
<dependency>
<groupId>${project.groupId}</groupId>
<artifactId>aifgw-backend-common</artifactId>
<version>${project.version}</version>
<classifier>tests</classifier>
<scope>test</scope>
</dependency>


打包排除配置文件，使用maven-jar-plgin或者maven-war-piugin

<build>
<plugins>
<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-jar-plugin</artifactId>
<version>3.0.2</version>
<configuration>
<excludes>
<exclude>aifgw.yaml</exclude>
<exclude>log4j2.yaml</exclude>
<exclude>velocity.properties</exclude>
</excludes>
</configuration>
</plugin>
</plugins>
</build>

<build>
<plugins>
<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-war-plugin</artifactId>
<version>3.0.0</version>
<configuration>
<archive>
<manifest>
<addClasspath>true</addClasspath>
</manifest>
</archive>
<webResources>
<resource>
<directory>src/main/front/build</directory>
</resource>
</webResources>
</configuration>
</plugin>
</plugins>
</build>
---------------------------------------------------------------------------------------------------------------------
