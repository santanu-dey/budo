This lab demonstrates various endpoint protection features

	1. spike arrest only when there is no query param
    2. Different rate-limiting values in prod vs. test
    3. different backend targets for prod and test targets
    4. use Quota policy when there is a query param
    5. How about distributed quota? Simple set the     <Distributed>true</Distributed> 
    6. How to reset Quota - the RestQuota policy has a bug (Not working in R21.2 https://apigeesc.atlassian.net/browse/BID-3308)



Tests 

test environment(response comes from server 1)

    curl -v http://test-4g-test.apigee.net/v1/protection/ 
    curl -v http://test-4g-test.apigee.net/v1/protection/ -data "some data"

Shows different version of API running on test environment / vs. Prod environment

For production environment the URL will be different (response comes from server 2)
    curl -v http://test-4g-prod.apigee.net/v2/protection/ 
    curl -v http://test-4g-prod.apigee.net/v2/protection/ -data "some data"

For quota test ab -k -v 4 -n 60 http://test-4g-test.apigee.net/v1/protection/?param=whatever