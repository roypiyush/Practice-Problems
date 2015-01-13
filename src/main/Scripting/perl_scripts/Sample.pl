#!/bin/env perl -w
use warnings;

# Use -Mdiagnostics in command instead of here
#use diagnostics;

package Pack::Test::Sample;

sub testMethod()
{
  print ("Enter your name : ");
  $name = <STDIN>;
  $chomped = chomp($name);
  if($chomped eq 1)
  { 
    $string = "$name\rManik\n";
    print $string;
  }

}

print "$ARGV[0] , $ARGV[1] \n";

testMethod();

print "Execution finished at : ".localtime(time())."\n";#exec("date");
