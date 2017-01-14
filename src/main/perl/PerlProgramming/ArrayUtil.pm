#!/usr/bin/perl

package ArrayUtil;

sub printArray {

        my($arr_ref) = @_;

        my $size = @$arr_ref;

        for (my $i = 0; $i < $size; $i++) {
                print ("@$arr_ref[$i]");
			if($i < $size - 1)
			{
				print(", ");
			}
        }

        print("\n");
}

sub swapIndexValues {
	my($arr_ref, $i1, $i2) = @_;

        my $temp = @$arr_ref[$i1];
	@$arr_ref[$i1] = @$arr_ref[$i2];
	@$arr_ref[$i2] = $temp;
}

1;
