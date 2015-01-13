#! /usr/bin/env perl -w

package Foo::Bar;
use strict;
use warnings;
use diagnostics;

sub fibonacci {
    my $prevprevnum = 0;
    my $prevnum = 1;

    for(my $i=1; $i<=100; $i++)
    {
	my $fib = $prevprevnum + $prevnum;
	$prevprevnum = $prevnum;
	$prevnum = $fib;
	print "$fib ";
    }
    print "\n";
}

print "Generating Fibonacci...\n";

&fibonacci;
