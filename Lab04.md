* Build a Spring Boot Web application __(lab04-ui)__ that takes the name of the movie as input
* Enter the name of the movie in a textbox and hit the button
* The movie name is pushed to a Queue say [X]

* Another service (__lab04-movie__) will continuously poll for new entries in the Queue [X] and pass them on to __**http://www.omdbapi.com/?i=tt3896198&apikey=52d1c7f&t=<moviename>**__ (Read the documentation for JSON response you get) and fetch the star cast and directors information

* For example go to _http://www.omdbapi.com/?i=tt3896198&apikey=52d1c7f&t=Dabangg_ and study the response 

* The movie data is stored in another Queue say [Y]

* The __(lab04-ui) application__ listens to [Y] collects the details and maintains it in a local cache
* It has an endpoint (__/details__) that displays all the movie details you have requested so far. Everytime you hit the endpoint __/details__ it displays list of all movies and their details

* Design the queues and responses appropriately