This lab demonstrates concept of "Flow" in the Gateway. How do we defined flows?
	1. When no resource(flow or operation condition) is not matched - how to define a default flow to handle the requests.
	2. In this case the resource supports GET. So for POST or PUT and all other verbs we want to handle the request as a different Flow to return a 400 bad request
	3. Gateway itself does not support LINK, UNLINK and PURGE by default. We can allow those from the HTTP connections property & then handle in the proxy        
		<Properties>
            <Property name="allow.http.method.LINK">true</Property>
        </Properties>
    4. Removes all content and header from incoming request.
    5. Demonstrates how the backend error's are captured in a default fault policy

    Test with 
    	Handle GET with normal flow 
        curl -v http://test-4g-test.apigee.net/v1/default-operation/ 
    	
        Handle POST with default flow
        curl -v -X POST http://test-4g-test.apigee.net/v1/default-operation/ -data "some data"
        curl -v http://test-4g-test.apigee.net/v1/default-operation/test       

        
        Handle backend error with fault handling flow
 
        curl -v -X PUT http://test-4g-test.apigee.net/v1/default-operation/ -data "some data"

    Shows different version of API running on test environment / vs. Prod environment

    For production environment the URL will be different
    	curl -v http://test-4g-prod.apigee.net/v2/default-operation/ 
    	curl -v http://test-4g-prod.apigee.net/v2/default-operation/test -data "some data"

