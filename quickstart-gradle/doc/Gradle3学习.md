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


