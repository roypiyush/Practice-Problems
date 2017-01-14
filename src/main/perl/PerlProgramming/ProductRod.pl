#!/usr/bin/perl -w

use strict;
require MinMax;

my $length = 10;

sub productRod {

    my $n = $_[0];

    if($n <= 1)
    {
        return 1;
    }

    my $max = 0;

    for(my $i = 1; $i < $n ; $i++)
    {
        $max = MinMax::max($max, MinMax::max($i * ($n - $i) , $i * &productRod($n - $i) ));
    }

    return $max;

}


my $value = &productRod($length);
print "Value : $value \n";

