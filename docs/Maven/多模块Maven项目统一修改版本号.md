
配置mvn环境变量，并检验
mvn -version


在项目的根目录的pom文件，加入如下插件
<build>
    <plugins>
        <plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>versions-maven-plugin</artifactId>
            <version>2.8.1</version>
            <configuration>
                <generateBackupPoms>false</generateBackupPoms>  <!--//是否加入备份-->
            </configuration>
        </plugin>
    </plugins>
</build>



设置新版本号
mvn versions:set -DnewVersion=3.0.3 


更新所有子 Module 的版本
mvn versions:update-child-modules
mvn -N versions:update-child-modules 


更新顶级项目的parent版本
在使用Spring Boot的多Module项目时，我们可能需要更新项目所依赖的Spring Boot版本。我们可以使用如下命令来进行更新。
mvn versions:update-parent


在修改完成后，如果你对所做的更改不满意，还可以用进行回滚
mvn versions:revert

如果满意则可以进行提交，相当的强大
mvn versions:commit




[MAVEN -- 对maven项目的版本进行统一升级和修改](https://blog.csdn.net/luzhensmart/article/details/108781898)  
[maven—多模块项目版本号更新命令](https://www.jianshu.com/p/1d51d6b7e856)
[maven如何动态统一修改版本号](https://cloud.tencent.com/developer/article/1765010)

