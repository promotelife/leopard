::echo off
@ECHO OFF

::set local variables
setlocal  

set javapro="-Dlog4j.configuration=file:conf/log4j.xml"
set javaclasspath="libs/log4j-1.2.17.jar"

::compile
::javac -encoding UTF8 -d bin  -cp lib/log4j-1.2.17.jar @filelist 

::run
::java -server -Dlog4j.configuration=file:conf/log4j.xml -cp lib/log4j-1.2.17.jar;src jtest 
java -ea  -server %javapro% -classpath %javaclasspath%;distrib/leopard-cli.jar com.genius.client.Start 


endlocal

::output changeline
echo.
echo.
::del  class
::del /S *.class

::deal params
if "%1" == "p" pause