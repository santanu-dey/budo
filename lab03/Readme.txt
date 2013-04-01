This lab demonstrates 
	1. How to raise a fault - we have  a standard policy to raise a fault. Set header, status code, or payload 
    2. Try to raise faults conditionally. That's optional
    3. Then how to handle the Faults (Fault Rules are for fault handling)
        a. Within the policy
        b. at Flow level policy hanlder
        c. with a condition

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



How to raise a faults?



