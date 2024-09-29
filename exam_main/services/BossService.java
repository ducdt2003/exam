package exam_main.services;
import exam_main.data.Database;
import exam_main.entities.*;
import exam_main.utils.Constant;
import java.util.ArrayList;
import java.util.Scanner;

public class BossService {

    // chưc năng 1 tạo dự án
    public void addProject(Scanner sc){
        ProjectService projectService = new ProjectService();
        Project project = projectService.createProject(sc);
    }
    //  chức năng 9 hiên thị ra dự án
    public void displayProject(){
        for (Project project: Database.projects) {
            System.out.println(project);
        }
    }

    // chức nắng số 5 : quản lý thành viên
    public void appointManager(Scanner sc, ArrayList<User> users) {
        System.out.println("Nhập tên tài khoản nhân viên muốn bổ nhiệm làm trưởng phòng: ");
        String staffUsername = sc.nextLine();

        // Tìm kiếm nhân viên
        User staff = findUserByUsername(staffUsername, users);
        if (staff != null && staff.getRole().equals(Constant.ROLE_STAFF)) {
            // Thay đổi vai trò thành trưởng phòng
            staff.setRole(Constant.ROLE_MANAGE);
            System.out.println("Đã bổ nhiệm " + staffUsername + " làm trưởng phòng.");
        } else {
            System.out.println("Không tìm thấy nhân viên hoặc nhân viên này không phải là nhân viên.");
        }
    }

    public void appointStaff(Scanner sc, ArrayList<User> users) {
        System.out.println("Nhập tên tài khoản nhân viên muốn bổ nhiệm làm trưởng phòng: ");
        String staffUsername = sc.nextLine();

        // Tìm kiếm nhân viên
        User staff = findUserByUsername(staffUsername, users);
        if (staff != null && staff.getRole().equals(Constant.ROLE_MANAGE)) {
            // Thay đổi vai trò thành trưởng phòng
            staff.setRole(Constant.ROLE_STAFF);
            System.out.println("Đã bổ nhiệm " + staffUsername + " làm trưởng phòng.");
        } else {
            System.out.println("Không tìm thấy nhân viên hoặc nhân viên này không phải là nhân viên.");
        }
    }





    // Tìm kiếm username trong danh sách người dùng
    public User findUserByUsername(String userName, ArrayList<User> users) {
        for (User user : users) {
            if (user.getUsername().equals(userName)) {
                return user; // Trả về người dùng tìm thấy
            }
        }
        return null;
    }








    // Phương thức hiển thị tất cả nhân viên và trưởng phòng
    public void displayStaffAndManagers(ArrayList<User> users) {
        System.out.println("--- Danh sách Nhân viên và Trưởng phòng ---");
        for (User user : users) {
            if (user.getRole().equals(Constant.ROLE_STAFF)) {
                System.out.println("Nhân viên: " + user.getUsername() + "\t--" + user.getEmail() + "\t--" + user.getRole());
            } else if (user.getRole().equals(Constant.ROLE_MANAGE)) {
                System.out.println("Trưởng phòng: " + user.getUsername()+ "\t--" + user.getEmail() + "\t--" + user.getRole());
            }
        }
    }



}
