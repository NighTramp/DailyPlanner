package ru.gb.dailyplanner.services;

import ru.gb.dailyplanner.models.Task;

import java.util.List;
import java.util.Map;

public interface ITaskService {
    void createTask(Map<String, String> data);
    void deleteTask(Integer id);
    List<Task> getAll();
    void clearAll();
}
