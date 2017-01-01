# dropwizard-demo
Dropwizard Project in which some resources have been implemented coming from distinct on-line tutorials. 
The purpose is cleary to learn how to build a simple RESTful web service with Dropwizard.. 

## Echo
Simply echoes the query parameter echo.

URI: /echo?echo=xxxxxxxxxxxxxxxxxx

## Greeting
Simply says "Bonjour, {name}, "!"

URI: /greetings/{name}

## Hello world
Read the message from configuration.yml (messages.hello) and display it

URI: /hello

## Task list
Return all running tasks containing XXX in name. If contains is ommitted, return all running tasks 

URI: /task-list?contains=XXX

## CRUD opertions on an in-memory repository
How to implement create, read, update, delete operations (CRUD) on a resource.

URI: /events/, /events/{id}, implement GET, POST, PUT, DELETE

I'm using POSTMAN, a powerful GUI platform to make your API development faster & easier, from building API requests through testing, documentation and sharing.
