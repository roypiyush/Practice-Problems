#!/bin/bash

echo "This script started with process ID : $$";

echo -n "Hi, what is your name? "
read name
echo "Hey, $name. Type a password.";
read -p passwd;
echo "I will keep your passowrd $passwd safe ;)";

if [ -z $1 ]
  then
    echo "First Parameter was NOT provided";
  elif [ -e "$1" ]
  then
    echo "File $1 exists.";
  else
    echo "File $1 doesn't exist.";
fi

# Case Demo
: ${var=`whoami`};
case "$var" in
abc) echo "Vairable was 'abc'";;
xyz) echo "Vairable was 'xyz'";;
piyush) echo "You provided piyush";
esac

echo ${var/p/P};


echo "Reading lines in fstab";

File=/etc/fstab
{
 read line1
 read line2
} < $File
echo "\n$line1"
echo "$line2\n"


exit 0;

