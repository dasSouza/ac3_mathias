#!/bin/bash

PURPLE='0;35'
NC='\033[0m'
VERSAO=11

echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Olá Aluno, serei seu assistente para instalação do Java!;"
echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Verificando aqui se você possui o Java instalado...;"

java --version
if [ $? -eq 0 ]; then
	echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) : Olá você já tem o java instalado!!"

	echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) : Deseja baixar nossa aplicação agora (S/N)?"
	read inst
	if [ \"$inst\" == \"s\" ]; then
		mkdir -p ./KeepCode/appKcode
		cd KeepCode/appKcode
		git clone https://github.com/MarcioIoT/NmonVisualizer.git
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) : A aplicação foi baixada com sucesso"
	else
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) : você decidiu não baixar nossa aplicação"
	fi
	echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) : A aplicação será instalada, deseja instalar agora (S/N)?"
	read inst
	if [ \"$inst\" == \"s\" ]; then
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Ok! Você escolheu instalar nossa aplicação"
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Adicionando o repositório!"
		sleep 2
		cd /KeepCode/appKcode/NmonVisualizer
		java -jar NMONVisualizer_2020-02-29.jar
		clear
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Instalado com sucesso."
	else
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Você decidiu não instalar a nossa aplicação, Obrigado mesmo assim."
	fi
else
	echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Opa! Não identifiquei nenhuma versão do Java instalado, mas sem problemas, irei resolver isso agora!"
	echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Confirme para mim se realmente deseja instalar o Java (S/N)?"
	read inst
	if [ \"$inst\" == \"s\" ]; then
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Ok! Você escolheu instalar o Java ;D"
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Adicionando o repositório!"
		sleep 2
		sudo add-apt-repository ppa:webupd8team/java -y
		clear
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Atualizando! Quase lá."
		sleep 2
		sudo apt update -y
		clear

		if [ $VERSAO -eq 11 ]; then
			echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Preparando para instalar a versão 11 do Java. Confirme a instalação quando solicitado ;D"
			sudo apt install default-jre
			apt install openjdk-11-jre-headless
			-y
			clear
			echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) Java instalado com sucesso!"
		fi
	else
		echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7)  Você optou por não instalar o Java por enquanto, até a próxima então!"
	fi
fi

# ===================================================================
# Todos direitos reservados para o autor: Dra. Profa. Marise Miranda.
# Sob licença Creative Commons @2020
# Podera modificar e reproduzir para uso pessoal.
# Proibida a comercialização e a exclusão da autoria.
# ===================================================================
