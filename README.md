Start the API by running 'gradlew bootRun' or 'java -jar build/libs/cygni-0.1.0.jar'.

Use Postman (https://www.getpostman.com/) or any other program that lets you send HTTP-requests to access the API. Use Content-Type: application/json for all POST-requests. If the request has been successful the client should get a HTTP 200 OK response along with other relevant info. If the request was unsuccessful, a HTTP 400 Bad Request response is received by the client.

To create a new game, send a POST-request to /api/games with your name in the request-body as such: {"name": "YourName"}. If a new game has been created you will get its id in the response.

To join an existing game, send a POST-request to /api/games/{id}/join with your name in the request-body as such: {"name": "YourName"}

To make a move, send a POST-request to /api/games/{id}/move with your name and move in the request-body as such: {"name": "YourName", "move": "YourMove"}. Allowed moves are rock, paper and scissor. 

To view the state of a game, send a GET-request to /api/games/{id}. If both players have made their moves the outcome can be viewed, otherwise only the names of the players is given.
