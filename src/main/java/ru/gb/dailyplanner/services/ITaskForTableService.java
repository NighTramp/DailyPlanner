package ru.gb.dailyplanner.services;

import javafx.collections.ObservableList;
import ru.gb.dailyplanner.models.TaskForTable;
import ru.gb.dailyplanner.models.TaskForTable;

import java.util.Map;

public interface ITaskForTableService {
    ObservableList<TaskForTable> getAll();
    void addTaskForTable(TaskForTable taskForTable);
    Map<String, ObservableList<TaskForTable>> sortAll();
}
