#!/usr/bin/env python

import calendar

def printCalendar( year, month ) :
    cal = calendar.month(year, month);
    print cal;
    return;

print ("Hello, Piyush !!!");
print ("This is your first python program");
#str = raw_input("Enter any number: ");
#if ( str > '10' ) :
#    print "Number is greater than 10";
#else :
#    print "Number is less than or equal to 10";

print "My name is %s and weight is %d kg!" % ('Zara', 21);
printCalendar( 2015, 12 );
