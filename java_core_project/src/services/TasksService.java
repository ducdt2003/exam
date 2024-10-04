package services;

import entities.Tasks;
import utils.Untils;

import java.time.LocalDate;
import java.util.Scanner;

public class TasksService {
    private static TasksService tasksService;
    public static synchronized TasksService getInstance(){
        if (tasksService == null){
            tasksService = new TasksService();
        }
        return tasksService;
    }

    public Tasks inputTasks(Scanner sc){
        System.out.println("Nhập tên nhiệm vụ");
        String taskName = sc.nextLine();
        System.out.println("Nhập mô tả nhiệm vụ");
        String taskDescription = sc.nextLine();
        System.out.println("Nhập thời gian tạo nhiệm vụ");
        LocalDate addDate = Untils.convertStringToDate(sc, "dd/MM/yyyy");
        System.out.println("Nhập thời gian bắt đầu làm nhiệm vụ");
        LocalDate startDate = Untils.convertStringToDate(sc,"dd/MM/yyyy");
        System.out.println("Nhập thời gian kết thúc nhiệm vụ");
        LocalDate endDate = Untils.convertStringToDate(sc,"dd/MM/yyyy");
        System.out.println("Nhập thái thái");
        String status = sc.nextLine();
        return new Tasks(taskName, taskDescription, addDate, startDate, endDate, status);
    }
}
