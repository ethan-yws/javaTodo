package components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TodoList {
    private List todoList;
    private List bin;
    private int taskIdIndex = 0;

    public TodoList() {
        this.todoList = new ArrayList();
    }

    /**
     * Generate a todo item object
     * @return a todoItem object
     */
    public Task createTask() {
        Task newTask = new Task(generateTaskId());
        return newTask;
    }

    public int generateTaskId() {
        taskIdIndex += 1;
        return taskIdIndex;
    }

    /**
     * Add a task to the todo list
     * @param task
     */
    public void addTask(Task task) {
        bin.add(task);
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
