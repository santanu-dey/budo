This lab demonstrates various endpoint protection features

	1. spike arrest
    2. Different rate-limiting values in prod vs. test
    3. spike arrest
    4. different backend targets for prod and test targets



Tests 

test environment(response comes from server 1)

    curl -v http://test-4g-test.apigee.net/v1/protection/ 
    curl -v http://test-4g-test.apigee.net/v1/protection/ -data "some data"

Shows different version of API running on test environment / vs. Prod environment

For production environment the URL will be different (response comes from server 2)
    curl -v http://test-4g-prod.apigee.net/v2/protection/ 
    curl -v http://test-4g-prod.apigee.net/v2/protection/ -data "some data"