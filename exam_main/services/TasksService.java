package exam_main.services;

import exam_main.data.Database;
import exam_main.entities.Manage;
import exam_main.entities.Tasks;
import exam_main.entities.User;
import exam_main.utils.Constant;
import exam_main.utils.Untils;
import exam_main.views.LoginMenu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TasksService {
    /*Chức năng nên code trong TasksService
    1. chức năng của sếp
    - phân công nhiệm vụ
    - chỉnh sữa cập nhật nhiệm vụ
    2. chức năng của trưởng phòng
    - Nhận nhiệm cụ từ sếp
    - phân công nhiệm vụ cho nhân viên
    - theo dõi tiến độ công việc từ nhân viên
    3. chức năng của nhân viên
    - nhận nhiệm vụ
    - cập nhật trạng thái
    - báo cáo tiến độ
    - chỉnh sữa hoàn thiện công việc
    */


    // nhập nhiêm vụ
    public void inputTasks(Scanner sc, User user, ArrayList<User> users) {
        do {
            System.out.println("Nhập tên nhiệm vụ");
            String tasksName = sc.nextLine();
            System.out.println("Nhập mô tả nhiệm vụ");
            String description = sc.nextLine();
            System.out.println("Nhập thời hạn hoàn thành");
            LocalDate deadline = Untils.convertStringToDate(sc, "dd/MM/yyyy");
            System.out.println("Nhập trạng thái");
            String status = sc.nextLine();
            Tasks tasks = new Tasks(tasksName, description, deadline, status);
            Database.tasks.add(tasks);
            System.out.println("bạn muốn tiếp tục tạo nhiệm vụ khác không(Y/N)");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("N")){
                LoginMenu loginMenu = new LoginMenu();
                loginMenu.forBoss(sc,user, users );
            }else {
                System.out.println("Tiêp tục");
            }
        }while (true);
    }
    // xem các nhiệm vụ đã tạo
    public void displayTasks(){
        for (Tasks tasks :Database.tasks) {
            System.out.println(tasks);
        }
    }

   // tìm kiếm nhiệm vụ
    public void inputFindTasksByTasksName(Scanner sc){
        System.out.println("Nhập tên nhiệm vụ");
        String name = sc.nextLine();
        Tasks tasks = findTasksByTasksName(name);
        System.out.println(tasks);
    }

    public Tasks findTasksByTasksName(String name){
        // danh sách nhiệm vụ mà sếp tạo ra
        for (Tasks tasks: Database.tasks){
            if (tasks.getTaskName().equals(name)){
                return tasks;
            }
        }
        return null;
    }




    // Sửa nhiệm vụ
    public void editTask(Scanner sc) {
        System.out.println("Nhập tên nhiệm vụ cần sửa: ");
        String taskName = sc.nextLine();
        Tasks task = findTasksByTasksName(taskName);

        if (task != null) {
            System.out.println("Nhập mô tả mới cho nhiệm vụ (hiện tại: " + task.getDescription() + "): ");
            String newDescription = sc.nextLine();
            System.out.println("Nhập thời hạn mới (hiện tại: " + task.getDueDate() + "): ");
            LocalDate newDeadline = Untils.convertStringToDate(sc, "dd/MM/yyyy");
            System.out.println("Nhập trạng thái mới (hiện tại: " + task.getStatus() + "): ");
            String newStatus = sc.nextLine();

            task.setDescription(newDescription);
            task.setDueDate(newDeadline);
            task.setStatus(newStatus);

            System.out.println("Nhiệm vụ '" + taskName + "' đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy nhiệm vụ với tên: " + taskName);
        }
    }

    // Xóa nhiệm vụ
    public void deleteTask(Scanner sc) {
        System.out.println("Nhập tên nhiệm vụ cần xóa: ");
        String taskName = sc.nextLine();
        Tasks task = findTasksByTasksName(taskName);

        if (task != null) {
            Database.tasks.remove(task);
            System.out.println("Nhiệm vụ '" + taskName + "' đã được xóa.");
        } else {
            System.out.println("Không tìm thấy nhiệm vụ với tên: " + taskName);
        }
    }
}
