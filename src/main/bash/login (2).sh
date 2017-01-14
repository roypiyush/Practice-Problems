#!/bin/bash

GATEWAY="172.16.142.193"
DNS="172.16.0.1"
IP="192.168.183.200"
GOOGLE="www.google.co.in"
URL="http://$IP"
SEC=1


#First Param is IP and second param is server iddntifier name
pingServer()
{
  ping $1 -c $SEC > /dev/null
  if [ $? -ne 0 ]
  then
  {
    logger "$2 cannot be reached..."
    return 1
  }
  fi
  return 0
}

login()
{
  # From this url &amp; should be removed
  AUTHURL=`wget -O - http://$IP/bsp/startportal.do | grep 'form name="bspHomeForm"' | tail -1 | cut -f6 -d\" `

  urlPartOne="http://$IP/bsp/bspHome.do;jsessionid="
  urlPartTwo="?action=doBspHomeVoucherSubmit&flowId=TemplateLogin"


  #AUTHURL=`wget -O - http://192.168.183.200/bsp/startportal.do 2 | grep 'form name="bspHomeForm"' | head -1 | cut -f6 -d\" `; 

  sessionId=`echo $URL$AUTHURL | cut -b50-81`

  logger "Logging in to Wishnet"
  wget --cookies=on --keep-session-cookies -O - --save-cookies /tmp/cookies.txt --post-data 'username=piyush_ssnpl&password=solaris123' $urlPartOne$sessionId$urlPartTwo 1&>/tmp/login2.tmp

  ping $GOOGLE -c $SEC > /dev/null
  if [ $? -eq 0 ]
  then
    logger "Connected to Internet..."
  fi
}

checkPortalAndLogin()
{

  # Ping gateway first
  pingServer $GATEWAY "Gateway"

  # Ping DNS
  pingServer $IP "DNS"

  #Ping Portal
  pingServer $IP "Login Portal"

  # If portal can be reached then check google
  if [ $? -eq 0 ]
  then
  {
    pingServer $GOOGLE "Google"

    if [ $? -ne 0 ]
    then
    {
      login
    }
    fi
  }
  fi
  
  return 0
}

checkPortalAndLogin
