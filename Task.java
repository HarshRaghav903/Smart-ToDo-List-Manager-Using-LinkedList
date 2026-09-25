public class Task {
    int taskId;
    String taskName;
    String description;
    String dueDate;
    String priority;
    boolean isCompleted;

    // Constructor
    public Task(int taskId, String taskName, String description,
                String dueDate, String priority) {

        this.taskId = taskId;
        this.taskName = taskName;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.isCompleted = false; // Every new task is pending
    }

    // Display task details
    public void displayTask() {
        System.out.println("--------------------------------");
        System.out.println("Task ID      : " + taskId);
        System.out.println("Task Name    : " + taskName);
        System.out.println("Description  : " + description);
        System.out.println("Due Date     : " + dueDate);
        System.out.println("Priority     : " + priority);
        System.out.println("Status       : " + (isCompleted ? "Completed" : "Pending"));
        System.out.println("--------------------------------");
    }
}