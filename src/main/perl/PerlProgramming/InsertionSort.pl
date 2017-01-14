#!/usr/bin/env perl -w

use strict;

my @arr=(1,2,3,4,5,6,1,3,6);

my $i = 0;
foreach (@arr) {
	my $j = $i;

	while( $j > 0 && $arr[$j] < $arr[$j-1] ) {
		my $temp = $arr[$j];
		$arr[$j] = $arr[$j - 1];
		$arr[$j - 1] = $temp;
		$j = $j - 1;
	}
	$i = $i + 1;
}

$i = 0;
foreach ( @arr ) {

	print($arr[$i] ." ");
	$i = $i + 1;

}


1;
