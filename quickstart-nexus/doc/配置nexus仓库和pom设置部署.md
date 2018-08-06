创建proxy仓库
选择maven2(proxy)

创建local发布仓库
选择maven2(hosted)
设置Version policy选择Release（只能发布发布版本jar）或者Snapshot（快照版本jar）、Mixed（混合的）
设置Layout policy 为strict（严格的）、Permissive（宽容的）
设置Deployment poicy为Allow redeploy


注意：快照版本和Release版本是在两个仓库中


设置maven的settings.xml
<servers>
<server>
      <id>nexus-release</id>
      <username>admin</username>
      <password>admin123</password>
     </server>
    <server>
      <id>nexus-test</id>
      <username>admin</username>
      <password>admin123</password>
     </server>
  </servers>


设置项目的pom.xml文件
<distributionManagement>
	<repository>
		<id>nexus-release</id>
		<name>Nexus Snapshot</name>
		<url>http://10.11.20.102:8081/repository/maven-releases/</url>
	</repository>
	<snapshotRepository>
		<id>nexus-test</id>
		<name>Nexus Snapshot</name>
		<url>http://10.11.20.102:8081/repository/maven-snapshots/</url>
	</snapshotRepository>
</distributionManagement>


执行pom.xml
Goals输入 ： deploy -e     或者clean deploy 后，点击 Run



项目中引用

<repositories>
	<repository>
		<id>test-public-repository</id>
			<url>http://10.11.20.102:8081/repository/maven-public/</url>
	</repository>
</repositories>

<dependencies>
<dependency>
		<groupId>org.quickstart</groupId>
		<artifactId>quickstart-nexus</artifactId>
		<version>0.0.1-SNAPSHOT</version>
	</dependency>
</dependencies>


1、maven deploy 已存在的包的时候出现400错误，可能原因：
原因是 release 默认库是不允许重复部署的
maven deploy 已存在的包的时候出现400异常
或者
Deployment Policy:Allow Redeploy
maven deploy 已存在的包的时候出现400异常

2、Nexus预定义了3个本地仓库，分别为Releases，Snapshots，和3rd Party。这三个仓库都有各自明确的目的。Releases用于部署我们自己的release构件，Snapshots用于部署我们自己的snapshot构件，而3rd Party用于部署第三方构件，有些构件如Oracle的JDBC驱动，我们不能从公共仓库下载到，我们就需要将其部署到自己的仓库中。

3、maven2(proxy)这里就是代理的意思，代理中央Maven仓库，当PC访问中央库的时候，先通过Proxy下载到Nexus仓库，然后再从Nexus仓库下载到PC本地。
这样的优势只要其中一个人从中央库下来了，以后大家都是从Nexus私服上进行下来，私服一般部署在内网，这样大大节约的宽带。





