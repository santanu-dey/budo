This lab demonstrates 
	1. When no resource(operation) is not matched - how to define a default flow to handle the requests.
	2. In this case the resource supports GET. So for POST, PUT and all other verbs we want to return a 400 bad request
	3. Gateway itself does not support LINK, UNLINK and PURGE by default. We can allow those from the HTTP connections property & then handle in the proxy        
		<Properties>
            <Property name="allow.http.method.LINK">true</Property>
        </Properties>
    4. Removes all content and header from incoming request.
    5. Demonstrates how the backend error's are captured in a default fault policy

