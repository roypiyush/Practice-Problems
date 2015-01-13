#!/usr/bin/perl

require Foo;

Foo::bar( "a" );
Foo::blat( "b" );

# arr_ref1, arr_ref2
sub printArray {

	my($arr_ref1, $arr_ref2) = @_;

	my $size1 = @$arr_ref1; 
	print ("Size1 : $size1 \n");
	
	for (my $i = 0; $i < $size1; $i++) {
		print (@$arr_ref1[$i] . "\n");
	}

}

sub alterArray {

	my($arr_ref1) = @_;

	my $size1 = @$arr_ref1;
        print ("Size1 : $size1 \n");

        my $temp = @$arr_ref1[0];
	@$arr_ref1[0] = @$arr_ref1[1];
	@$arr_ref1[1] = $temp;

}


# array, index1, index2
sub swapIndexValues {
	my($arr_ref, $i1, $i2) = @_;

        my $temp = @$arr_ref[$i1];
	@$arr_ref[$i1] = @$arr_ref[$i2];
	@$arr_ref1[$i2] = $temp;
}

my @arr1 = (1,2,3,4,5,6);
my @arr2 = ("Piyush", "Roy");


&printArray(\@arr1, \@arr2);
&alterArray(\@arr2);
print @arr2;
