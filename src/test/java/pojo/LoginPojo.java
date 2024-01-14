package pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class LoginPojo { // pojo class to deal with request body like => string, map, json file
	private String email;
	private String password;

	public LoginPojo(String email, String password) {
		this.email = email;
		this.password = password;
	}
}
