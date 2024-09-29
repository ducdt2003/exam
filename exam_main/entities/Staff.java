package exam_main.entities;

import java.util.ArrayList;

public class Staff extends User {
    private String id;                 // Mã định danh của nhân viên
    private String position;           // Chức vụ của nhân viên
    private String staffName;          // Danh sách nhiệm vụ của nhân viên
    private String tasksName;

    public Staff() {
    }

    public Staff(String username, String email, String password, String role, String id, String position) {
        super(username, email, password, role);
        this.id = id;
        this.position = position;
    }

    public String getTasksName() {
        return tasksName;
    }

    public void setTasksName(String tasksName) {
        this.tasksName = tasksName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id='" + id + '\'' +
                ", position='" + position + '\'' +
                ", staffName='" + staffName + '\'' +
                ", tasksName='" + tasksName + '\'' +
                '}';
    }
}
