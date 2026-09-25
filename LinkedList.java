public class LinkedList {

    Node head;

    public LinkedList() {
        head = null;
    }

    // Add Task
    public void addTask(Task task) {

        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
        } else {

            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        System.out.println("Task Added Successfully!");
    }

    // Display All Tasks
    public void displayTasks() {

        if (head == null) {
            System.out.println("No Tasks Found.");
            return;
        }

        Node temp = head;

        while (temp != null) {

            temp.task.displayTask();

            temp = temp.next;
        }
    }

    // Search Task
    public void searchTask(String taskName) {

        if (head == null) {
            System.out.println("No Tasks Found.");
            return;
        }

        Node temp = head;

        while (temp != null) {

            if (temp.task.taskName.equalsIgnoreCase(taskName)) {

                System.out.println("Task Found!");
                temp.task.displayTask();
                return;
            }

            temp = temp.next;
        }

        System.out.println("Task Not Found.");
    }

    // Delete Task
    public void deleteTask(int taskId) {

        if (head == null) {
            System.out.println("No Tasks Found.");
            return;
        }

        if (head.task.taskId == taskId) {
            head = head.next;
            System.out.println("Task Deleted Successfully!");
            return;
        }

        Node temp = head;

        while (temp.next != null) {

            if (temp.next.task.taskId == taskId) {

                temp.next = temp.next.next;
                System.out.println("Task Deleted Successfully!");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Task Not Found.");
    }

    // Mark Task Completed
    public void markTaskCompleted(int taskId) {

        if (head == null) {
            System.out.println("No Tasks Found.");
            return;
        }

        Node temp = head;

        while (temp != null) {

            if (temp.task.taskId == taskId) {

                temp.task.isCompleted = true;
                System.out.println("Task Marked as Completed!");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Task Not Found.");
    }

    // Edit Task
    public void editTask(int taskId, String newName, String newDescription,
                         String newDueDate, String newPriority) {

        Node temp = head;

        while (temp != null) {

            if (temp.task.taskId == taskId) {

                temp.task.taskName = newName;
                temp.task.description = newDescription;
                temp.task.dueDate = newDueDate;
                temp.task.priority = newPriority;

                System.out.println("Task Updated Successfully!");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Task Not Found.");
    }

    // View Pending Tasks
    public void viewPendingTasks() {

        Node temp = head;

        boolean found = false;

        while (temp != null) {

            if (!temp.task.isCompleted) {

                temp.task.displayTask();
                found = true;
            }

            temp = temp.next;
        }

        if (!found) {
            System.out.println("No Pending Tasks.");
        }
    }

    // View Completed Tasks
    public void viewCompletedTasks() {

        Node temp = head;

        boolean found = false;

        while (temp != null) {

            if (temp.task.isCompleted) {

                temp.task.displayTask();
                found = true;
            }

            temp = temp.next;
        }

        if (!found) {
            System.out.println("No Completed Tasks.");
        }
    }

    // Return Head Node (Needed for File Handling)
    public Node getHead() {
        return head;
    }
}