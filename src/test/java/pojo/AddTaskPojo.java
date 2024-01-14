package pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class AddTaskPojo {
	private boolean isCompleted;
	private String item;

	public AddTaskPojo(boolean isCompleted, String itemName) {
		this.isCompleted = isCompleted;
		this.item = itemName;
	}
}
