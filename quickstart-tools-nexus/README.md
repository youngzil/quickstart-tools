http://www.sonatype.org/nexus/

Nexus 官网：
https://www.sonatype.com/


https://github.com/sonatype/


http://books.sonatype.com/nexus-book/3.0/reference/install.html#installation-archive

Nexus3下载地址：https://support.sonatype.com/hc/en-us/articles/218637467-Download-Nexus-Repository-Manager-3 
Nexus3使用文档：http://books.sonatype.com/nexus-book/reference3/

下载：
https://www.sonatype.com/download-oss-sonatype


启动服务bin/nexus {start|stop|run|run-redirect|status|restart|force-reload}
bin/nexus run

默认账号：
admin/admin123

Nexus默认的端口是8081，可以在etc/nexus-default.properties配置中修改。
修改配置
 vi etc/nexus-default.properties 
 nexus-work=/home/aifqa/msgframe/nexus-3.6.2-01/store
  nexus-work好像没有生效，nexus的jar存放路径在哪里？？
 


默认端口号：8081，防火墙开放8081端口
sudo firewall-cmd --permanent --add-port=8081/tcp
sudo systemctl reload firewalld


安装后默认存在几个仓库
maven-public---group仓库，包含以下三个仓库，面向外部的URL

maven-releases---hosted的Release仓库
maven-snapshots---hosted的Snapshot仓库
maven-central---proxy的Release仓库https://repo1.maven.org/maven2/的proxy


---------------------------------------------------------------------------
参考文章
http://www.jianshu.com/p/2dc35820c523
http://blog.csdn.net/xjping0794/article/details/78228957
https://www.cnblogs.com/kevingrace/p/6201984.html

把 Nexus 加入系统服务
建立服务文件：/opt/nexus/nexus-2.14.2-01/bin/nexus start

vi /lib/systemd/system/nexus.service

// 添加如下内容
[Unit]
Description=Nexus Service
After=network.target

[Service]
Type=forking
ExecStart=/opt/nexus/nexus-2.14.2-01/bin/nexus start
ExecReload=/opt/nexus/nexus-2.14.2-01/bin/nexus restart
ExecStop=/opt/nexus/nexus-2.14.2-01/bin/nexus  stop
PrivateTmp=true

[Install]
WantedBy=multi-user.target
配置nexus.service文件权限

# chomd 754 nexus.service
设置开机自启动

# systemctl enable nginx.service
如果是使用root用户启动nexus，请添加系统环境变量：
RUN_AS_USER=root

---------------------------------------------------------------------------

Nexus仓库
　　nexus的仓库类型分为以下四种：
　　　　group: 仓库组
　　　　hosted：宿主
　　　　proxy：代理
　　　　virtual：虚拟
　　首次登陆nexus后可以看到以下一个仓库组和多个仓库：
　　　　Public Repositories: 仓库组(项目中如果要下载构件的话，配置文件中一般都用仓库组的URL)
　　　　3rd party: 无法从公共仓库获得的第三方发布版本的构件仓库（如oracle驱动）
　　　　Apache Snapshots: 用了代理ApacheMaven仓库快照版本的构件仓库（别忘了更新索引）
　　　　Central: 用来代理maven中央仓库中发布版本构件的仓库（别忘了更新索引）
　　　　Central M1 shadow: 用于提供中央仓库中M1格式的发布版本的构件镜像仓库（一般不用管）
　　　　Releases: 用来部署您公司的发布版本构件的宿主类型仓库（重要）
　　　　Snapshots:用来部署您公司的快照版本构件的宿主类型仓库（重要）

　　您也可以添加仓库组或者代理仓库（如阿里云maven仓库），其他的看情况吧。

这里就是代理的意思，代理中央Maven仓库，当PC访问中央库的时候，先通过Proxy下载到Nexus仓库，然后再从Nexus仓库下载到PC本地。
这样的优势只要其中一个人从中央库下来了，以后大家都是从Nexus私服上进行下来，私服一般部署在内网，这样大大节约的宽带。





代理网络
 <proxies>
    <!-- proxy
     | Specification for one proxy, to be used in connecting to the network.
     |
    <proxy>
      <id>optional</id>
      <active>true</active>
      <protocol>http</protocol>
      <username>proxyuser</username>
      <password>proxypass</password>
      <host>proxy.host.net</host>
      <port>80</port>
      <nonProxyHosts>local.net|some.host.com</nonProxyHosts>
    </proxy>
    -->
       <proxy>    
     <id>myProxy</id>    
     <active>true</active>    
     <protocol>http</protocol>    
     <host>proxy.asiainfo.com</host>    
     <port>8080</port>    
     <username></username>    
     <password></password>    
     
   </proxy>   
  </proxies>




