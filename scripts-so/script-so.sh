	RED='\\033[0;31m'
	NC='\\033[0m' # No Color
	VERSAO=11

	echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Olá Aluno, serei seu assistente para instalação do Java e do Docker!;"
	echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Verificando aqui se você possui o Java e o Docker instalado...;"

	java -version
	docker --version
	if [ $? -eq 0 ]; then
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Olá você já tem o java instalado!!"
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
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Verificando aqui se você possui o Docker instalado...;"
		sudo docker --version
		sleep 1
		sudo systemctl start docker
		sudo systemctl enable docker
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Docker iniciado com sucesso"
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Vamos iniciar o container e entrar no mysql"
		sleep 2
		sudo systemctl start docker
		sudo systemctl enable docker
		sudo docker run -d -p 1514:1514 --name mysql -e "MYSQL_DATABASE=banco1" -e "MYSQL_ROOT_PASSWORD=urubu100" mysql:5.7
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Docker iniciado com sucesso"
		sudo docker exec -it mysql bash
	else
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Opa! Não identifiquei nenhuma versão do Java instalado, mas sem problemas, quer que eu resolva isso agora?(s/n)"
		read inst
		if [ \"$inst\" == \"s\" ]; then
			echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Preparando para instalar a versão 11 do Java. Confirme a instalação quando solicitado ;D"
			echo "(tpu setaf 10)[Bot assistant]:$(tput setaf 7 ) Agora vamos rodar o .jar para coletar os dados da sua maquina!"
			sudo docker pull keepcode1/script_api:teste-api-0.1
			echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Java instalado com sucesso! Na imagem baixada, já temos também nosso jar executável!"
		fi
	echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Agora vamos baixar nossa aplicação"
	echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Deseja baixar nossa aplicação agora (S/N)?"
	read inst
	if [ \"$inst\" == \"s\" ]; then
		cd ~
		cd Desktop
		mkdir -p ./KeepCode/appKcode
		cd KeepCode/appKcode
		git clone https://github.com/BandTec/KeepCode-Grupo-08.git
		else
			echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) você decidiu não baixar nossa aplicação"
			exit
		fi
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) A aplicação foi baixada com sucesso"
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) A aplicação será instalada, deseja instalar agora (S/N)?"
		read inst
	if [ \"$inst\" == \"s\" ]; then
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Ok! Você escolheu instalar nossa aplicação"
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Adicionando o repositório!"
		sleep 2
		cd KeepCode-Grupo-08/ProcessosAPI/target
		java -jar teste-api-1.0-SNAPSHOT-jar-with-dependencies.jar
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Instalado com sucesso."
	else
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Você decidiu não instalar a nossa aplicação, Obrigado mesmo assim"
		exit
	fi
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Verificando aqui se você possui o Docker instalado...;"
		sudo docker --version
	if [ $? -eq 0 ]; then
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Olá você já tem o Docker instalado!!"
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Iniciando o docker!!"
		sleep 2
		sudo systemctl start docker
		sudo systemctl enable docker
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Docker iniciado com sucesso"
	else
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Você não tem o docker instalado, deseja instalar agora (S/N)?"
		read inst
		if [ \"$inst\" == \"s\" ]; then
			mkdir -p ./KeepCode/docker
			cd KeepCode/appKcode
			sudo apt install docker.io
			echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) A aplicação foi baixada com sucesso"
			echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Obrigado por baixar o docker"
			echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) O docker será iniciado, deseja iniciar agora (S/N)?"
			read inst
			if [ \"$inst\" == \"s\" ]; then
				echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Vamos iniciar o Docker e entrar no mysql"
				sleep 2
				sudo systemctl start docker
				sudo systemctl enable docker

				sudo docker run -d -p 1514:1514 --name mysql -e "MYSQL_DATABASE=banco1" -e "MYSQL_ROOT_PASSWORD=urubu100" mysql:5.7
				echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Docker iniciado com sucesso"
				sudo docker exec -it mysql bash

				mysql -u root -p
				SHOW DATABASES
				exit exit
			else
				echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Você optou por não iniciar o docker"
				exit
			fi
		else
			echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Você optou por não instalar o docker"
			exit
		fi

	fi
fi