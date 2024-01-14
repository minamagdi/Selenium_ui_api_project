package pojo;

import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
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
}
