import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedList taskList = new LinkedList();

        // Load saved tasks when the program starts
        FileManager.loadTasks(taskList);

        while (true) {

            System.out.println("\n========== SMART TO-DO LIST MANAGER ==========");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Search Task");
            System.out.println("4. Edit Task");
            System.out.println("5. Delete Task");
            System.out.println("6. Mark Task Completed");
            System.out.println("7. View Pending Tasks");
            System.out.println("8. View Completed Tasks");
            System.out.println("9. Save Tasks");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Description: ");
                    String description = sc.nextLine();

                    System.out.print("Enter Due Date: ");
                    String dueDate = sc.nextLine();

                    System.out.print("Enter Priority (High/Medium/Low): ");
                    String priority = sc.nextLine();

                    Task task = new Task(id, name, description, dueDate, priority);

                    taskList.addTask(task);

                    break;

                case 2:

                    taskList.displayTasks();

                    break;

                case 3:

                    System.out.print("Enter Task Name to Search: ");
                    String searchName = sc.nextLine();

                    taskList.searchTask(searchName);

                    break;

                case 4:

                    System.out.print("Enter Task ID to Edit: ");
                    int editId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Task Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Description: ");
                    String newDescription = sc.nextLine();

                    System.out.print("Enter New Due Date: ");
                    String newDueDate = sc.nextLine();

                    System.out.print("Enter New Priority: ");
                    String newPriority = sc.nextLine();

                    taskList.editTask(editId, newName, newDescription, newDueDate, newPriority);

                    break;

                case 5:

                    System.out.print("Enter Task ID to Delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();

                    taskList.deleteTask(deleteId);

                    break;

                case 6:

                    System.out.print("Enter Task ID to Mark Completed: ");
                    int completeId = sc.nextInt();
                    sc.nextLine();

                    taskList.markTaskCompleted(completeId);

                    break;

                case 7:

                    taskList.viewPendingTasks();

                    break;

                case 8:

                    taskList.viewCompletedTasks();

                    break;

                case 9:

                    FileManager.saveTasks(taskList);

                    break;

                case 10:

                    FileManager.saveTasks(taskList);

                    System.out.println("Thank You!");

                    sc.close();

                    return;

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}