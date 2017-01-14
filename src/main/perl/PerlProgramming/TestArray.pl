#!/usr/bin/perl -w

use strict;
use diagnostics;

require ArrayUtil;

sub meth{
	my($arrRef) = @_;
	my $s1 = scalar(@$arrRef);
	print ("\n $s1 \n");
}

my @arr = (10,9,8,7,6,6,6,5,5,5,4,3);

ArrayUtil::printArray(\@arr);
ArrayUtil::swapIndexValues(\@arr, 0, 1);
ArrayUtil::printArray(\@arr);
