package exam_main.entities;

import java.util.ArrayList;

public class Boss extends User{
    private int projectToName;   // Danh sách các dự án mà Sếp quản lý
    private String tasksName;

    private String managaName;


    public Boss() {
    }

    public Boss(String username, String email, String password, String role, int projectToName) {
        super(username, email, password, role);
        this.projectToName = projectToName;
    }

    public String getTasksName() {
        return tasksName;
    }

    public void setTasksName(String tasksName) {
        this.tasksName = tasksName;
    }

    public int getProjectToName() {
        return projectToName;
    }

    public void setProjectToName(int projectToName) {
        this.projectToName = projectToName;
    }

    public String getManagaName() {
        return managaName;
    }

    public void setManagaName(String managaName) {
        this.managaName = managaName;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "projectToName=" + projectToName +
                ", tasksName='" + tasksName + '\'' +
                ", managaName='" + managaName + '\'' +
                '}';
    }
}
