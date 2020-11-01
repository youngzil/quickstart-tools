下面随便找了一个jar包为例，导入到本地maven仓库。

jar文件：aether-util-0.9.0.M2.jar 
存放位置：H:\test

打开CMD，进入到H:\test目录，然后执行下面命令： 
mvn install:install-file -DgroupId=org.eclipse.aether -DartifactId=aether-util -Dversion=0.9.0.M2 -Dpackaging=jar -DgeneratePom=true -Dfile=aether-util-0.9.0.M2.jar

其中我们需要知道官方的groupId、artifactId、version



uspa-1.0.SNAPSHOT.jar



