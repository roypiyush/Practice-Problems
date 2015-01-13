#!/bin/bash

tar -xzvf InstalledApplications.tar.gz
ls InstalledApplications/jdk1.6.0_27/bin/java > /dev/null
if [ $? -ne 0 ]
  then
    echo "Java NOT Found at expected path";
    exit 1;
fi

echo "\n\n" >> `echo $HOME/.profile`;
echo "export JAVA_HOME=\"\$HOME/InstalledApplications/jdk1.6.0_27\"" >> `echo $HOME/.profile`;
echo "export PATH=\"\$PATH:\$JAVA_HOME/bin\"" >> `echo $HOME/.profile`;
echo "export M2_HOME=\"\$HOME/InstalledApplications/apache-maven-3.0.3\"" >> `echo $HOME/.profile`;
echo "export PATH=\"\$PATH:\$M2_HOME/bin\"" >> `echo $HOME/.profile`;
