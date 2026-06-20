import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.addTask("Write", "Do architecture application", LocalDate.now().plusDays(5), "Ali");
        manager.addTask("Fixing bag", "Fix logic UI", LocalDate.now().minusDays(1), "Petr");
        manager.addTask("Review code", "Check pul-recent", LocalDate.now().plusDays(1), "Ivan");

        manager.printAllTasks();

        System.out.println("Translate tasks Ali in process...");
        manager.updateStatus(1, TaskStatus.IN_PROGRESS);


        System.out.println("\nTasks for employee 'Ali'");
        manager.getTasksByAssignee("Ali").forEach(System.out::println);


        manager.checkDeadlinesAndNotify();
        

        System.out.println("\nDelete done tasks from Petr...");
        manager.deleteTask(2);
        
        manager.printAllTasks();
    }
}
