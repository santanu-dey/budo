This lab will demonstrate service callout.

We will mash up two APIs

1. get the latest movie id from getLatest API
2. get detailed info from getInfo API

In this process this lab demonstrates a few salient features:

1. json path extraction
2. json to xml conversion
3. conditionally returning XML / json response


curl -v http://test-4g-test.apigee.net/v1/getmovie/ -H "Accept: application/xml"
curl -v http://test-4g-test.apigee.net/v1/getmovie/ 

curl -v http://test-4g-prod.apigee.net/v2/getmovie/ -H "Accept: application/xml"
curl -v http://test-4g-prod.apigee.net/v2/getmovie/ 