参考
http://codingo.xyz/index.php/2017/06/06/ivy_eclipse/

默认ivysettings.xml
ivy默认的公共库以及本地的cache路径在ivy-2.4.0.jar中可以找到，路径如下：org/apache/ivy/core/settings目录下

ivysettings.xml默认配置如下：
<ivysettings>
    <settings defaultResolver="default"/>
    <include url="${ivy.default.settings.dir}/ivysettings-public.xml"/>
    <include url="${ivy.default.settings.dir}/ivysettings-shared.xml"/>
    <include url="${ivy.default.settings.dir}/ivysettings-local.xml"/>
    <include url="${ivy.default.settings.dir}/ivysettings-main-chain.xml"/>
    <include url="${ivy.default.settings.dir}/ivysettings-default-chain.xml"/>
</ivysettings>

ivysettings-public.xml配置如下：
<ivysettings>
    <resolvers>
        <ibiblio name="public" m2compatible="true"/>
    </resolvers>
</ivysettings>
public配置让我们在没有指定公共库的情况下去https://repo1.maven.org/maven2下载包


用户自定义ivysettings.xml
以上对ivysettings.xml的标签以及属性有了详细的了解，下面自定义ivysettings.xml，使用公共库为阿里云提供
<ivysettings>
    <settings   
        defaultResolver="Client"/>   
    <caches
        resolutionCacheDir="${basedir}/ivy-resolution"
        repositoryCacheDir="D:/ivy/myRepositories/ivy-cache"
        defaultCacheDir="D:/ivy/myRepositories/ivy-cache"
        useOrigin="true"/>
 
    <resolvers>
        <chain name="Client">
            <ibiblio name="nexus-aliyun" m2compatible="true"
      root="http://maven.aliyun.com/nexus/content/groups/public/"/>
        </chain>           
    </resolvers>
</ivysettings>
公共库指定了http://maven.aliyun.com/nexus/content/groups/public/，由阿里云提供；将自定义的ivysettings.xml放入D:/ivy目录下，然后在eclipse中配置window->Preferences->Ivy->Settings->Ivy settings path->File system…将自定义的ivysettings.xml添加进去，此时再次右击ivy.xml->Add Library…将从aliyun公共库下载，本地缓存在D:/ivy/myRepositories目录下。



