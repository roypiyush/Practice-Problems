#!/usr/bin/env perl -w

use diagnostics;
use warnings;
use strict;

sub Knapsack {

	my($result, $weight, $value, $w) = @_;
   
        my $max = 0;
	if(@$result[$w] >= 0) {
		return @$result[$w];
	}
	my $size = @$value;
	
	for(my $i = 0; $i < $size; $i++ ) {
		my $rw = $w - @$weight[$i];
		if($rw >= 0) {
			my $cur = &Knapsack(\@$result, \@$weight, \@$value, $rw) + @$value[$i];
			if($cur > $max) {
				$max = $cur;
			}
		}
	}
	@$result[$w] = $max;
	return $max;
}

my @result;
for(my $i = 0; $i <= 50; $i++) {
	$result[$i] = -1;
}
$result[0] = 0;

my @weight = (10, 20, 30);
my @value = (30, 100, 120);
my $start = time;
my $r = &Knapsack(\@result, \@weight, \@value, 50);
my $end = time - $start;
printf ("Result %s, Duration %d \n", $r,$end);
