#! /usr/bin/perl -w

use diagnostics;
use warnings;
use strict;

use POSIX;

require ArrayUtil;

my @arr = (10,9,8,7,6,6,6,5,5,5,4,3);
my $SIZE = @arr;

# array, startIndex, endIndex
sub Merge {

	my($arr_ref, $startIndex, $mid, $endIndex) = @_;

	my @larr, my @rarr, my $i = 0, my $j = 0, my $lsize, my $rsize;

	@larr = @$arr_ref[$startIndex..$mid];
	$lsize = @larr;

	$i = 0; $j = 0;

	@rarr = @$arr_ref[($mid+1)..$endIndex];
	$rsize = @rarr;

	$i = 0; $j = 0;
	for(my $index = $startIndex; $index <= $endIndex ;)
	{
		if($i < $lsize && $j < $rsize && $larr[$i] <= $rarr[$j])
		{
			@$arr_ref[$index++] = $larr[$i++];
		}

		if($i < $lsize && $j < $rsize && $larr[$i] > $rarr[$j])
		{
			@$arr_ref[$index++] = $rarr[$j++];
		}

		if($i < $lsize && $j >= $rsize)
		{
			@$arr_ref[$index++] = $larr[$i++];
		}

		if($i >= $lsize && $j < $rsize)
		{
			@$arr_ref[$index++] = $rarr[$j++];
		}
	}
	

}


# array, startIndex, endIndex
sub MergeSort {

	my($arr_ref, $startIndex, $endIndex) = @_;

	if($startIndex >= $endIndex) {
		return;
	}

	my $mid = floor(($startIndex + $endIndex)/2);

	&MergeSort($arr_ref, $startIndex, $mid);
	&MergeSort($arr_ref, $mid + 1, $endIndex);
	&Merge($arr_ref, $startIndex, $mid, $endIndex);

}

ArrayUtil::printArray(\@arr);
my $startTime = time;
&MergeSort(\@arr, 0, $SIZE - 1);
my $duration = time - $startTime;
ArrayUtil::printArray(\@arr);
print("Execution time: $duration\n");
