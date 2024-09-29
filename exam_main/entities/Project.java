package exam_main.entities;

import java.time.LocalDate;
import java.util.ArrayList;

public class Project {
    private String projectName;
    private String projectDescribe;
    private LocalDate startDate;
    private LocalDate endDate;
    private String tasksName;
    private int manageId;
    public Project() {
    }

    public Project(String projectName, String projectDescribe, LocalDate startDate, LocalDate endDate) {
        this.projectName = projectName;
        this.projectDescribe = projectDescribe;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescribe() {
        return projectDescribe;
    }

    public void setProjectDescribe(String projectDescribe) {
        this.projectDescribe = projectDescribe;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getTasksName() {
        return tasksName;
    }

    public void setTasksName(String tasksName) {
        this.tasksName = tasksName;
    }

    public int getManageId() {
        return manageId;
    }

    public void setManageId(int manageId) {
        this.manageId = manageId;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", projectDescribe='" + projectDescribe + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", tasksName='" + tasksName + '\'' +
                ", manageId=" + manageId +
                '}';
    }
}
