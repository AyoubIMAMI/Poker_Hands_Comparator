# dojo-poker-21-22-gd6
dojo-poker-21-22-gd6 created by GitHub Classroom

Notre programme demande à l'utilisateur de saisir deux mains (l'une après l'autre) avec certaines règles spécifiés. Si les règles ne sont pas respectés lors de la saisi d'une main, un message d'erreur intervient et l'utilisateur doit rentrer à nouveau la main en question.
Si les deux mains sont correctement saisis, notre programme va analyser chaque main, les comparer et afficher le résultat du vainqueur. Notre programme prend en compte les règles suivantes : hauteur, paire, double paire, brelan, quinte, couleur, full, carré, quinte flush.
En cas d'égalité sur une règle (sauf hauteur), notre programme vérifie la hauteur pour désigner le gagnant. Si même avec la hauteur, il n'y a toujours pas de gagnant (cas où dans les deux mains chacune des autres cartes ont la même valeur) il y a égalité entre les 2 mains et un message l'annonce.

Comment exécuter notre programme et ses tests :
Vous devez vous trouvez dans le dossier Poker (racine).

Dans un terminal, exécuter la commande suivante pour compiler notre programme :
javac -sourcepath .\Poker\src -d .\Poker\bin\ .\Poker\src\main*.java

Puis, éxecuter la commande suivante pour éxecuter le programme :
java -cp .\Poker\bin\ .\Poker\src\main\Main.java

Pour Compiler les test (il faut remplacer le fichier après -cp par la ou se trouve Junit):
javac -cp C:\Users\leolb\.p2\pool\plugins\org.junit.jupiter.api_5.7.1.v20210222-1948.jar -sourcepath .\Poker\src -d .\Poker\bin\ .\Poker\test\test\*java
