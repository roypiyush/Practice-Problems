#!/usr/bin/perl -w

use diagnostics;
use strict;
use POSIX;

require ArrayUtil;

#array, startIndex, endIndex
sub Partition {

    my($arrRef, $p, $r) = @_;
    my $i = $p - 1;
    #my $j = $p;

    if($p >= $r && $p < 0) {
        return;
    }

    my $key = @$arrRef[$r];

    for(my $j = $p; $j < $r; $j++) {

        if(@$arrRef[$j] <= $key) {
            $i = $i + 1;
            ArrayUtil::swapIndexValues($arrRef, $j, $i);
        }
        #$j = $j + 1;
    }

    $i = $i + 1;
    ArrayUtil::swapIndexValues($arrRef, $i, $r);

    return $i;
}

#array, startIndex, endIndex
sub QuickSort {

    my($arrRef, $p, $r) = @_;
    
    if($p >= $r) {
        return;
    }

    my $q = &Partition($arrRef, $p, $r);
    &QuickSort($arrRef, $p, $q - 1);
    &QuickSort($arrRef, $q + 1, $r);
}

my @array = (65,145,46,13,46,31,74,20,19,18,15,12,11,2,5,8);
my $SIZE = scalar(@array);

ArrayUtil::printArray(\@array);
&QuickSort(\@array, 0, $SIZE - 1);
ArrayUtil::printArray(\@array);
