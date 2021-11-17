# PetStore Application

## How to build and/or deploy the API

First clone the repository.
	
	git clone https://github.com/Pathmila/Middleware-Architecture-Mini-Project.git 
	
Go to the git bash and enter following commands.

To build the application:

    ./gradlew build -Dquarkus.package.type=uber-jar

To run the application:

    java -jar build/petstore-runner.jar


## How to run test suite

Go the the browser and navigate to the following URLs

###Adding/View/Update/Delete pets-types through the API 

##### 1. To get all type

	http://localhost:8080/v1/types 

##### 2. To add a type

	http://localhost:8080/v1/types/addType 
	
##### 3. To update a type

	http://localhost:8080/v1/types/updateType/5 
	
##### 4. To delete a type

	http://localhost:8080/v1/types/deletePet/5


###Adding/View/Update/Delete pets through the API 

##### 1. To get all pets
	
	http://localhost:8080/v1/pets/

##### 2. To add a pet

	http://localhost:8080/v1/pets/addPet
	
##### 3. To update a pet  

	http://localhost:8080/v1/pets/updatePet/1
	
##### 4. To delete a pet  

	http://localhost:8080/v1/pets/deletePet/1
	

###Search for pets by name, age, id and type through the API  
	
##### 1. To get a pet by using ID

	http://localhost:8080/v1/pets/id/1
	
##### 2. To get a pet by using name

	http://localhost:8080/v1/pets/name/Sudda
	
##### 3. To get a pet by using type

	http://localhost:8080/v1/pets/type/Bird
	
##### 4. To get a pet by using age

	http://localhost:8080/v1/pets/age/3
	
##### 5. To get all pets' IDs

	http://localhost:8080/v1/pets/getIds	
	
##### 6. To get all pets' Names

	http://localhost:8080/v1/pets/getNames
	
##### 7. To get all types of pets

	http://localhost:8080/v1/pets/getTypes
	
	
## How to run a CURL/WGET command to test the APIs once deployed

Go to your command prompt and give the following commands to test the APIs.

###Adding/View/Update/Delete pets-types through the API 

##### 1. To get all type

	curl -X GET "http://localhost:8080/v1/types"
	
You will get the following output	
	
	[{"petType":"Dog","typeId":1},{"petType":"Cat","typeId":2},{"petType":"Bird","typeId":3},{"petType":"Rabit","typeId":4}]

##### 2. To add a type

	curl -X POST "http://localhost:8080/v1/types/addType" -H "Content-Type: application/json" --data-raw "{ \"petType\": \"Fish\", \"typeId\": 5}"
	
You will get the following output

	[{"petType":"Dog","typeId":1},{"petType":"Cat","typeId":2},{"petType":"Bird","typeId":3},{"petType":"Rabit","typeId":4},{"petType":"Fish","typeId":5},{"petType":"Fish","typeId":5}]

##### 3. To update a type

	curl -X PUT "http://localhost:8080/v1/types/updateType/5" -H "Content-Type: application/json" --data-raw "{ \"petType\": \"Butterfly\", \"typeId\": 5}"
	
You will get the following output

	[{"petType":"Dog","typeId":1},{"petType":"Cat","typeId":2},{"petType":"Bird","typeId":3},{"petType":"Rabit","typeId":4},{"petType":"Butterfly","typeId":5}]

##### 4. To delete a type

	curl -X DELETE "http://localhost:8080/v1/types/deletePet/5"
	
You will get the following output

	[{"petType":"Dog","typeId":1},{"petType":"Cat","typeId":2},{"petType":"Bird","typeId":3},{"petType":"Rabit","typeId":4}]


###Adding/View/Update/Delete pets through the API 

##### 1. To get all pets
	
	curl -X GET http://localhost:8080/v1/pets
	
You will get the following output

	[{"petAge":3,"petId":1,"petName":"Boola","petType":"Dog"},{"petAge":4,"petId":2,"petName":"Sudda","petType":"Cat"},{"petAge":2,"petId":3,"petName":"Peththappu","petType":"Bird"}]

##### 2. To add a pet

	curl -X POST "http://localhost:8080/v1/pets/addPet" -H "Content-Type: application/json" --data-raw "{\"petAge\": 1,\"petId\": 1,\"petName\": \"New Pet\",\"petType\": \"New Type\"}"
	
You will get the following output
	
	[{"petAge":4,"petId":2,"petName":"Sudda","petType":"Cat"},{"petAge":2,"petId":3,"petName":"Peththappu","petType":"Bird"},{"petAge":1,"petId":1,"petName":"New Pet","petType":"New Type"}]
	
##### 3. To update a pet  
	  
	curl -X PUT "http://localhost:8080/v1/pets/updatePet/1" -H "Content-Type: application/json" --data-raw "{\"petAge\": 7,\"petId\": 1,\"petName\": \"Update Pet\",\"petType\": \"Update Type\"}"  
	
You will get the following output
	
	[{"petAge":4,"petId":2,"petName":"Sudda","petType":"Cat"},{"petAge":2,"petId":3,"petName":"Peththappu","petType":"Bird"},{"petAge":7,"petId":1,"petName":"Update Pet","petType":"Update Type"}]

##### 4. To delete a pet  

	curl -X DELETE "http://localhost:8080/v1/pets/deletePet/1"
	
You will get the following output

	[{"petAge":4,"petId":2,"petName":"Sudda","petType":"Cat"},{"petAge":2,"petId":3,"petName":"Peththappu","petType":"Bird"}]	


###Search for pets by name, age, id and type through the API 

	
##### 1. To get a pet by using ID

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
	
##### 2. To get a pet by using name

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

	
##### 3. To get a pet by using type

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
	
##### 4. To get a pet by using age

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
	
##### 5. To get all pets' IDs

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
	
	
##### 6. To get all pets' Names

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
	
##### 7. To get all types of pets

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


