package apiRequests;

import pojo.AddTaskPojo;

import static io.restassured.RestAssured.given;

public class AddTasksApi {
	public void addTask(String token) {
		AddTaskPojo body = new AddTaskPojo(false,"learn selenium");
//        AddTaskPojo body = AddTaskPojo.builder().isCompleted(false).item("learn selenium").build();
		given()
				.baseUri("https://qacart-todo.herokuapp.com")
				.header("Content-Type","application/json")
				//.header("Authorization","Bearer "+registerApi.getAccess_token())
				.auth().oauth2(token)
				.body(body)
		.when()
				.post("/api/v1/tasks")
		.then()
				.log().all();
	}
}
