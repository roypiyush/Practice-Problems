#!/usr/bin/env python


def gcd(m, n):
  if(n > m):
    m, n = n, m

  while(n != 0):
    r = m % n
    m = n
    n = r

  return m;

m = 50
n = 120

print "Finding GCD of ", m, n, gcd(m, n)
print "Finding LCM of ", m, n, (m * n) /gcd(m, n)
