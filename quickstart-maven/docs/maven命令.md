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
mvn -v//查看版本
mvn archetype:create//创建Maven项目
mvn compile//编译源代码
mvn test-compile//编译测试代码
mvn test//运行应用程序中的单元测试
mvn site//生成项目相关信息的网站
mvn package//依据项目生成jar文件
mvn install//在本地Repository中安装jar
mvn -Dmaven.test.skip=true//忽略测试文档编译
mvn clean//清除目标目录中的生成结果
mvn clean compile//将.java类编译为.class文件
mvn clean package//进行打包
mvn clean test//执行单元测试
mvn clean deploy//部署到版本仓库
mvn clean install//使其他项目使用这个jar,会安装到maven本地仓库中
mvn archetype:generate//创建项目架构
mvn dependency:list//查看已解析依赖
mvn dependency:tree//看到依赖树
mvn dependency:analyze//查看依赖的工具
mvn help:system//从中央仓库下载文件至本地仓库
mvn help:active-profiles//查看当前激活的profiles
mvn help:all-profiles//查看所有profiles
mvn help:effective-pom//查看完整的pom信息



mvn archetype：create创建Maven项目
mvn compile编译源代码
mvn deploy发布项目
mvn test-compile编译测试源代码
mvn test运行应用程序中的单元测试
mvn site生成项目相关信息的网站
mvn clean清除项目目录中的生成结果
mvn package根据项目生成的jar
mvn install在本地Repository中安装jar
mvn eclipse:eclipse生成eclipse项目文件
mvn jetty:run启动jetty服务
mvn tomcat:run启动tomcat服务
mvn clean package -Dmaven.test.skip=true:清除以前的包后重新打包，跳过测试类


通过控制台查看：
输入命令：mvn dependency:tree

如果要输出到文件，找到pom文件的位置 进入命令行
输入命令： mvn dependency:tree >d:/tree.txt

只查看关系的jar包
mvn dependency:tree -Dverbose -Dincludes=groupId:artifactId:version:artifactId:version
输入命令：
mvn dependency:tree -Dverbose -Dincludes=org.springframework:spring-tx


---------------------------------------------------------------------------------------------------------------------









---------------------------------------------------------------------------------------------------------------------

