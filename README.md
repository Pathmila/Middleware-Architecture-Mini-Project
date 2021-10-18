# PetStore Application

## How to build and/or deploy the API

First clone the repository.
	
	git clone .............
	
Go to the git bash and enter following commands.

To build the application:

    ./gradlew build -Dquarkus.package.type=uber-jar

To run the application:

    java -jar build/petstore-runner.jar


## How to run test suite

Go the the browser and navigate to the following URLs

##### 1. To get all pets
	
	http://localhost:8080/v1/pets/
	
##### 2. To get a pet by using ID

	http://localhost:8080/v1/pets/id/1
	
##### 3. To get a pet by using name

	http://localhost:8080/v1/pets/name/Sudda
	
##### 4. To get a pet by using type

	http://localhost:8080/v1/pets/type/Bird
	
##### 5. To get a pet by using age

	http://localhost:8080/v1/pets/age/3
	
##### 6. To get all pets' IDs

	http://localhost:8080/v1/pets/getIds	
	
##### 7. To get all pets' Names

	http://localhost:8080/v1/pets/getNames
	
##### 8. To get all types of pets

	http://localhost:8080/v1/pets/getTypes
	
##### 9. To add a pet

	http://localhost:8080/v1/pets/addPet
	
##### 10. To update a pet  

	http://localhost:8080/v1/pets/updatePet/1
	
##### 11. To delete a pet  

	http://localhost:8080/v1/pets/deletePet/1

	
## How to run a CURL/WGET command to test the APIs once deployed

Go to your command prompt and give the following commands to test the APIs.

##### 1. To get all pets
	
	curl -v http://localhost:8080/v1/pets/
	
You will get the following output

	*   Trying ::1...
	* TCP_NODELAY set
	* Connected to localhost (::1) port 8080 (#0)
	> GET /v1/pets/ HTTP/1.1
	> Host: localhost:8080
	> User-Agent: curl/7.55.1
	> Accept: */*
	>
	< HTTP/1.1 200 OK
	< Content-Length: 178
	< Content-Type: application/json
	<
	[{"petAge":3,"petId":1,"petName":"Boola","petType":"Dog"},{"petAge":4,"petId":2,"petName":"Sudda","petType":"Cat"},{"petAge":2,"petId":3,"petName":"Peththappu","petType":"Bird"}]* Connection #0 to host localhost left intact

	
##### 2. To get a pet by using ID

	curl -v http://localhost:8080/v1/pets/id/1

You will get the following output	

	*   Trying ::1...
	* TCP_NODELAY set
	* Connected to localhost (::1) port 8080 (#0)
	> GET /v1/pets/id/1 HTTP/1.1
	> Host: localhost:8080
	> User-Agent: curl/7.55.1
	> Accept: */*
	>
	< HTTP/1.1 200 OK
	< Content-Length: 56
	< Content-Type: application/json
	<
	{"petAge":3,"petId":1,"petName":"Boola","petType":"Dog"}* Connection #0 to host localhost left intact
	
##### 3. To get a pet by using name

	curl -v http://localhost:8080/v1/pets/name/Sudda

You will get the following output

	*   Trying ::1...
	* TCP_NODELAY set
	* Connected to localhost (::1) port 8080 (#0)
	> GET /v1/pets/name/Sudda HTTP/1.1
	> Host: localhost:8080
	> User-Agent: curl/7.55.1
	> Accept: */*
	>
	< HTTP/1.1 200 OK
	< Content-Length: 56
	< Content-Type: application/json
	<
	{"petAge":4,"petId":2,"petName":"Sudda","petType":"Cat"}* Connection #0 to host localhost left intact

	
##### 4. To get a pet by using type

	curl -v http://localhost:8080/v1/pets/type/Bird

You will get the following output

	*   Trying ::1...
	* TCP_NODELAY set
	* Connected to localhost (::1) port 8080 (#0)
	> GET /v1/pets/type/Bird HTTP/1.1
	> Host: localhost:8080
	> User-Agent: curl/7.55.1
	> Accept: */*
	>
	< HTTP/1.1 200 OK
	< Content-Length: 62
	< Content-Type: application/json
	<
	{"petAge":2,"petId":3,"petName":"Peththappu","petType":"Bird"}* Connection #0 to host localhost left intact
	
##### 5. To get a pet by using age

	curl -v http://localhost:8080/v1/pets/age/3

You will get the following output

	*   Trying ::1...
	* TCP_NODELAY set
	* Connected to localhost (::1) port 8080 (#0)
	> GET /v1/pets/age/3 HTTP/1.1
	> Host: localhost:8080
	> User-Agent: curl/7.55.1
	> Accept: */*
	>
	< HTTP/1.1 200 OK
	< Content-Length: 56
	< Content-Type: application/json
	<
	{"petAge":3,"petId":1,"petName":"Boola","petType":"Dog"}* Connection #0 to host localhost left intact
	
##### 6. To get all pets' IDs

	curl -v http://localhost:8080/v1/pets/getIds
	
You will get the following output

	*   Trying ::1...
	* TCP_NODELAY set
	* Connected to localhost (::1) port 8080 (#0)
	> GET /v1/pets/getIds HTTP/1.1
	> Host: localhost:8080
	> User-Agent: curl/7.55.1
	> Accept: */*
	>
	< HTTP/1.1 200 OK
	< Content-Length: 7
	< Content-Type: application/json
	<
	[1,2,3]* Connection #0 to host localhost left intact	
	
	
##### 7. To get all pets' Names

	curl -v http://localhost:8080/v1/pets/getNames
	
You will get the following output

	*   Trying ::1...
	* TCP_NODELAY set
	* Connected to localhost (::1) port 8080 (#0)
	> GET /v1/pets/getNames HTTP/1.1
	> Host: localhost:8080
	> User-Agent: curl/7.55.1
	> Accept: */*
	>
	< HTTP/1.1 200 OK
	< Content-Length: 30
	< Content-Type: application/json
	<
	["Boola","Sudda","Peththappu"]* Connection #0 to host localhost left intact	
	
##### 8. To get all types of pets

	curl -v http://localhost:8080/v1/pets/getTypes

You will get the following output

	*   Trying ::1...
	* TCP_NODELAY set
	* Connected to localhost (::1) port 8080 (#0)
	> GET /v1/pets/getTypes HTTP/1.1
	> Host: localhost:8080
	> User-Agent: curl/7.55.1
	> Accept: */*
	>
	< HTTP/1.1 200 OK
	< Content-Length: 20
	< Content-Type: application/json
	<
	["Dog","Cat","Bird"]* Connection #0 to host localhost left intact

##### 9. To add a pet

	curl --location --request POST 'http://localhost:8080/v1/pets/addPet' \
	--header 'Content-Type: application/json' \
	--data-raw '{
	        "petAge": 4,
	        "petId": 4,
	        "petName": "New Pet",
	        "petType": "New Type"
	    }'
	
##### 10. To update a pet  
	  
	curl --location --request PUT 'http://localhost:8080/v1/pets/updatePet/1' \
	--header 'Content-Type: application/json' \
	--data-raw '{
	        "petAge": 4,
	        "petId": 4,
	        "petName": "Updated Pet",
	        "petType": "Updated Type"
	    }'	    

##### 11. To delete a pet  

	curl --location --request DELETE 'http://localhost:8080/v1/pets/deletePet/1'


## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

    ./gradlew quarkusDev

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Creating a native executable

Mind having GRAALVM_HOME set to your Mandrel or GraalVM installation.

You can create a native executable using:

    ./gradlew build -Dquarkus.package.type=native

Or, if you don't have [Mandrel](https://github.com/graalvm/mandrel/releases/) or
[GraalVM](https://github.com/graalvm/graalvm-ce-builds/releases) installed, you can run the native executable
build in a container using:

    ./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true

Or to use Mandrel distribution:

    ./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true -Dquarkus.native.builder-image=quay.io/quarkus/ubi-quarkus-mandrel:20.3-java11

You can then execute your native executable with:

    ./build/petstore-runner

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.

## Specification examples

By default, there is always the creation of a JAX-RS application class to define the path on which the JAX-RS endpoints are available.

Also, a simple Hello world endpoint is created, have a look at the class **HelloController**.

More information on MicroProfile can be found [here](https://microprofile.io/)

### Config

Configuration of your application parameters. Specification [here](https://microprofile.io/project/eclipse/microprofile-config)

The example class **ConfigTestController** shows you how to inject a configuration parameter and how you can retrieve it programmatically.

### Fault tolerance

Add resilient features to your applications like TimeOut, RetryPolicy, Fallback, bulkhead and circuit breaker. Specification [here](https://microprofile.io/project/eclipse/microprofile-fault-tolerance)

The example class **ResilienceController** has an example of a FallBack mechanism where an fallback result is returned when the execution takes too long.

### Health

The health status can be used to determine if the 'computing node' needs to be discarded/restarted or not. Specification [here](https://microprofile.io/project/eclipse/microprofile-health)

The class **ServiceHealthCheck** contains an example of a custom check which can be integrated to health status checks of the instance.  The index page contains a link to the status data.

### Metrics

The Metrics exports _Telemetric_ data in a uniform way of system and custom resources. Specification [here](https://microprofile.io/project/eclipse/microprofile-metrics)

The example class **MetricController** contains an example how you can measure the execution time of a request.  The index page also contains a link to the metric page (with all metric info)

### JWT Auth

Using the OpenId Connect JWT token to pass authentication and authorization information to the JAX-RS endpoint. Specification [here](https://microprofile.io/project/eclipse/microprofile-rest-client)

Have a look at the **TestSecureController** class which calls the protected endpoint on the secondary application.
The **ProtectedController** (secondary application) contains the protected endpoint since it contains the _@RolesAllowed_ annotation on the JAX-RS endpoint method.

The _TestSecureController_ code creates a JWT based on the private key found within the resource directory.
However, any method to send a REST request with an appropriate header will work of course. Please feel free to change this code to your needs.

### Open API

Exposes the information about your endpoints in the format of the OpenAPI v3 specification. Specification [here](https://microprofile.io/project/eclipse/microprofile-open-api)

The index page contains a link to the OpenAPI information of your endpoints.

### Open Tracing

Allow the participation in distributed tracing of your requests through various micro services. Specification [here](https://microprofile.io/project/eclipse/microprofile-opentracing)

To show this capability download [Jaeger](https://www.jaegertracing.io/download/#binaries) and run ```./jaeger-all-in-one```.
Open [http://localhost:16686/](http://localhost:16686/) to see the traces. Mind that you have to access your demo app endpoint for any traces to show on Jaeger UI.

## Deploying Application

To deploy the demo app on a docker-compose please visit [./deploy](https://github.com/rasika/petstore/tree/master/deploy)
