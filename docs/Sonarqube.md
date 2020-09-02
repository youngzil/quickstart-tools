1、使用Docker安装Sonarqube


---------------------------------------------------------------------------------------------------------------------

使用Docker安装Sonarqube



docker search sonarqube
docker pull sonarqube
docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 sonarqube

docker stop CONTAINER_ID
#重启容器
docker restart CONTAINER_ID 

访问地址：
http://localhost:9000





安装参考
https://cloud.tencent.com/developer/article/1683115


docker安装和启动参考
/Users/yangzl/git/quickstart-container/docs/docker/Docker安装.md


Linux防火墙端口开放参考
/Users/yangzl/git/quickstart-framework/quickstart-linux/docs/linux/learn/Linux防火墙操作.md

---------------------------------------------------------------------------------------------------------------------



