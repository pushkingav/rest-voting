**Task description**

Build a voting system for deciding where to have lunch.

* 2 types of users: admin and regular users.
* Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price).
* Menu changes each day (admins do the updates).
* Users can vote on which restaurant they want to have lunch at.
* Only one vote counted per user.
* If user votes again the same day:
  * If it is before 11:00 we assume that he changed his mind.
  * If it is after 11:00 then it is too late, vote can't be changed

Each restaurant provides new menu each day.

As a result, provide a link to github repository.

It should contain the code and README.md with API documentation and curl commands to get data for voting and vote.

P.S.: Make sure everything works with latest version that is on github :)

P.P.S.: Assume that your API will be used by a frontend developer to build frontend on top of that.


**Developer's remarks**
* You can find the REST API Documentation including curl commands in the `target/generated-docs/api-guide.html` after running tests and the 
mvn package task.
* The `last.voting.time` and other props described here are set in the `src\main\resources\application.properties`.
* The `last.voting.time` is given in UTC and is proceeded in UTC. This prop is mentioned at the task description under the point "If user  votes again the same day".
* Please set the `application.http.port` property in the `application.properties` according to your tomcat settings. This is needed for 
tests and rest api documentation that is generated automatically on every package task. 
* There is a directory of dishes in db. See the DISHES table.
