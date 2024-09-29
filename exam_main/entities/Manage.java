package exam_main.entities;

import java.util.ArrayList;

public class Manage extends User {
    private String id;
    private String department;
    private String staffName;
    private int staffId;
    private String tasksAssigned;
    public Manage() {
    }

    public Manage(String username, String email, String password, String role, String id, String department) {
        super(username, email, password, role);
        this.id = id;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getTasksAssigned() {
        return tasksAssigned;
    }

    public void setTasksAssigned(String tasksAssigned) {
        this.tasksAssigned = tasksAssigned;
    }

    @Override
    public String toString() {
        return "Manage{" +
                "id='" + id + '\'' +
                ", department='" + department + '\'' +
                ", staffName='" + staffName + '\'' +
                ", staffId=" + staffId +
                '}';
    }
}
