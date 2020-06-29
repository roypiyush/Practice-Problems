#!/usr/bin/perl -w

use diagnostics;
use strict;
use POSIX;

require ArrayUtil;

sub left {
    my $index = $_[0] * 2;
    return $index;
}

sub right {
    my $index = $_[0] * 2 + 1;
    return $index;
}

sub parent {
    my $index = floor($_[0] / 2);
    return $index;
}

# array, keyIndex, size
sub MAX_HEAPIFY {

    my ($arrRef, $keyIndex, $size) = @_;
    
    my $larger;
    my $left = &left($keyIndex);
    my $right = &right($keyIndex);

    if($left < $size -1 && @$arrRef[$left] >= @$arrRef[$keyIndex]) {
        $larger = $left;
    }
    else {
        $larger = $keyIndex;
    }

    if($right < $size -1 && @$arrRef[$right] >= @$arrRef[$larger]) {
        $larger = $right;
    }

    if($keyIndex != $larger) {
        #my $temp = @$arrRef[$keyIndex];
        #@$arrRef[$keyIndex] = @$arrRef[$larger];
        #@$arrRef[$larger] = $temp;

	ArrayUtil::swapIndexValues($arrRef, $keyIndex, $larger);
        &MAX_HEAPIFY($arrRef, $larger, $size);
    }
        
}

# Array, size
sub BUILD_MAX_HEAP {
    my ($arrRef, $size) = @_;
    for(my $i = floor($size / 2); $i >= 0 ;$i--) {
       &MAX_HEAPIFY($arrRef, $i, $size);
    }
}

# Array, Size
sub HEAP_SORT {
    my($arrRef, $size) = @_;
	
    &BUILD_MAX_HEAP($arrRef, $size);
    
    for(my $i = ($size - 1); $i > 1; $i--) {
        #my $temp = @$arrRef[0];
        #@$arrRef[0] = @$arrRef[$i];
        #@$arrRef[$i] = $temp;

	ArrayUtil::swapIndexValues($arrRef, 0, $i);
        $size = $size - 1;

        &MAX_HEAPIFY($arrRef, 0, $size);
    }

}

my @array = (65,145,46,13,46,31,74,20,19,18,15,12,11,2,5,8);
my $SIZE = scalar(@array);

ArrayUtil::printArray(\@array);
&HEAP_SORT(\@array, $SIZE);
ArrayUtil::printArray(\@array);
