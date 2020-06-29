#!/usr/bin/env perl -w

sub numericToEnglish {
 $value = $_[0];

 %hashMap = ("1","ONE",
             "2","TWO",
             "3","THREE",
             "4","FOUR",
             "5","FIVE",
             "6","SIX",
             "7","SEVEN",
             "8","EIGHT",
             "9","NINE"
            );

  return $hashMap{$value};
}

print "\nEnter Any Number between 1-9 : \n";
$v = <STDIN> ;
chomp($v);
print numericToEnglish($v)."\n";
