This lab demonstrates custom coding using java call out

	1. response is cached 
	2. caching policy has to be attached twice (request as well as response flow)



Tests 
test environment(response comes from server 1)

    curl -v http://test-4g-test.apigee.net/v1/javacallout/?username=abc&password=pass
    curl -v http://test-4g-prod.apigee.net/v2/javacallout/?username=abc&password=pass
 
