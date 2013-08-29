#!/bin/sh
# send "error" to create an exception
curl --data-binary $1 http://localhost:8080/soa-p.notfier-1.0-SNAPSHOT/http/test/

