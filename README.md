# dropwizard-demo
Dropwizard Project in which some resources have been implemented coming from distinct tutorials on-line.

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
URI: /events/, /events/{id}
implement GET, POST, PUT, DELETE
