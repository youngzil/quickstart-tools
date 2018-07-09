官方插件示例地址：替换插件名称
https://maven.apache.org/plugins/maven-compiler-plugin/


os-maven-plugin
https://github.com/trustin/os-maven-plugin

Maven插件，用于设置从$ {os.name}和$ {os.arch}属性中检测到的各种有用属性。
os-maven-plugin是一个Maven的延伸/插件，其生成从归一化的各种有用的平台相关的项目属性${os.name}和${os.arch}。
${os.name}而且${os.arch}在JVM和操作系统版本之间常常有微妙的差别，或者它们有时包含机器不友好的字符，如空格。这个插件试图去除这样的碎片，以便可以可靠地确定当前的操作系统和体系结构。
生成的属性
os-maven-plugin 检测有关当前操作系统的信息，并将其归一化为更便携的操作系统。


插件	描述
maven-clean-plugin	编译后的清理目标，删除目标目录
maven-compiler-plugin 	编译 Java 源文件
maven-install-plugin
maven-surefile-plugin	运行JUnit单元测试，创建测试报告
maven-jar-plugin 	从当前项目构建 JAR 文件
maven-war-plugin	 从当前项目构建 WAR 文件
maven-deploy-plugin 部署jar、war包
maven-javadoc-plugin 	生成Javadoc包，产生用于该项目的 Javadoc
maven-source-plugin	生成源码包
maven-antrun-plugin	从构建所述的任何阶段运行一组 Ant 任务


maven-resources-plugin 实现资源文件过滤,使用resources标签
properties-maven-plugin 将这些配置信息独立出来，并按照不同环境进行归类，打包时候选择特定环境的配置文件


maven-assembly-plugin 根据文件配置打包应用，war、tar.gz等
maven-shade-plugin 将所有配置文件和依赖库文件全部放在一个jar包中,实现打包
maven-dependency-plugin 把依赖的jar拷贝到特定的文件夹


maven-checkstyle-plugin	使用规则文件（可自定义）进行代码检查
maven-pmd-plugin		使用pmd进行代码检查
findbugs-maven-plugin
sonar-maven-plugin
	
maven-scm-plugin		软件配置管理的（SCM：Software Configuration Management）功能



maven-gpg-plugin
maven-invoker-plugin
maven-repository-plugin

maven-help-plugin	查看插件help信息
exec-maven-plugin  通过命令行将打包后的程序执行
versions-maven-plugin	项目版本升级的时候，同时变更父模块和所有子模块中的版本号


maven-scm-plugin	软件配置管理的（SCM：Software Configuration Management）功能
https://blog.csdn.net/fenglibing/article/details/16842645


https://blog.csdn.net/xl890727/article/details/75110040
Maven CheckStyle插件提供两种预先定义的规则：sun_checks.xml和google_checks.xml(http://checkstyle.sourceforge.net/google_style.html)，默认提供的为sun_checks.xml。当然你也可以指定自定义的规则集。
http://checkstyle.sourceforge.net/sun_style.html
http://checkstyle.sourceforge.net/google_style.html
http://google.github.io/styleguide/javaguide.html
mvn checkstyle:help 查看帮助
mvn checkstyle:check 查看工程是否满足检查。如果不满足，检查失败，可以通过target/checkstyle-result.xml来查看
mvn checkstyle:checkstyle 查看工程是否满足检查。如果不满足，不会失败，可以通过target/site/checkstyle.html查看检查信息
mvn checkstyle:checkstyle-aggregate 检查工程是否满足检查。如果不满足，不会失败，可以通过target/site/checkstyle.html查看

在用checkstyle命令检查之后，采用html的方式查看检查结果。结果中只会提示在哪一行，不能直接看代码。这时候可以添加Maven插件
<reporting>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-jxr-plugin</artifactId>
      <version>${maven.jxr.version}</version>
    </plugin>
  </plugins>
</reporting>
执行mvn jxr:jxr之后，就可以查看对应的代码。

打包方法：
方法一：使用maven-jar-plugin和maven-dependency-plugin插件打包
方法二：使用maven-assembly-plugin插件打包
方法三：使用maven-shade-plugin插件打包






在描述插件的时候，还可以省去版本信息，让Maven自动获取最新版本来进行表述，例如：
$ mvn help:describe -Dplugin=org.apache.maven.plugins:maven-compiler-plugin
进一步简化，可以使用插件目标前缀替换坐标:
$ mvn help:describe -Dplugin=compiler
如果想仅仅描述某个插件目标的信息，可以加上goal参数：
$ mvn help:describe -Dplugin=compiler -Dgoal=compile
如果想让maven-help-plugin输出更详细的信息，可以加上detail参数：
$ mvn help:describe -Dplugin=compiler -Ddetail

比如， 下面的命令使用 help 插件的目标来输出Maven Help 插件的信息。
mvn help:describe -Dplugin=help  

通过设置plugin参数来运行describe目标，输出为该插件的Maven坐标，目标前缀，和该插件的一个简要介绍。如果你想要 Help 插件输出完整的带有参数的目标列表，只要运行带有参数full的help:describe 目标就可以了,
mvn help:describe -Dplugin=help -Dfull  

该选项能让你查看插件所有的目标及相关参数。但是有时候这些信息显得太多了。这时候你可以获取单个目标的信息，设置 mojo 参数和参数。下面的命令列出了Compiler 插件的compile目标的所有信息(在maven里一个插件目标也被认为是一个mojo)
mvn help:describe -Dplugin=compiler -Dmojo=compile -Dfull  

mvn help:describe -Dplugin=source -Ddetail


Maven打包的三种方式：https://blog.csdn.net/daiyutage/article/details/53739452


maven插件介绍
https://blog.csdn.net/enweitech/article/details/67631997
https://blog.csdn.net/zhen_6137/article/details/53096484











