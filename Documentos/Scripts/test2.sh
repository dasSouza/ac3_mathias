#!/bin/bash

  echo Bem vindo ao Assistente de instala��o do KeepCode
  echo Com ele voc� poder� instalar e atualizar os recursos 
  echo necess�rios para utilizar nossa aplica��o funcionar
  echo come�ando...
sleep 3
sudo apt-get update
sudo apt-get dist-upgrade -y
java -version
if [ $? -eq 0 ]
then
echo \"java instalado\"
else
echo \"java n�o instalado\"
echo \"gostaria de instalar o java? S/n \"
read inst
if [ \"$inst\" == \"s\" ]
then
echo \"voce escolheu instalar o java\"
echo \"instalado repositorio\"
sleep 2
add-apt-repository ppa:javaR/java -y
clear
echo \"Atualizando repositorio\"
sleep 2
apt-get update -y
clear
echo \"instalando vers�o 11 do java\"
then
echo \"preparando para instalar\"
apt-get install oracle-java11-installer -y
clear
echo \"java instalado vers�o 11\"
else
echo \"versao n�o identificada\"
fi
else echo \"voce escolheu n�o instalar\"
fi
fi



