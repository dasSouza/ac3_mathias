echo "(tpu setaf 10)[Bot assistant]:$(tput setaf 7 ) Vamos iniciar stopando o serviço do mysql iniciado anteriormente!"
sudo docker stop mysql
sleep 2
echo "(tpu setaf 10)[Bot assistant]:$(tput setaf 7 ) Agora iniciaremos um container com o mysql dentro."
sudo systemctl start docker
sudo systemctl enable docker
sudo docker run -d -p 3306:3306 --name mysql -e "MYSQL_DATABASE=banco1" -e "MYSQL_ROOT_PASSWORD=urubu100" mysql:5.7
sudo docker exec -it mysql bash

