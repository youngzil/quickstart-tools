Maven工程标准架构 
目录	备注
${basedir}	存放 pom.xml和所有的子目录
${basedir}/src/main/resources	项目的资源，如spring配置文件，properties资源文件等
${basedir}/src/main/webapps	web项目特有
${basedir}/src/test/java	项目的测试类，比如说 JUnit代码、TestNg代码
${basedir}/src/test/resources	测试代码使用的资源


打包：
mvn clean compile  -DskipTests -U -X -e 

mvn clean compile
mvn clean package
mvn clean install

-DskipTests
-Dmaven.test.skip=true  
-DskipTests=false  开启测试

使用-U参数： 该参数能强制让Maven检查所有SNAPSHOT依赖更新，确保集成基于最新的状态，如果没有该参数，Maven默认以天为单位检查更新，而持续集成的频率应该比这高很多。
使用-X参数：开启DEBUG模式。
使用-e参数：如果构建出现异常，该参数能让Maven打印完整的stack trace，以方便分析错误原因。
使用-B参数：该参数表示让Maven使用批处理模式构建项目，能够避免一些需要人工参与交互而造成的挂起状态。


