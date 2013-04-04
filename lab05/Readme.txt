This lab demonstrates caching

	1. response is cached 
	2. caching policy has to be attached twice (request as well as response flow)

Pre-requisites
	Create a cache resource first.
	POST 
	https://api.enterprise.apigee.com/v1/organizations/test-4g/environments/test/caches

	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
	<Cache name="SimpleCache">
	    <ExpirySettings>
	        <TimeoutInSec>9000</TimeoutInSec>
	    </ExpirySettings>
	    <Compression>
	        <MinimumSizeInKB>1024</MinimumSizeInKB>
	    </Compression>
	    <Description>Response Cache for Demonstration</Description>
	    <DiskSizeInMB>0</DiskSizeInMB>
	    <InMemorySizeInKB>0</InMemorySizeInKB>
	    <MaxElementsInMemory>5000</MaxElementsInMemory>
	    <MaxElementsOnDisk>100000</MaxElementsOnDisk>
	    <OverflowToDisk>true</OverflowToDisk>
	    <Persistent>true</Persistent>
	</Cache>


Tests 
test environment(response comes from server 1)

    curl -v http://test-4g-test.apigee.net/v1/caching/?cacheKey=1
    curl -v http://test-4g-test.apigee.net/v1/caching/?cacheKey=2

Shows different version of API running on test environment / vs. Prod environment

For production environment the URL will be different (response comes from server 2)
    curl -v http://test-4g-prod.apigee.net/v2/caching/?cacheKey=1
    curl -v http://test-4g-prod.apigee.net/v2/caching/?cacheKey=2
