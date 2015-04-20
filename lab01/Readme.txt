 This lab demonstrates 
	1. A stubbed proxy, i.e., requests do not hit backend. This is done by setting no element in   <RouteRule> element. Request headers are not echoed, as the request object is created new.  
	2. This proxy does not really need the target folder and its content (except UI validation needs these to display the bundle properly on UI editors)
	3. adds a new header, places static response payload 
	4. How about virtual host concept

List virtual hosts	http://test-4g-prod.apigee.net/test-4g/environments/prod/virtualhosts
