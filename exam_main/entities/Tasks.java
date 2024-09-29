package exam_main.entities;

import java.time.LocalDate;

public class Tasks {
    private String taskName;          // Tên của nhiệm vụ
    private String description;       // Mô tả chi tiết nhiệm vụ
    private LocalDate dueDate;       // Thời hạn hoàn thành
    // thời gian tạo
    private String status;            // Trạng thái nhiệm vụ

    private String assignedTo;
    public Tasks() {
    }

    public Tasks(String taskName, String description,LocalDate dueDate, String status) {
        this.taskName = taskName;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", assignedTo='" + '\'' +
                ", dueDate=" + dueDate +
                ", status='" + status + '\'' +
                '}';
    }
}
