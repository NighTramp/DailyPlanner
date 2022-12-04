package ru.gb.dailyplanner.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Task {
    private static final AtomicInteger GUID = new AtomicInteger(0);
    private Integer id;
    private String date;
    private String time;
    private String deadLine;
    private String fullName;
    private Priority priority;
    private String text;


    public Task(String deadLine, String name, String patronymic,
                String surname, Priority priority, String text) {
        this.id = GUID.incrementAndGet();

        LocalDate localDate = LocalDate.now();
        this.date = localDate.getDayOfMonth() + "." +
                localDate.getMonthValue() + "." +
                localDate.getYear();

        LocalTime localTime = LocalTime.now();
        this.time = localTime.getHour() + ":" +
                localTime.getMinute();

        this.deadLine = deadLine;
        this.fullName = name + " " + patronymic + " " + surname;
        this.priority = priority;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(date, task.date) &&
                Objects.equals(time, task.time) && Objects.equals(deadLine, task.deadLine) &&
                Objects.equals(fullName, task.fullName) && priority == task.priority &&
                Objects.equals(text, task.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, time, deadLine, fullName, priority, text);
    }

    @Override
    public String toString() {
        return ("Task No "+ id +
                ", date=" + date +
                ", time=" + time +
                ", deadLine=" + deadLine +
                ", fullName=" + fullName +
                ", priority=" + priority +
                ", text=" + text + "\n")
                .replace("[", "")
                .replace("]", "");
    }
}
