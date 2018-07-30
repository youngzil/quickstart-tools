学习指导：
https://github.com/DONGChuan/GradleUserGuide
https://dongchuan.gitbooks.io/gradle-user-guide-/

Gradle In Action(Gradle实战)中文版
https://github.com/EZLippi/GradleInActionZh
https://lippiouyang.gitbooks.io/gradle-in-action-cn

可以使用 gradle templates 创建项目目录结构
https://github.com/townsfolk/gradle-templates


//新业务对接isee
allprojects  {
  apply plugin: 'maven'
  apply plugin: 'java'
  repositories {
    maven { url "http://nexus.zj.chinamobile.com:8081/nexus/content/groups/public/" }
  }
  tasks.withType(JavaCompile) {
                options.encoding = "UTF-8"
  }
  configurations.all {
      resolutionStrategy.cacheDynamicVersionsFor 10, 'minutes' 
  }
  configurations.all {
    resolutionStrategy.cacheChangingModulesFor 2, 'hours'
  } 



def env = System.getProperty("env") ?: "dev"
apply from: "profile-${env}.gradle"
apply from: "build-msp.gradle"




buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.3.0'
        classpath 'com.novoda:bintray-release:0.4.0'

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        jcenter()
        maven {url 'https://dl.bintray.com/calvinning/maven'}
    }
}
那么buildscript中的repositories和allprojects的repositories的作用和区别是什么呢？
答：
1、 buildscript里是gradle脚本执行所需依赖，分别是对应的maven库和插件
2、 allprojects里是项目本身需要的依赖，比如我现在要依赖我自己maven库的toastutils库，那么我应该将maven {url 'https://dl.bintray.com/calvinning/maven'}写在这里，而不是buildscript中，不然找不到。


