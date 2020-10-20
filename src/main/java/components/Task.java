package components;

import java.time.LocalDate;
import java.util.Date;

public class Task {
    private String text;
    private final int id;
    private LocalDate deadline;

    public Task(String text, int id, LocalDate deadline) {
        this.text = text;
        this.id = id;
        this.deadline = deadline;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public int getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public LocalDate getDeadline() {
        return this.deadline;
    }

}
