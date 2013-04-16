This lab demonstrates 
	1. How to raise a fault - we have  a standard policy to raise a fault. Set header, status code, or payload 
    2. How to execute a step conditionally. In this example, faults are raised by raising conditions. 
    3. Then show how to handle the Faults (Fault Rules are for fault handling)
        a. Within the policy - This is a bug at the moment
        b. at Flow level policy hanlder - condition does not work. That is a bug at the moment. 
        

*************


When a fault occurs in a message flow, the fault handler employs the following fault rule to match the fault with a fault handler:

    An optional condition that catches the fault category, subcategory, name, or attributes
    A list of policy attachments that express the necessary processing

You can apply multiple fault rules to either the proxy or target in a flow. Only the first fault rule that matches the fault type, or whose condition evaluates to true, is enforced. Fault rules are evaluated and enforced in the following order:

    Request path:
        Fault in proxy request: Fault rules defined at ProxyEndpoint.
        Fault in routing: Fault rules defined at ProxyEndpoint.
        Fault in target request: Fault rules defined at TargetEndpoint.
        Fault in sending request to target: Fault rules defined at TargetEndpoint.
    Response path:
        Fault in proxy response: Fault rules defined at ProxyEndpoint.
        Fault in target response: Fault rules defined at TargetEndpoint.
        Fault in sending response to proxy: Fault rules defined at ProxyEndpoint.
    Policy attachments in a fault rule are enforced in the order of their attachment.


Test
curl -v http://test-4g-test.apigee.net/v1/fault/ -X POST -d "some data"
curl -v http://test-4g-test.apigee.net/v1/fault/


Prod
curl -v http://test-4g-prod.apigee.net/v2/fault/ -X POST -d "some data"
curl -v http://test-4g-prod.apigee.net/v2/fault/ 

