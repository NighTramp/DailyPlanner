package ru.gb.dailyplanner.views;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import ru.gb.dailyplanner.models.TaskForTable;

public class ViewTable<T extends TaskForTable> {
    @FXML
    private final TableView<T> tableView;
    @FXML
    private final TableColumn<T, String> date;
    @FXML
    private final TableColumn<T, String> time;
    @FXML
    private final TableColumn<T, String> deadline;
    @FXML
    private final TableColumn<T, String> fullness;
    @FXML
    private final ObservableList<T> observableList;

    public ViewTable(TableView<T> tableView, TableColumn<T, String> date,
                     TableColumn<T, String> time, TableColumn<T, String> deadline,
                     TableColumn<T, String> fullness, ObservableList<T> observableList) {
        this.tableView = tableView;
        this.date = date;
        this.time = time;
        this.deadline = deadline;
        this.fullness = fullness;
        this.observableList = observableList;
    }

    public void sendOnTable() {
        tableView.setRowFactory(tv -> {
            TableRow<T> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    T rowData = row.getItem();
                    Alert alert = new Alert(
                            Alert.AlertType.CONFIRMATION, rowData + "\n\nДело сделано, удалить его?",
                            ButtonType.YES, ButtonType.NO);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.YES) {
                        Platform.runLater(() -> observableList.remove(rowData));
                        tableView.refresh();
                        alert.close();
                    }
                }
            });
            return row ;
        });
        date.setCellValueFactory(date -> date.getValue().dateProperty());
        time.setCellValueFactory(time -> time.getValue().timeProperty());
        deadline.setCellValueFactory(deadline -> deadline.getValue().deadlineProperty());
        fullness.setCellValueFactory(fullness -> fullness.getValue().fullnessProperty());
        tableView.setItems(observableList);
    }
}
