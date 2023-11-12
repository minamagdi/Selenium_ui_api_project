package pojo;

import com.github.javafaker.Faker;

public class RegisterPojo {
	private String email;
	private String firstName;
	private String lastName;
	private String password;

	public RegisterPojo() {
		this.email = Faker.instance().internet().emailAddress();
		this.firstName = Faker.instance().name().firstName();
		this.lastName = Faker.instance().name().lastName();
		this.password = Faker.instance().internet().password();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
