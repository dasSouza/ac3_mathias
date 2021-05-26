#!/bin/bash

VERSION=20

echo "Olá Aluno, serei seu assistente para instalação do Docker!;"
echo "Verificando aqui se você possui o Docker instalado...;"

docker --version
if [ $? -eq 0 ]; then
	echo "Olá você já tem o Docker instalado!!"
	echo "Obrigado por baixar o docker"
	echo "A aplicação será iniciada, deseja iniciar agora (S/N)?"
	read inst
	if [ \"$inst\" == \"s\" ]; then
		echo "Vamos iniciar o Docker"
		sleep 2
		sudo systemctl start docker
		sudo systemctl enable docker
		systemctl -t service
		echo "Docker iniciado com sucesso"
	else
		echo " Você decidiu não instalar o docker."
	fi
else
	echo "Deseja baixar o Docker (S/N)?"
	read inst
	sleep 2
	if [ \"$inst\" == \"s\" ]; then
		mkdir -p ./KeepCode/docker
		cd KeepCode/appKcode
		sudo apt install docker.io
		echo "A aplicação foi baixada com sucesso"
		echo "A aplicação será iniciada, deseja iniciar agora (S/N)?"
		read inst
		if [ \"$inst\" == \"s\" ]; then
			echo "Vamos iniciar o Docker"
			sleep 2
			sudo systemctl start docker
			sudo systemctl enable docker
			systemctl -t service
			echo "Docker iniciado com sucesso"
		else
			echo " Você decidiu não instalar o docker."
		fi
	else
		echo "Você decidiu não instalar o Docker"
	fi

	echo " Obrigado por usar nossa aplicação"

fi
