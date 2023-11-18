package apiRequests;

import pojo.AddTaskPojo;

import static io.restassured.RestAssured.given;

public class AddTasksApi {
	public void addTask(String tasksName) {
		AddTaskPojo body = new AddTaskPojo(false,tasksName);
		RegisterApi registerApi = new RegisterApi();
		given()
				.baseUri("https://qacart-todo.herokuapp.com")
				.header("Content-Type","application/json")
				.header("Authorization","Bearer "+registerApi.getAccess_token())
				.body(body)
		.when()
				.post("/api/v1/tasks")
		.then()
				.log().all();
	}
}
