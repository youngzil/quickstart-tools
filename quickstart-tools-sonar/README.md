https://www.sonarqube.org/
https://www.sonarqube.org/downloads/


https://www.sonarsource.com/


https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner
https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner+for+Ant
https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner+for+Maven
https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner+for+Gradle
https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner+for+Jenkins
https://docs.sonarqube.org/display/PLUG/Plugin+Library


https://github.com/SonarSource/sonarqube


https://github.com/SonarSource/docker-sonarqube
https://github.com/SonarSource/sonarlint-intellij
https://github.com/SonarSource/SonarJS
https://github.com/SonarSource/sonarlint-eclipse



https://www.oschina.net/p/sonar

Sonar (SonarQube)是一个开源平台，用于管理源代码的质量。Sonar 不只是一个质量数据报告工具，更是代码质量管理平台。支持的语言包括：Java、PHP、C#、C、Cobol、PL/SQL、Flex 等。

开源中国代码质量管理系统 -> http://sonar.oschina.net/
主要特点：
代码覆盖：通过单元测试，将会显示哪行代码被选中
改善编码规则
搜寻编码规则：按照名字，插件，激活级别和类别进行查询
项目搜寻：按照项目的名字进行查询
对比数据：比较同一张表中的任何测量的趋势



配置插件
a）插件介绍
Sonar支持多种插件，插件的下载地址为：http://docs.codehaus.org/display/SONAR/Plugin+Library
将下载后的插件上传到${SONAR_HOME}extensions\plugins目录下，重新启动sonar。
sonar默认集成了Java Ecosystem插件，该插件是一组插件的合集
Java [sonar-java-plugin]：java源代码解析，计算指标等
Squid [sonar-squid-java-plugin]：检查违反Sonar定义规则的代码
Checkstyle [sonar-checkstyle-plugin]：使用CheckStyle检查违反统一代码编写风格的代码
FindBugs [sonar-findbugs-plugin]：使用FindBugs检查违反规则的缺陷代码
PMD [sonar-pmd-plugin]：使用pmd检查违反规则的代码
Surefire [sonar-surefire-plugin]：使用Surefire执行单元测试
Cobertura [sonar-cobertura-plugin]：使用Cobertura获取代码覆盖率
JaCoCo [sonar-jacoco-plugin]：使用JaCOCO获取代码覆盖率

下面列出了一些常用的插件：
JavaScript代码检查：http://docs.codehaus.org/display/SONAR/JavaScript+Plugin
python代码检查：http://docs.codehaus.org/display/SONAR/Python+Plugin
Web页面检查（HTML、JSP、JSF、Ruby、PHP等）：http://docs.codehaus.org/display/SONAR/Web+Plugin
xml文件检查：http://docs.codehaus.org/display/SONAR/XML+Plugin
scm源码库统计分析：http://docs.codehaus.org/display/SONAR/SCM+Stats+Plugin
文件度量：http://docs.codehaus.org/display/SONAR/Tab+Metrics+Plugin
中文语言包：http://docs.codehaus.org/display/SONAR/Chinese+Pack
时间表显示度量结果：http://docs.codehaus.org/display/SONAR/Timeline+Plugin
度量结果演进图：http://docs.codehaus.org/display/SONAR/Motion+Chart+Plugin
b）插件配置示例（本段内容来自http://www.ibm.com/developerworks/cn/java/j-lo-sonar/）

Sonar 的主要特色是对不同工具产生的检查结果进行再加工处理，Sonar 还向用户提供了对数据进行个性化处理的方法。










