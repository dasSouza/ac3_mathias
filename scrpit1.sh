

#!/bin/bash



PURPLE='0;35'

NC='\033[0m'

VERSAO=11



echo "Olá Aluno, serei seu assistente para instalação do Java!;"

echo "Verificando aqui se você possui o Java instalado...;"



java --version

if [ $? -eq 0 ]; then

	echo "Olá você já tem o java instalado!!"



	echo "Deseja baixar nossa aplicação agora (S/N)?"

	read inst

	if [ \"$inst\" == \"s\" ]; then

		mkdir -p ./KeepCode/appKcode

		cd KeepCode/appKcode

		git clone https://github.com/BandTec/KeepCode-Grupo-08/blob/LigacaoDocker/ProcessosAPI/target/teste-api-1.0-SNAPSHOT-jar-with-dependencies.jar

		echo "A aplicação foi baixada com sucesso"

	else

		echo "você decidiu não baixar nossa aplicação"

	fi

	echo " :A aplicação será instalada, deseja instalar agora (S/N)?"

	read inst

	if [ \"$inst\" == \"s\" ]; then

		echo "Ok! Você escolheu instalar nossa aplicação"

		echo "Adicionando o repositório!"

		sleep 2

		cd /KeepCode/appKcode/

		java -jar Desktop/KeepCode/appKcode/teste-api-1.0-SNAPSHOT-jar-with-dependencies.jar

		clear

		echo "Instalado com sucesso."

	else

		echo "Você decidiu não instalar a nossa aplicação, Obrigado mesmo assim."

	fi

else

	echo "Opa! Não identifiquei nenhuma versão do Java instalado, mas sem problemas, irei resolver isso agora!"

	echo "Confirme para mim se realmente deseja instalar o Java (S/N)?"

	read inst

	if [ \"$inst\" == \"s\" ]; then

		echo "Ok! Você escolheu instalar o Java ;D"

		echo "Adicionando o repositório!"

		sleep 2



		clear

		echo "Atualizando! Quase lá."

		sleep 2

		sudo apt update -y

		clear



		if [ $VERSAO -eq 11 ]; then

			echo "Preparando para instalar a versão 11 do Java. Confirme a instalação quando solicitado ;D"

			sudo apt install default-jre

			apt install openjdk-11-jre-headless -y

			sudo add-apt-repository ppa:webupd8team/java -y

			clear

			echo "Java instalado com sucesso!"

		fi

	else

		echo "Você optou por não instalar o Java por enquanto, até a próxima então!"

	fi

fi



# ===================================================================

# Todos direitos reservados para o autor: Dra. Profa. Marise Miranda.

# Sob licença Creative Commons @2020

# Podera modificar e reproduzir para uso pessoal.

# Proibida a comercialização e a exclusão da autoria.

# ===================================================================
