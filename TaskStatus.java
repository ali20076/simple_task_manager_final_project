public enum TaskStatus {
    TO_DO("Doing..."),
    IN_PROGRESS("In proccesing"),
    DONE("Done");

    private final String title;

    TaskStatus(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}