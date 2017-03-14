@echo off

set path=%cd%\jdk1.7.0_79\bin;%path%
set JAVA_HOME=%cd%\jdk1.7.0_79
set CATALINA_HOME=%cd%\apache-tomcat-8.0.35


set classpath=%classpath%;%CATALINA_HOME%\lib\servlet-api.jar
set classpath=%classpath%;%CATALINA_HOME%\lib\jsp-api.jar
set classpath=%classpath%;%CATALINA_HOME%\lib\el-api.jar
set classpath=%classpath%;%CATALINA_HOME%\lib\jasper.jar
set classpath=%classpath%;%CATALINA_HOME%\lib\jasper-el.jar
set classpath=%classpath%;%CATALINA_HOME%\lib\mysql-connector.jar


set default_dir=xshop


set /p app_dir=Directory name: 
if not defined app_dir goto :default_dir_set
	echo Application directory: %app_dir%
	set file_path=%CATALINA_HOME%\webapps\%app_dir%\WEB-INF\classes
	echo $file_path%
	cd %file_path%
	echo %cd%
	javac xshop/entity/*.java
	javac xshop/data/*.java
	javac xshop/core/*.java
	javac xshop/app/*.java
	;if not exist *.java goto :path_error
	;javac *.java	
	echo Compilation successfull
	goto :end_cmd


:default_dir_set
if not defined default_dir goto :no_dir
	echo Default application directory: %default_dir%
	set file_path=%CATALINA_HOME%\webapps\%default_dir%\WEB-INF\classes
	cd %file_path%
	if not exist *.java goto :path_error
	javac xshop/entity/*.java
	javac xshop/data/*.java	
	javac xshop/core/*.java
	javac xshop/app/*.java	
	echo Compilation successfull
	goto :end_cmd


:no_dir
echo No dirctory specified, terminating compilation
goto :end_cmd

:path_error
echo Directory or source file not found
goto :end_cmd

:end_cmd
pause 1