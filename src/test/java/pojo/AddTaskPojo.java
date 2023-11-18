package pojo;

public class AddTaskPojo {
	private boolean isCompleted;
	private String item;

	public AddTaskPojo(boolean isCompleted, String itemName) {
		this.isCompleted = isCompleted;
		this.item = itemName;
	}

	public boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(boolean completed) {
		isCompleted = completed;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String itemName) {
		this.item = itemName;
	}
}
