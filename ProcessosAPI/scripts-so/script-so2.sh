	RED='\\033[0;31m'
	NC='\\033[0m' # No Color
	VERSAO=11

	echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Olá Aluno, serei seu assistente para instalação do Java e do Docker!;"
	echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Verificando aqui se você possui o Java e o Docker instalado...;"

	java -version
	docker --version
	echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Instalando versão necessária do java"
    sudo apt-get install oracle-java11-installer -y
	echo "(tpu setaf 10)[Bot assistant]:$(tput setaf 7 ) Vamos instalar o docker, e iremos rodar um .jar capturando as estatítiscas e informações da sua CPU!"
	sudo apt install docker.io
	echo "(tpu setaf 10)[Bot assistant]:$(tput setaf 7 ) Agora vamos baixar a imagem para coletar os dados da sua maquina!"
	sudo docker pull keepcode1/script_api:teste-api-0.1
	echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Agora vamos baixar nossa aplicação"
	cd ~
	cd Desktop
	mkdir -p ./KeepCode/appKcode
	cd KeepCode/appKcode
	git clone https://github.com/BandTec/KeepCode-Grupo-08.git
	echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Adicionando o repositório!"
	sleep 2
	cd KeepCode-Grupo-08/ProcessosAPI/target
	echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Executando o .jar"
	java -jar teste-api-1.0-SNAPSHOT-jar-with-dependencies.jar
	sleep 1
	echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Vamos iniciar o container e entrar no mysql"
	sleep 2
	sudo systemctl start docker
	sudo systemctl enable docker
	sudo docker run -d -p 1514:1514 --name mysql -e "MYSQL_DATABASE=banco1" -e "MYSQL_ROOT_PASSWORD=urubu100" mysql:5.7
	sudo docker exec -it mysql bash