# README #

### How do I get set up? ###
```bash
user@cpu ~ % git clone https://github.com/reisbergindrek/test-task.git (grabs code to your local computer)
user@cpu ~ % ...
user@cpu ~ % cd test-task
user@cpu ~ % docker image build -t indrek-java-webapp . (runs Dockerfile, with Maven which compiles the .war, also runs tests)
user@cpu ~ % ...
user@cpu ~ % docker container run -it --publish 1337:8080 indrek-java-webapp (runs web app on port 1337)

```
Now when the server is running, you can use terminal to send the requests as such:

```bash
user@cpu ~ % curl -d 10 http://localhost:1337/
user@cpu ~ % curl -d 5 http://localhost:1337/
user@cpu ~ % curl -d 30303 http://localhost:1337/
user@cpu ~ % curl -d end http://localhost:1337/
30318%
user@cpu ~ % 

```

### Notes ###

* Unfortunately couldn't get the SumControllerTest running!?
* Weird % sign when returning the response!?