package components;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TodoList {
    private List<Task> todoList;
    private List<Task> bin;
    private int taskIdIndex = 0;

    public TodoList() {
        this.todoList = new ArrayList<Task>();
        this.bin = new ArrayList<Task>();
    }

    /**
     * Generate a todo item object
     * @return a todoItem object
     */
    public Task createTask(String text, LocalDate deadline) {
        Task newTask = new Task(text, generateTaskId(), deadline);
        System.out.printf("Task created!\tID: %d\tTask: %s\tDue: %s\n",newTask.getId(), newTask.getText(),newTask.getDeadline());
        return newTask;
    }

    /**
     * Helper method to update the task id
     * @return taskID
     */
    public int generateTaskId() {
        taskIdIndex += 1;
        return taskIdIndex;
    }

    /**
     * Helper method to convert string to date
     * @param deadline
     * @return the corresponding date object
     */
    public Date stringToDate(String deadline) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date date = formatter.parse(deadline);
            System.out.println(date);
            System.out.println(formatter.format(date));
            return date;

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Add a task to the todo list
     * @param task
     */
    public void addTask(Task task) {
        todoList.add(task);
        System.out.println("Task added!");
    }

    /**
     * delete a task from the todo list
     * and put it to bin
     * @param taskId
     */
    public void deleteTask(int taskId) {
        Iterator<Task> itr = todoList.iterator();
        while (itr.hasNext()) {
            Task task = itr.next();

            if (taskId == task.getId()) {
                bin.add(task);
                todoList.remove(task);
                System.out.println("Task Removed!");
            }
        }
    }


}
