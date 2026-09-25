import java.io.*;

public class FileManager {

    private static final String FILE_NAME = "tasks.txt";

    // Save Tasks to File
    public static void saveTasks(LinkedList list) {

        try {

            PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME));

            Node temp = list.getHead();

            while (temp != null) {

                writer.println(
                        temp.task.taskId + "," +
                        temp.task.taskName + "," +
                        temp.task.description + "," +
                        temp.task.dueDate + "," +
                        temp.task.priority + "," +
                        temp.task.isCompleted);

                temp = temp.next;
            }

            writer.close();

            System.out.println("Tasks Saved Successfully!");

        } catch (IOException e) {

            System.out.println("Error Saving Tasks!");
        }
    }

    // Load Tasks from File
    public static void loadTasks(LinkedList list) {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try {

            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Task task = new Task(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        data[4]);

                task.isCompleted = Boolean.parseBoolean(data[5]);

                list.addTask(task);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Error Loading Tasks!");
        }
    }
}