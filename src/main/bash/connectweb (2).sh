#!/bin/bash

GATEWAY="172.16.142.193";
DNS="172.16.0.1";

checkServerLink() {
  ping $1 -c 5 > /dev/null;
  if [ $? -eq 0 ]
  then 
    echo " OK";
  else
    echo "FAILED"; exit 1;
  fi
}

echo -n "Pinging Gateway...";
checkServerLink $DNS;
