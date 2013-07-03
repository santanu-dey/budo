package com.cs.util;


import org.apache.commons.codec.binary.Base64;

import com.apigee.flow.execution.ExecutionContext;
import com.apigee.flow.execution.ExecutionResult;
import com.apigee.flow.execution.spi.Execution;
import com.apigee.flow.message.MessageContext;

public class Base64Encoder implements Execution {

@Override
public ExecutionResult execute(MessageContext messageContext,
ExecutionContext executionContext) {
String key = messageContext.get("message.queryparam.username");
String secret = messageContext.get("message.queryparam.password");

String keyAndSecret = key + ":" + secret;

byte[] encoded = Base64.encodeBase64(keyAndSecret.getBytes());

String base64EncodedKeySecret = "Basic " + new String(encoded);
messageContext.setVariable("message.header.Authorization",
base64EncodedKeySecret);
return ExecutionResult.SUCCESS;
}
}
