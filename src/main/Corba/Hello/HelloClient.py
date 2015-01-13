#!/usr/bin/env python

import sys
from omniORB import CORBA
import HelloApp

orb = CORBA.ORB_init(sys.argv, CORBA.ORB_ID);

ior = sys.argv[1];
obj = orb.string_to_object(ior);

eo = obj._narrow(Hello);

if eo is None:
    print "Object reference is not present";
    sys.exit(1);

message = "Hello from Python";
result = eo.sayHello(message);

print result;

