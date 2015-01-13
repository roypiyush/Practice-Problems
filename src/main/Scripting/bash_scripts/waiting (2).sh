#!/bin/bash


pingServer() 
{
  ping localhost -c 7 > /dev/null;
}

waitTillFinish()
{
  echo -e "$1";
  {
    pleaseWait="Please wait"
    index=0

    while true;
    do
      if [ $index -eq 0 ] || [ $index -eq 3 ] 
      then
        index=0;
        text="\r                \r$pleaseWait."
      else
        text="."
      fi

      echo -en "$text";
 
      sleep 1; 
      let index+=1

    done

  } &
  lastPID=$!;
  $2;
  
  if [ $? -eq 0 ]
    then echo "OK";
  else
    echo "Failed";
  fi
  
  kill $lastPID;
}

waitTillFinish "Pinging Server" "pingServer"

exit 0
