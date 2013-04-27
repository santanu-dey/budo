This application demonstrates basic authentication implementation 

1. It uses cleint credentials grant type for parsing and validaing the key secret 
2. It does not generate the access token response
3. It handles error. e.g. sends WWW-Authenticate: Basic realm="insert realm" when the credentials are not provided. As per HTTP protocl. 


