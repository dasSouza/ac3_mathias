echo "(tpu setaf 10)[Bot assistant]:$(tput setaf 7 ) Vamos iniciar stopando o serviço do mysql iniciado anteriormente!"
sudo docker stop mysql
sleep 2
echo "(tpu setaf 10)[Bot assistant]:$(tput setaf 7 ) Agora iniciaremos um container com o mysql dentro."
cd Desktop
cd KeepCode
sudo docker pull keepcode1/mysql-banco-create:banco
sudo docker build -t keepcode1/mysql-banco-create:banco .
sudo docker cp banco.sql /docker-entrypoint-initdb.d/
sudo docker run -d -t -p 3306:3306 --name=mysql4 banco
sudo docker exec -it mysql4 bash
