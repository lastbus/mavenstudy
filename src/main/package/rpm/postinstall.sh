#!/usr/bin/env bash
if [ ! -f /usr/share/java/mysql-connector-java-5.1.42-bin.jar ];then
 echo "install encounter error!"
 exit 1
fi

if [ -f /usr/share/java/mysql-connector-java.jar ]; then
 echo "override old /usr/share/java/mysql-connector-java.jar"
fi
ln -s /usr/share/java/mysql-connector-java-5.1.42-bin.jar /usr/share/java/mysql-connector-java.jar