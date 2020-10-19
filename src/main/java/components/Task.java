package components;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private String text;
    private final int id;
    private Date deadline;

    public Task(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDeadline(String deadline) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date date = formatter.parse(deadline);
            this.deadline = date;
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public Date getDeadline() {
        return this.deadline;
    }

}
