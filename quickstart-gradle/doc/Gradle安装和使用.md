https://www.zybuluo.com/dume2007/note/670069

Gradle 是一款基于 Groovy 语言、免费开源的构建工具，它既保持了 Maven 的优点，又通过使用 Groovy 定义的 DSL ，克服了 Maven 中使用 XML 繁冗以及不灵活的缺点。

Gradle 官方网站：http://www.gradle.org/downloads

Mac 上安装
$ brew install gradle

Windows系统的包管理器Chocolatey
https://www.zybuluo.com/dume2007/note/668357
Windows安装
Chocolatey是windows下的包管理器
C:\> choco install gradle



简单使用
Gradle 使用 约定优于配置(Convention over Configuration)的理念。使用与maven兼容的目录结构布局。完全按照约定的目录结构来布置工程文件，会大大简化编译配置文件。

除了常见的src/main/java等目录，默认的 web 应用程序根目录为 src/main/webapp，也就是包含 WEB-INF 目录的上一级目录。如果工程没有完全依照约定布局，可以通过脚本文件指定相应的路径。

Gradle 中有两个最基本的对象：project 和 task。每个 Gradle 的构建由一个 project 对象来表达，它代表着需要被构建的组件或者构建的整个项目。每个 project 对象由一个或者多个 task 对象组成。

Gradle 已经自带了很多 pugins，可以满足大部分的常见构建任务。

Gradle 的默认构建脚本文件为工程根目录下的 build.gradle。



Gradle 期望在 src/main/java 路径下找到你项目的源代码，并且测试在 src/test/java 路径下的代码。同时，在src/main/resources 路径下的文件也会作为资源文件包含在JAR包中，并且 src/test/resources 下的所有文件会包含在 classpath下以运行测试程序。所有的输出文件都生成在 build 目录下，JAR 包生成在 build/libs 目录下。



常用的依赖：
（1）compile：编译生产代码的依赖环境，即src/main/下 
（2）runtime：生产代码运行时的依赖（包含编译生产代码时的依赖） 
（3）testCompile：编译测试代码的依赖环境，即src/test下 
（4）testRuntime：测试代码运行时的依赖（包含编译测试代码时的依赖）


可以使用 gradle templates 创建项目目录结构
https://github.com/townsfolk/gradle-templates















