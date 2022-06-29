package ah224uq_assign4.PriorityQueue;

public interface Task  {
	void createTask(int p, String d);

	void setTaskDescription(String d);

	int getTaskPriority();

	String getTaskDescription();

	void setTaskPriority(int n);

	String toString();

	boolean equals(Object o);

}
