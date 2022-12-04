package ru.gb.dailyplanner.models;

public enum Priority {
    LOW("LOW"),
    MIDDLE("MIDDLE"),
    HIGH("HIGH");
    private final String priority;

    Priority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }
}
