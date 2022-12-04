package ru.gb.dailyplanner.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import ru.gb.dailyplanner.models.Priority;
import ru.gb.dailyplanner.models.TaskForTable;
import ru.gb.dailyplanner.services.TaskForTableService;
import ru.gb.dailyplanner.services.TaskService;
import ru.gb.dailyplanner.ChildWindow;
import ru.gb.dailyplanner.views.ViewTable;

import java.net.URL;
import java.util.ResourceBundle;

public class DailyPlannerController implements Initializable {
    @FXML
    private TableView<TaskForTable> low;
    @FXML
    private TableColumn<TaskForTable, String> dateLow;
    @FXML
    private TableColumn<TaskForTable, String> timeLow;
    @FXML
    private TableColumn<TaskForTable, String> deadlineLow;
    @FXML
    private TableColumn<TaskForTable, String> fullnessLow;
    @FXML
    private TableView<TaskForTable> middle;
    @FXML
    private TableColumn<TaskForTable, String> dateMiddle;
    @FXML
    private TableColumn<TaskForTable, String> timeMiddle;
    @FXML
    private TableColumn<TaskForTable, String> deadLineMiddle;
    @FXML
    private TableColumn<TaskForTable, String> fullnessMiddle;
    @FXML
    private TableView<TaskForTable> high;
    @FXML
    private TableColumn<TaskForTable, String> dateHigh;
    @FXML
    private TableColumn<TaskForTable, String> timeHigh;
    @FXML
    private TableColumn<TaskForTable, String> deadlineHigh;
    @FXML
    private TableColumn<TaskForTable, String> fullnessHigh;
    @FXML
    private Button addHigh;

    private final TaskService taskService = new TaskService();
    private final TaskForTableService taskForTableService = new TaskForTableService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initTable();
    }

    public void createTask(MouseEvent mouseEvent) {
        ChildWindow childWindow = new ChildWindow();
        childWindow.start();
        if (!(childWindow.getResult()).isEmpty()) {
            taskService.createTask(childWindow.getResult());
            taskService.clearAll();
            taskForTableService.clearAll();
            refreshTable();
        }
    }

    private void initTable() {
        ViewTable<TaskForTable> tableLow = new ViewTable<>(low, dateLow, timeLow, deadlineLow,
                fullnessLow, taskForTableService.sortAll().get(Priority.LOW.getPriority()));
        tableLow.sendOnTable();
        ViewTable<TaskForTable> tableMiddle = new ViewTable<>(middle, dateMiddle, timeMiddle, deadLineMiddle,
                fullnessMiddle, taskForTableService.sortAll().get(Priority.MIDDLE.getPriority()));
        tableMiddle.sendOnTable();
        ViewTable<TaskForTable> tableHigh = new ViewTable<>(high, dateHigh, timeHigh, deadlineHigh,
                fullnessHigh, taskForTableService.sortAll().get(Priority.HIGH.getPriority()));
        tableHigh.sendOnTable();
    }

    public void refreshTable() {
        Platform.runLater(() -> {
            low.getItems().clear();
            high.getItems().clear();
            middle.getItems().clear();
        });
        Platform.runLater(this::initTable);
    }
}