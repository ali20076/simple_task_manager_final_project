import java.time.LocalDate;
public class Task {
    private static int idCounter = 1;
    private final int id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private String assignee;
    private TaskStatus status;

    public Task() {
        this.id = idCounter++;
    }

    public Task(String title, String description, LocalDate dueDate, String assignee, TaskStatus status) {
        this.id = idCounter++;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.assignee = assignee;
        this.status = status;
    }

    public int getId() { 
        return id; 
    }

    public String getTitle() { 
        return title; 
    }
    
    public String getDescription() { 
        return description; 
    }
    
    public LocalDate getDueDate() {
        return dueDate; 
    }
    
    public String getAssignee() {
        return assignee; 
    }
    
    public TaskStatus getStatus() {
        return status; 
    }

    public void setTitle(String title) { 
        this.title = title; 
    }

    public void setDescription(String description) { 
        this.description = description; 
    }

    public void setDueDate(LocalDate dueDate) { 
        this.dueDate = dueDate; 
    }

    public void setAssignee(String assignee) { 
        this.assignee = assignee; 
    }

    public void setStatus(TaskStatus status) {
        this.status = status; 
    }

    @Override
    public String toString() {
        return String.format("[%d] %s | Status: %s | Res: %s | Time: %s\nDescription: %s\n", 
                id, title, status, assignee, dueDate, description);
    }
}
