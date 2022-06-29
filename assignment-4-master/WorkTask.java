package ah224uq_assign4.PriorityQueue;

public class WorkTask implements Task {
	private int priority = 0;
	private String description = "";

	
	public WorkTask() {

	}

	
	public WorkTask(int priority, String description) {
		checkInt(priority);
		this.priority = priority;
		this.description = description;
	}

	public void createTask(int priority, String description) {
		checkInt(priority);
		this.priority = priority;
		this.description = description;
	}

	

	public void setTaskDescription(String describe) {
		description = describe;
	}

	public int getTaskPriority() {
		return priority;
	}

	public String getTaskDescription() {
		return description;
	}

	public void setTaskPriority(int n) {
		checkInt(n);
		priority = n;
	}

	@Override
	public String toString() {
		return "Priority: " + priority + ",  Task: " + description;
	}

	
	private void checkInt(int a) {
		if (a > 0)
			return;
		else
			throw new IllegalArgumentException("Must be positive.");
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof WorkTask) {
			Task t = (WorkTask) o;
			return this.priority == t.getTaskPriority() && this.description.equals(t.getTaskDescription());
		}
		return false;
}

}
