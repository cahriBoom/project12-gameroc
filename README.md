# Gamer OC

Être capable de produire un service social qui offre la possibilité aux joueurs, 
peut-importe leurs plateformes (Console ou PC) de chercher et de trouver des joueurs de même niveau ayant la même philosophie de jeu.
Les joueurs pourront aussi organiser des évènements avec la communauté. De multiples jeux seront disponible à la sortie de l’application.

## Présentation

Ce projet est une application web divisé en deux parties : 
- Le BackEnd pour l'administrateur (gamerback)
- Le FrontEnd pour les utilisateurs (gamerfront)


Ce projet est conçu sur **Windows**, en utilisant **Eclipse** comme outil de développement et **MySql** comme système de gestion de base de données.
**Apache Maven** est utilisé pour la gestion et l'automatisation de production des projets logiciels Java. Et le framework **Spring boot** est utilisé afin de facilité le développement de l'application.

### Outils et versions utilisés

- Windows 2010
- Java jdk version 8
- MySQL version 4.0.3
- un serveur Tomcat version 9.0.27
- plusieurs instances de Apache Tomcat (minimum 2 instances)
- un gestionnaire de base de données SQL (MySQL Workbench, ...)

### Déploiement du projet
- Télécharger la version la plus récente d'Apache Tomcat.
- Telecharger project12-gameroc dans votre environnement (ex : D:\ProjectGamer)
- Extraire les dossiers de l'archive : project12-gameroc

### Déploiement Tomcat
- Copier votre dossier Tomcat dans votre environnement
- Creer 2 sous-dossiers dans le dossier Tomcat : tomcat1, tomcat2
- Supprimer les contenus des dossiers 'bin' et 'lib' dans les sous-dossiers tomcat1,tomcat2
- Créer 2 fichiers **.bat** dans le dossier **bin** de tous les dossier copiés. (startup.bat, shutdown.bat et setenv.bat) 
  avec les contenus définis ci-dessous (tomcatServer est le nom de votre dossier de votre serveur Tomcat) 

### **setenv.bat**
> set JAVA_HOME=< Chemin de votre variable d'environement JAVA>

### **startup.bat**
>	
	@echo off
	if "%OS%" == "Windows_NT" setlocal
	cd ..
	set "CATALINA_BASE=%cd%"
	set "CATALINA_HOME=< chemin de votre serveur main tomcat >"
	set "EXECUTABLE=%CATALINA_HOME%\bin\startup.bat"
	call "%EXECUTABLE%" %*
>
### **shutdown.bat**
>
	@echo off
	if "%OS%" == "Windows_NT" setlocal
	cd ..
	set "CATALINA_BASE=%cd%"
	set "CATALINA_HOME=< chemin de votre serveur main tomcat >"
	set "EXECUTABLE=%CATALINA_HOME%\bin\shutdown.bat"
	call "%EXECUTABLE%" %*
>

- Ensuite modifier les ports de chaque instances de serveur dans le fichier **/conf/server.xml**

>
    <Connector port="8080" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" />
>
>
	<Connector port="8009" protocol="AJP/1.3" redirectPort="8443" />
>

>
	<Server port="8005" shutdown="SHUTDOWN">
>
Les trois instances doivent avoir des ports **différents**.


### Déploiement des fichiers WAR
- Copier les fichiers .war dans **/webapps/** des sous-dossiers tomcat1,tomcat2


### Démarrage des serveurs Tomcat
- Lancer une 'Invite de commandes' et naviguer jusqu'au dossier de chaque instance ou faites le manuellement.
- Lancer les 2 instances tomcat en exécutant le fichier **startup.bat**


### Création et Initilisation de la Base de données
- Ouvrir votre outil de gestion de base de données. (MySQL WorkBench,...)
- Créer la base de données à l'aide du fichier "GamerDump.sql".
- Importer le jeu de données fournit dans "GamerData.sql".

Note: Un login et un mot de passe sont requis pour la base de données.
	>
		- login : root
		- mdp : 
	>


## Démarrage

Une fois l'installation terminée.

Lancez un navigateur web, et entrez l'adresse:
> [localhost:8081/GamerFtont/home](http://localhost:8081/GamerFront/home)

## Développé avec

* [Eclipse] - Environement de développement
* [Tomcat] - Serveur Web
* [MySQL] - Base de données
* [MySQL Workbench] - Gestionnaire de base de données


## Auteurs
* **Maxime Cathala** _alias_ [@cahriBoom](https://github.com/cahriBoom)
