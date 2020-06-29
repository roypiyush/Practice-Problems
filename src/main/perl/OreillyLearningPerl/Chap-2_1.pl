#! /usr/bin/env perl -w

package com::ChapTwo;

print "Enter radius : ";
$radius = <STDIN>;
chomp($radius);  # To discard newline
print "Area of circle : ". 3.141592654 * $radius * $radius . "\n";
