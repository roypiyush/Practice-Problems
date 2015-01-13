#!/bin/bash


IP="192.168.183.200"
GOOGLE="www.google.co.in"
URL="http://$IP"
SEC=3

# From this url &amp; should be removed
AUTHURL=`wget -O - http://$IP/bsp/startportal.do | grep 'form name="bspHomeForm"' | tail -1 | cut -f6 -d\" `

urlPartOne="http://$IP/bsp/bspHome.do;jsessionid="
urlPartTwo="?action=doBspHomeVoucherSubmit&flowId=TemplateLogin"


#AUTHURL=`wget -O - http://192.168.183.200/bsp/startportal.do 2 | grep 'form name="bspHomeForm"' | head -1 | cut -f6 -d\" `; 

sessionId=`echo $URL$AUTHURL | cut -b50-81`

login()
{
  logger "Logging in to Wishnet"
  wget --cookies=on --keep-session-cookies -O - --save-cookies /tmp/cookies.txt --post-data 'username=piyush_ssnpl&password=solaris123' $urlPartOne$sessionId$urlPartTwo 1&>/tmp/login2.tmp

  ping $GOOGLE -c $SEC > /dev/null
  if [ $? -eq '0' ]
  then
    logger "Connected to Internet..."
  fi
}

checkPortalAndLogin()
{
  
  ping $IP -c $SEC > /dev/null

  if [ $? -eq '0' ]
  then
  {
    logger "Ping $IP Successful."

    ping $GOOGLE -c $SEC > /dev/null

    if [ $? -ne '0' ]
    then
    {
      logger "Google cannot be accessed."
      login
    }
    fi
  }
  fi
  
  return 0
}

checkPortalAndLogin



