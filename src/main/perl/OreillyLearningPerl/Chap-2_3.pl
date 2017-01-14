#! /usr/bin/env perl -w

use diagnostics;

package com::ChapTwo;

sub userNumberInput
{
	print "Enter number " . $_[0] . "  : ";
	my $num = <STDIN>;
	chomp($num);
	return $num;

}

$one = userNumberInput("One");
$two = userNumberInput("Two");
$product = $one * $two;

print "Product of two numbers $one and $two is $product.\n";

