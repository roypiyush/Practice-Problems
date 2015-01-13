#! /usr/bin/env perl -w

use strict;
use warnings;

print "Provide a file to read : ";
my $file = <>;
chomp($file);

open (file_data, "<$file") or die "Could not open file : $file \n";

print "******************\n";
while (<file_data>)
{
	print "$_";
}

print "******************\n";
close(file_data);
