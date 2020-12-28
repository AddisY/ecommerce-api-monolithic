# ecommerce-api-monolithic

How to Install and use

Requirements

1. MySql

MySql is used as a database management system, so you need to install it and have user credentials.

2.  API testing tool (Postman recommended)

An API testing tool like Postman is required to be able to create and send all types of requests.

=> Intellij IDEA is recommended to easily download dependencies, build, and deploy the applications.


How to install

1. Start mysql and login with your credentials.

2. Create databases with the following names :-

If you are using MySql from the command line/ terminal, use this query to create the databases : CREATE DATABASE <database name here>;

ecommerceapi
Database for the monolithic application.

ecommerceapi_item
Database for the item & category management microservice.

ecommerceapi_shop
Database for the shop management microservice.

ecommerceapi_payment_address
Database for the user address & payment card management microservice.

3. Open the project/s with Intellij and let it download all the dependencies for you. If you are prompted to allow downloading dependencies automatically, allow that.

How to use

1. Open the projects with Intellij and click “run”(the red play button from the toolbar). This will build and deploy the project/s for you.

2. When the application is deployed it will create one test user (credentials - username: testuser password: p) and one admin user (username: admin password: p). You can add more users yourself.

3. I have provided Postman collections that contain requests with which you can use the applications, so you can import them to Postman to get started.

4. In order to login, open the request titled “login”, open “Auth” menu, set the type as “Basic Auth”, set username and password, and send the request.

For example : Here are some sequences of requests you can try.

- login as an admin -> create Category -> create Item.
- login as a user -> create Payment card -> create Shipping address -> list Item/s -> add CartItem/s to your Shopping cart -> checkout.
- login as an admin -> see order history -> get shipment info
