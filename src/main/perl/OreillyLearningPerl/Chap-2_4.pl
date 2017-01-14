#! /usr/bin/env perl -w

use diagnostics;

package com::ChapTwo;

sub userNumberInput
{
	print "Enter " . $_[0] . "  : ";
	my $num = <STDIN>;
	chomp($num);
	return $num;

}

$one = userNumberInput("String");
$two = userNumberInput("Number");
$product = $one x $two;

print "Product of two variables $one and $two is $product.\n";
