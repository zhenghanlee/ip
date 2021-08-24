package duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Encapsulates a task in DukeList.
 */
public abstract class Task {
    private boolean completed;
    protected String name;
    protected LocalDate date;

    public Task(String name) {
        this(name, false, null);
    }

    public Task(String name, boolean completed) {
        this(name, completed, null);
    }

    public Task(String name, LocalDate date) {
        this(name, false, date);
    }

    public Task(String name, boolean completed, LocalDate date) {
        this.name = name;
        this.date = date;
        this.completed = completed;
    }

    /**
     * Marks the task as completed.
     */
    public void markCompleted() {
        this.completed = true;
    }

    /**
     * Returns whether the task is completed.
     */
    public boolean isCompleted() {
        return this.completed;
    }

    /**
     * Returns the name of the task.
     * 
     * @return name of the task
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns date of the task. It could a deadline/date for the event.
     * 
     * @return date of task
     */
    public LocalDate getDate() {
        return this.date;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Task)
            return ((Task) obj).name.equals(this.name);
        return false;
    }

    @Override
    public String toString() {
        return "[" + (this.completed ? "X" : " ") + "] " + this.name;
    }

    public TaskType getType() {
        return TaskType.byTask(this.getClass());
    }

    protected String getDateString() {
        return this.date == null ? "" : this.date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }

}
