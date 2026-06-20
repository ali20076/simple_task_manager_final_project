import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskManager{
    private final List<Task> tasks = new ArrayList<>();

    public void addTask(String title, String description, LocalDate dueDate, String assignee) {
        Task newTask = new Task(title, description, dueDate, assignee, TaskStatus.TO_DO);
        tasks.add(newTask);
        System.out.println("Task successfully added in UI: " + newTask.getId());
    }

    public void printAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("List of tasks is empty");
            return;
        }
        System.out.println("--- List of all tasks ---");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }


    public boolean deleteTask(int id) {
        Task task = findTaskById(id);
        if (task != null) {
            tasks.remove(task);
            return true;
        }
        return false;
    }

    public boolean updateStatus(int id, TaskStatus newStatus) {
        Task task = findTaskById(id);
        if (task != null) {
            task.setStatus(newStatus);
            return true;
        }
        return false;
    }


    public List<Task> getTasksByAssignee(String assignee) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getAssignee().equalsIgnoreCase(assignee)) {
                result.add(task);
            }
        }
        return result;
    }

    public void checkDeadlinesAndNotify() {
        LocalDate today = LocalDate.now();
        System.out.println("\n Checking deadlines:");
        
        boolean foundIssues = false;
        for (Task task : tasks) {
            if (task.getStatus() == TaskStatus.DONE) continue;

            if (task.getDueDate().isBefore(today)) {
                System.out.printf("Warning! Task [%d] \"%s\" Done! Message sent employee: %s\n", 
                        task.getId(), task.getTitle(), task.getAssignee());
                foundIssues = true;
            } else if (task.getDueDate().isEqual(today) || task.getDueDate().isBefore(today.plusDays(3))) {
                System.out.printf("Warning! Task [%d] \"%s\" ready for deadline (%s). Responsibility: %s\n", 
                        task.getId(), task.getTitle(), task.getDueDate(), task.getAssignee());
                foundIssues = true;
            }
        }
        
        if (!foundIssues) {
            System.out.println("Done tasks not yet. All going to plans!");
        }
    }
}
