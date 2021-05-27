echo "(tpu setaf 10)[Bot assistant]:$(tput setaf 7 ) Vamos começar clonando um repositório com o .jar de inserção no mysql e azure!"
cd ~
cd Desktop
mkdir -p ./Api-insercao-mysql
cd  Api-insercao-mysql
git clone https://github.com/Pinheiro-dev/AC3-SO.git
echo "(tpu setaf 10)[Bot assistant]:$(tput setaf 7 ) Vamos baixar e executar um container contendo nosso java .jar!"
cd AC3-SO/ProcessosAPI/target
sudo docker pull keepcode1/script_api:teste-api-0.1
sudo docker build -t api-mysql .
sudo docker run -d --name="mysql-with-jar" -t api-mysql
sudo docker cp teste-api-1.0-SNAPSHOT-jar-with-dependencies.jar mysql-with-jar:/
sudo docker exec -it mysql-with-jar java -jar teste-api-1.0-SNAPSHOT-jar-with-dependencies.jar