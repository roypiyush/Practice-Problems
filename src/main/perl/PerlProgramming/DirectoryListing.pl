#!/usr/bin/env perl -w
package system::user::pack;

use warnings;
use strict;

#no strict 'refs';

sub readUserInput()
{
	print("Enter : ");
	my $input = <>;
	chomp($input);

	return $input;
}

my $inputValue;

opendir($inputValue, &readUserInput) or die "Couldn't open\n" ;

my @listing = readdir $inputValue;

my $var = undef;

print "Listing...\n";
foreach $var (@listing)
{
	if( $var ne '.' and $var ne '..')
	{
		print $var."\n";
	}
}

closedir $inputValue;
