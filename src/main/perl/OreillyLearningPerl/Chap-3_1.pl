#! /usr/bin/env perl -w

use diagnostics;

package com::ChapThree;

sub userNumberInput
{
	print "Enter " . $_[0] . "  : \n";
	my @one = <STDIN>;
	return @num;

}

@one = userNumberInput("lines of strings [Use Crtl+D to stop entering]");
$product = reverse(@one);

print "Printing in reverse order\n $product\n";

