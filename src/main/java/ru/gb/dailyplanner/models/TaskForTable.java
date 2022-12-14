package ru.gb.dailyplanner.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TaskForTable {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty date;
    private final SimpleStringProperty time;
    private final SimpleStringProperty deadline;
    private final SimpleStringProperty fullness;
    private final SimpleStringProperty priority;
    private final SimpleStringProperty text;

    public TaskForTable(Integer id, String date, String time,
                        String deadline, String fullness,
                        String priority, String text) {
        this.id = new SimpleIntegerProperty(id);
        this.date = new SimpleStringProperty(date);
        this.time = new SimpleStringProperty(time);
        this.deadline = new SimpleStringProperty(deadline);
        this.fullness = new SimpleStringProperty(fullness);
        this.priority = new SimpleStringProperty(priority);
        this.text = new SimpleStringProperty(text);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public String getTime() {
        return time.get();
    }

    public SimpleStringProperty timeProperty() {
        return time;
    }

    public String getDeadline() {
        return deadline.get();
    }

    public SimpleStringProperty deadlineProperty() {
        return deadline;
    }

    public String getFullness() {
        return fullness.get();
    }

    public SimpleStringProperty fullnessProperty() {
        return fullness;
    }

    public String getPriority() {
        return priority.get();
    }

    public SimpleStringProperty priorityProperty() {
        return priority;
    }

    public String getTask() {
        return text.get();
    }

    public SimpleStringProperty taskProperty() {
        return text;
    }

    @Override
    public String toString() {
        return "???????? No " + id.get() +
                "\n - ???????? ????????????????: " + date.get() +
                "\n - ?????????? ????????????????: " + time.get() +
                "\n - DEADLINE ????????: " + deadline.get() +
                "\n - ?????? ??????????????????: " + fullness.get() +
                "\n - ??????????????????: " + priority.get() +
                "\n - ???????? ????????: " + text.get();
    }
}
