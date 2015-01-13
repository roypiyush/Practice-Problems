#! /usr/bin/env perl -w

use warnings;
use strict;

sub above_avg {
    my $sum = 0;
    my(@nums) = @_;
    my $count = $#nums;
    foreach my $num (@nums) {
	$sum = $sum + $num;
    }

    my $avg = $sum / $count;

    print "Average : $avg and Numbers above average : ";
    foreach my $num (@nums) {
	if($num > $avg)
	{
	    print "$num ";
	}
    }
    print "\n";    
}

&above_avg(1..1000);
