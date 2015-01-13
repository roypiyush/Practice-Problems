#! /usr/bin/env perl

use diagnostics;

package com::test;

my $fred = 'hello';
print "The name is \$fred.\n";

$date = "98/07/22";

print $date."\n";

($year, $month, $day) = ($date =~ m[(\d\d)/(\d\d)/(\d\d)]);

print($day."/".$month."/".$year."\n");

# Array declaration
@Watson_Address = (
"Dr. Watson",
"221b Baker St.",
"London",
"NW1",
"England",
);

print "======Printing Array=======\n";
foreach (@Watson_Address) {
	print $_, "\n";
}

print "======Printing Hash=======\n";
# Hash declaration
%Sam_Address = (
name => "Sam Gamgee",
street => "Bagshot Row",
city => "Hobbiton",
country => "The Shire",
);

#my @k = keys %Sam_Address;
#my @v = values %Sam_Address;
#count = keys %Sam_Address;
#countV = values %Sam_Address;


# Hash will be printed in order given in quoted words
foreach ( qw(name street city country) ) {
	print $Sam_Address{$_}, "\n";
}


#$perldocOutput = `perldoc -u -f atan2`;
#print $perldocOutput;
