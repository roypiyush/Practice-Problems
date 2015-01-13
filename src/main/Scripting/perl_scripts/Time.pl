#!/usr/bin/perl -w

use diagnostics;
use strict;
use Date::Parse;
use POSIX qw(strftime);
use Time::Piece;

my $now = Time::Piece->strptime("%s", localtime);
print "23433333333333333333333333333333333333\n";
my $now1 = Time::Piece->strptime("%s", localtime);
my $d = int ($now1 - $now);
print $d;
