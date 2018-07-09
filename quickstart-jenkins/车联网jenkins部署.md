



亚信云部署：
构建后执行（清空本地临时文件夹，把代码复制到临时文件夹，把配置文件复制（替换）到临时文件夹，删除本地仓库jar（重新下载），执行maven打包）
rm -rf /home/aitest/.jenkins/workspace/temp
cp -r /home/aitest/.jenkins/workspace/ddmp-server/ /home/aitest/.jenkins/workspace/temp/
cp -r /home/aitest/work/server_res4ai_cloud/* /home/aitest/.jenkins/workspace/temp/ddmp-server/src/main/resources/
rm -rf /home/aitest/.jenkins/workspace/ddmp-server/repository/com/ai
mvn -f /home/aitest/.jenkins/workspace/temp/ddmp-server/pom.xml -s /home/aitest/work/settings_server.xml clean install -Dmaven.test.skip=true

登录远程主机：（先停掉服务，再启动）
cd /aifs01/work/bin
sh stop_server1.sh
sh stop_server2.sh
sleep 3
sh start_server1.sh
sh start_server2.sh
