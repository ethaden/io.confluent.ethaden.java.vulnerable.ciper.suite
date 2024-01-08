# Example for calling REST API with insecure cipher suite parameters (if possible)

This proof-of-concept solves the problem, that no useful information is generated if a client with an expired but otherwise valid SSL certificate connects to an SSL-protected server. In complex IT environments it might be pretty hard to identify the misconfigured client.
In this example code, the thrown exception is slightly updated to include the common name of the certificate, but only if the certificate is just expired and otherwise valid. This should reduce the potential of misuse to a minimum.

CAUTION: Everything contained in this repository is not supported by Confluent.

DISCLAIMER AND WARNING: You use this code at your own risk! Please do not use it for production systems. The author may not be held responsible for any harm caused by this code!


## Run the example:

From main folder, run:

```
./gradlew run --args='../client.properties'
```
