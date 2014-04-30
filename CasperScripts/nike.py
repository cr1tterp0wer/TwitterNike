#!/usr/bin/env python3
import urllib.parse as parse
import urllib.request as request
import sys
import http.cookiejar

cookie = http.cookiejar.CookieJar()
opener = request.build_opener(request.HTTPCookieProcessor(cookie))
r = opener.open(sys.argv[1])

r.close()

print(cookie)

