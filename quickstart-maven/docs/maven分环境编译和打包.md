1、添加插件和resources配置
<build>

    <!-- 最后生成的资源文件 -->
    <resources>
      <!-- 所有公共资源文件 -->
      <resource>
        <directory>src/main/resources</directory>
        <!-- 资源根目录排除各环境的配置，防止在生成目录中多余其它目录 -->
        <!-- <excludes>
           <exclude>dev/*</exclude>
           <exclude>test/*</exclude>
           <exclude>prod/*</exclude>
         </excludes>-->
      </resource>
      <!-- 不同环境的资源文件 -->
      <resource>
        <directory>src/main/filters/${build.environment}</directory>
      </resource>
    </resources>

    <plugins>
      <!-- 资源文件处理插件，必须配置 -->
      <plugin>
        <artifactId>maven-resources-plugin</artifactId>
        <configuration>
          <encoding>UTF-8</encoding>
        </configuration>
      </plugin>

    </plugins>

  </build>

2、添加profiles配置：build标签同级
 <profiles>

    <!-- 开发 -->
    <profile>
      <id>build-dev</id>
      <properties>
        <build.environment>dev</build.environment>
      </properties>
      <activation>
        <activeByDefault>true</activeByDefault>
      </activation>
    </profile>

    <!-- 测试 -->
    <profile>
      <id>build-test</id>
      <properties>
        <build.environment>test</build.environment>
      </properties>
      <!--      <activation>-->
      <!--        <activeByDefault>true</activeByDefault>-->
      <!--      </activation>-->
    </profile>

    <!-- 生产 -->
    <profile>
      <id>build-prod</id>
      <properties>
        <build.environment>prod</build.environment>
      </properties>
      <!--      <activation>-->
      <!--        <activeByDefault>true</activeByDefault>-->
      <!--      </activation>-->
    </profile>

  </profiles>


3、
在各个项目模块下面创建
目录：src/main/filters/
目录下再创建dev、test、prod等文件夹

