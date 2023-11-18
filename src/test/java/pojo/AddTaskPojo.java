package pojo;

public class AddTaskPojo {
	private boolean isCompleted;
	private String itemName;

	public AddTaskPojo(boolean isCompleted, String itemName) {
		this.isCompleted = isCompleted;
		this.itemName = itemName;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean completed) {
		isCompleted = completed;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
