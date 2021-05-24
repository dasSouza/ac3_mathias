#!/bin/bash

  echo Bem vindo ao Assistente de instalação do KeepCode
  echo Com ele você poderá instalar e atualizar os recursos 
  echo necessários para utilizar nossa aplicação funcionar
  echo começando...
sleep 3
sudo apt-get update
sudo apt-get dist-upgrade -y
sudo apt-get install gimp
java -version
if [ $? -eq 0 ]
then
echo \"java instalado\"
else
echo \"java não instalado\"
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
echo \"instalando versão 11 do java\"
then
echo \"preparando para instalar\"
apt-get install oracle-java11-installer -y
clear
echo \"java instalado versão 11\"
else
echo \"versao não identificada\"
fi
else echo \"voce escolheu não instalar\"
fi
fi



