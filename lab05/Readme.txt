This lab demonstrates caching

	1. response is cached 
	2. caching policy has to be attached twice (request as well as response flow)

Pre-requisites
	Create a cache resource first.


Tests 
test environment(response comes from server 1)

    curl -v http://test-4g-test.apigee.net/v1/caching/?cacheKey=1
    curl -v http://test-4g-test.apigee.net/v1/caching/?cacheKey=2

Shows different version of API running on test environment / vs. Prod environment

For production environment the URL will be different (response comes from server 2)
    curl -v http://test-4g-prod.apigee.net/v2/caching/?cacheKey=1
    curl -v http://test-4g-prod.apigee.net/v2/caching/?cacheKey=2
