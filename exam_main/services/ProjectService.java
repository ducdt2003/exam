package exam_main.services;

import exam_main.data.Database;
import exam_main.entities.Project;
import exam_main.utils.Untils;

import java.time.LocalDate;
import java.util.Scanner;

public class ProjectService {
    /*Chức năng nên code trong ProjectService
    1. chức năng của sếp:
    - Tạo dự án
    - theo dõi tiến độ công việc
    - báo cáo kết quả
    2. chức năng của trưởng phòng
    - báo cáo tiến độ cho sếp
    */

    public Project createProject(Scanner sc) {
       Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên dự án: ");
        String projectName = scanner.nextLine();
        System.out.print("Nhập mô tả dự án: ");
        String projectDescribe = scanner.nextLine();
        System.out.println("Nhập Ngày Bắt Đầu Dự Án");
        LocalDate startDate = Untils.convertStringToDate(sc, "dd/MM/yyyy");
        System.out.println("Nhập Ngày Kết Thúc Dự Án");
        LocalDate endDate = Untils.convertStringToDate(sc, "dd/MM/yyyy");
        Project project = new Project(projectName, projectDescribe, startDate, endDate);
        Database.projects.add(project);
        System.out.println("Dự án " + projectName + " đã được tạo thành công!");
        return project;
    }

    public Project findbyName(String name){
        for (Project project: Database.projects) {
            if (project.getProjectName() == name){
                return project;
            }
        }
        return null;
    }
}


/*
    // Sửa dự án
    public void editProject(Scanner sc) {
        System.out.print("Nhập tên dự án cần sửa: ");
        String projectName = sc.nextLine();
        Project project = findByName(projectName);

        if (project != null) {
            System.out.println("Nhập mô tả mới cho dự án (hiện tại: " + project.getProjectDescription() + "): ");
            String newDescription = sc.nextLine();
            System.out.println("Nhập ngày bắt đầu mới (hiện tại: " + project.getStartDate() + "): ");
            LocalDate newStartDate = Untils.convertStringToDate(sc, "dd/MM/yyyy");
            System.out.println("Nhập ngày kết thúc mới (hiện tại: " + project.getEndDate() + "): ");
            LocalDate newEndDate = Untils.convertStringToDate(sc, "dd/MM/yyyy");

            project.setProjectDescription(newDescription);
            project.setStartDate(newStartDate);
            project.setEndDate(newEndDate);

            System.out.println("Dự án '" + projectName + "' đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy dự án với tên: " + projectName);
        }
    }

    // Xóa dự án
    public void deleteProject(Scanner sc) {
        System.out.print("Nhập tên dự án cần xóa: ");
        String projectName = sc.nextLine();
        Project project = findByName(projectName);

        if (project != null) {
            Database.projects.remove(project);
            System.out.println("Dự án '" + projectName + "' đã được xóa.");
        } else {
            System.out.println("Không tìm thấy dự án với tên: " + projectName);
        }
    }
}*/
