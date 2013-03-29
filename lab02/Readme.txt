This lab demonstrates 
	1. When a resource(operation) is not matched - how to define a default flow behaviour?
	2. The resource supports GET. So for POST, PUT and all other verbs we want to return 400 bad request
	3. Gateway itself does not support LINK, UNLINK and PURGE by default. We can allow those from the HTTP connections property & then handle in the proxy        
		<Properties>
            <Property name="allow.http.method.LINK">true</Property>
        </Properties>
    
    Note: The policy name and file name should match.
    4. Removes all content and header from incoming request.

