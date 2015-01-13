#!/usr/bin/perl

package MinMax;

use strict;

sub max {

    my($v1, $v2) = @_;

    if($v1 > $v2)
    {
	return $v1;
    }
    else
    {
	return $v2;
    }

}

sub min {

    my($v1, $v2) = @_;

    if($v1 < $v2)
    {
        return $v1;
    }
    else
    {
        return $v2;
    }


}

1;
