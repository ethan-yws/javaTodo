import components.Task;
import components.TodoList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.time.LocalDate;

public class TodoApp extends Application {
    private TodoList todoList;

    public TodoApp() {
        this.todoList = new TodoList();
    }

    @Override
    public void start(Stage appUI) throws Exception {
        //setup the App title
        appUI.setTitle("Todo List App");

        //create todo label
        Label todoLabel = new Label("Todo: ");
        //create todo text field
        TextField todoText = new TextField();

        //create deadline label
        Label deadlineLabel = new Label("Deadline: ");
        //create deadline date picker
        DatePicker deadlinePicker = new DatePicker();

        //create Add button
        Button addBtn = new Button("Add");

        //create HBOXs
        HBox hBox = new HBox(todoLabel, todoText, deadlineLabel, deadlinePicker, addBtn);
        //hBox.setLayoutX(20);
        //hBox.setLayoutY(50);
        hBox.setPadding(new Insets(50,10,10,17));
        hBox.setSpacing(4);

        //create a list to display todo items
        ListView<String> listView = new ListView<>();
        listView.setTranslateX(150);
        listView.setTranslateY(120);

        //Group all components
        Group group = new Group();
        group.getChildren().add(hBox);
        group.getChildren().add(listView);

        //Event handler
        addBtn.setOnAction(event -> {
            String todoContent = todoText.getText();
            LocalDate dueDate = deadlinePicker.getValue();
            //create the corresponding todo object
            Task newTask =  todoList.createTask(todoContent, dueDate);
            //add it to the todo item pool
            todoList.addTask(newTask);
            String taskDescription = String.format("%s\t\tDue %s", newTask.getText(), newTask.getDeadline());
            listView.getItems().add(taskDescription);
        });

        //create the scene
        Scene scene = new Scene(group, 560, 600, Color.rgb(238,238,238));

        //setup App UI
        appUI.setScene(scene);
        appUI.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
