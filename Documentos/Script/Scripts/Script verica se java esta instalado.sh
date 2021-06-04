
#!/bin/bash
echo "Verificando se o java está instalado e a"
echo "versão do Java antes de continuar"
sleep 2
echo ####################################
echo ####################################
if [ $? -eq 0 ]
then
echo "O Java está instalado na sua maquina"
echo "continuando a instalação"
sleep 2
echo ####################################
echo ####################################
else
echo "O Java não está instalado na sua maquina"
echo "Instalando Java em sua maquina"
sleep 2
echo ####################################
echo ####################################
echo "criando repósitorio do Java"
add-apt-repository ppa:javaR/java -y
echo "Atualizando repositorio no sistema"
apt-get update -y
sleep 2
echo ####################################
echo ####################################
echo "A versão a ser instalada será a versão 11 do Java"
apt-get install oracle-java11-installer -y
sleep 2
echo ####################################
echo ####################################
echo "Versão 11 do Java instalada com sucesso"
sleep 5



