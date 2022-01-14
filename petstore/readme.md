# Pet Store


This project is a test automation for the API **`Pet store`**, using Junit, Rest Assured and Java with the automation pattern design called Screenplay pattern.
Is a combination of functional and unit test, focused the most of them on functional and E2E test for API



# Technology Required
- Java SDK 1.8
- Gradle 7.3 or lasted
- API for pet Store [project here](https://github.com/swagger-api/swagger-petstore)
# Technology Stack
The technology stack selects for this project  allows testing every application feature, and can be used for UI automated testing included web and mobile (Android, iOS) using the same architecture, sharing some functionalities to complete a E2E tests.
For example, we can use classes and methods created to test an API project, to facility steps of an E2E test.
All the technology stack selected for this testing project are listed below:
- SerenityBDD core version: 3.1.15
- SerenityRest
- Screenplay Pattern
- Rest assured 4.4.0

# How to run

1. Set up your environment as explained in the [readme](https://github.com/swagger-api/swagger-petstore)
2. Execute the following command:



     gradle clean test

# Test cases

All the test cases are listed below:

| Feature|Scenario  |
|--|--|
|**`Create pets`**  | Should pet be created when i send the pet information  |
|**`Create pets`**  |Should pet be created with ID when sends pet data without the field ID  |
|**`Create pets`**  | Should pet not be created when sends data without the name field  |
|**`Eliminate an order`**  | Should the order deleted when send an ID |
|**`Find pets`**  | Find pet with non exist ID |
|**`Find pets`**  | Should pets be show when sends pet tags |
|**`Find pets`**  | should service response be 400 when pet status does not exists |
|**`Find pets`**  | Should show pet info when pet status does exist |
|**`Store orders`**  |Should the order be created when send order info  |
|**`Update pets`**  | Should pet be not update when a non-existing ID is submitted  |
|**`Update pets`**  | Should pet be not update when without name field is submitted  |
|**`Update pets`**  |Should pet be update when submitting the required data |
|**`Upload pet image`**  | Should not upload the image when submit an invalid file type  |
|**`Upload pet image`**  | Should upload the image when submit the pet photo  |
|**`User login`**  | Should the user be able to log out |
|**`User login`**  | Should the user be logged in when submitting valid credentials  |
|**`User`**  |Should the user be created when send order info  |
|**`User`**  | Should the user be eliminated when send username  |





