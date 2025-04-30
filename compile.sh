cd src
find . -name "*.java" | xargs -I {} javac -cp .:../lib/dao.jar:../lib/servlet-api.jar:../lib/simpleController.jar -d ../bin {}
cp -r ../bin/* ../../boulangerie_projet/WEB-INF/classes
cd ../
sh webapp.sh
