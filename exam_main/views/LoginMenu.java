package exam_main.views;

import exam_main.entities.Boss;
import exam_main.entities.Manage;
import exam_main.entities.Tasks;
import exam_main.entities.User;
import exam_main.services.BossService;
import exam_main.services.TasksService;
import exam_main.services.UserServices;
import exam_main.utils.Untils;


import java.util.ArrayList;
import java.util.Scanner;

public class LoginMenu {
    public void displayMenu(Scanner sc){
        System.out.println("Hãy chọn 1 trong 2");
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        System.out.println("Hãy lựa chọn chức năng");
    }

    public void selectDisplayMenu(Scanner sc,User user, ArrayList<User> users){
        displayMenu(sc);
        int choice = Untils.inputInteger(sc);
        UserServices userRegisterServices = new UserServices();
        switch (choice){
            case 1:
                userRegisterServices.checkLogin(sc, user,users);
                break;
            case 2:
                userRegisterServices.initializeBossAccount(users);
                user = userRegisterServices.inputRegister(sc, users);
                userRegisterServices.displayRegisters(users);
                userRegisterServices.checkLogin(sc, user, users);
        }
    }


    // khi đăng nhập sai mật khẩu
    public void inputpasswordMenu(Scanner sc){
        System.out.println("---Sai Mật Khẩu---");
        System.out.println("1. đăng nhập lại ");
        System.out.println("2. quên mật khẩu");
        System.out.println("0. thoát! sau nhớ nhập lại nak");
        System.out.println(" hãy chọn cái bạn muốn ");

    }
    public void selectPassWordMenu(Scanner sc, User user, ArrayList<User> users){
        inputpasswordMenu(sc);
        int choice = Untils.inputInteger(sc);
        UserServices userRegisterServices = new UserServices();
        switch (choice){
            case 1:
                userRegisterServices.checkLogin(sc, user, users);
                break;
            case 2:
                userRegisterServices.forgotPassword(sc, users);
                break;
            case 0:
                System.out.println("Thoát chương trình!");
                System.exit(0);
            default:
                System.out.println("--------------");
        }
    }



    // khi đăng nhập thành công chức năng quản lý tài khoản
    public void loginMenu(){
        System.out.println("---Quản lý tài khoản---");
        System.out.println("111 - Thay đổi username");
        System.out.println("222 - Thay đổi email");
        System.out.println("333 - Thay đổi mật khẩu");
        System.out.println("444 - Đăng xuất");
        System.out.print("Lựa chọn của bạn: ");
    }

    public void selectLoginMenu(Scanner sc,  User user, ArrayList<User> users){
        loginMenu();
        int choice = Untils.inputInteger(sc);
        UserServices userRegisterServices = new UserServices();
        switch (choice){
            case 111:
                userRegisterServices.changeUserName(sc,user, users);
                selectDisplayMenu(sc, user,users);
                break;
            case 222:
                userRegisterServices.changeEmail(sc,user, users);
                selectDisplayMenu(sc, user,users);
                break;
            case 333:
                userRegisterServices.changePassWord(sc,user);
                selectDisplayMenu(sc,user, users);
                break;
            case 444:
                System.out.println("---Đăng xuất thành công---");
                selectDisplayMenu(sc,user, users);
                break;
            default:
                System.out.println("Lỗi hệ thống");
        }
    }

    // menu của boss
    public void diplayMenuBoss(){
        System.out.println("Chức năng của BOSS");
        System.out.println("1. Tạo dự án");
        System.out.println("2. Quản lý nhiệm vụ");
        System.out.println("3. Theo dõi tiến độ công việc");
        System.out.println("4. Gửi thông báo công việc");
        System.out.println("5. Quản lý thành viên");
        System.out.println("6. Đánh giá hiệu suất");
        System.out.println("7. Báo cáo kết qủa");
        System.out.println("8. Xem lịch sữ công việc");
        System.out.println("9. Xem dự án");
        System.out.println("0. Thoát ngay chương trình");
        System.out.println("999. Quản lý tài khoản");
        System.out.println("Hãy Chọn chức năng bạn muốn");
    }

    // menu chức năng số 5 quản lý thành viên
    public void managerStaff(){
        System.out.println("Tính Năng Chính quản lý thành viên");
        System.out.println("1. Thay đổi chức vụ");
        System.out.println("2. Xem Nhân Sự");
        System.out.println("0. thoát chức năng quản lý thành viên");
        System.out.println("Hãy chọn tính năng");
    }
    public void selectManagerStaff(Scanner sc,User user, ArrayList<User> users){
        do {
            BossService bossService  = new BossService();
            managerStaff();
            int choice = Untils.inputInteger(sc);
            switch (choice){
                case 1:
                    System.out.println("chọn tính năng bạn muốn");
                    System.out.println("1.Từ nhân viên lên trưởng phòng");
                    System.out.println("2.Từ trưởng phòng xuống nhân viên");
                    int choice1 = Untils.inputInteger(sc);
                    if (choice1 == 1){
                        bossService.appointManager(sc,users );
                    } else if ( choice1 == 2) {
                        bossService.appointStaff(sc,users);
                    }
                    break;
                case 2:
                    bossService.displayStaffAndManagers(users);
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    forBoss(sc,user, users);
                default:
                    System.out.println("lỗi đăng nhập");
                    break;
            }
        }while (true);
    }

    // chức năng số 2 của boss phân công nhiệm vụ
    public void displayTasksAssignment(){
        System.out.println("Chọn chức tính năng bạn muốn");
        System.out.println("1. Tạo Nhiệm Vụ cho Dự án");
        System.out.println("2. Phân công nhiệm vụ ");
        System.out.println("3. Sữa nhiệm vụ");
        System.out.println("4. Xóa nhiệm vụ");
        System.out.println("5. Xem Nhiệm Vụ");
        System.out.println("6. Tìm kiếm nhiệm vụ");
        System.out.println("0. Thoát khỏi tính năng quản lý nhiệm vụ");
    }
    public void selectTasksAssignment(Scanner sc, User user, ArrayList<User> users){
        displayTasksAssignment();
        int choice = Untils.inputInteger(sc);
        TasksService tasksService = new TasksService();
        switch (choice){
            case 1:
                tasksService.inputTasks(sc, user,users);
                break;
            case 2:
                System.out.println("1.Xem danh sách Trưởng phòng và nhân viên ");
                System.out.println("2.Tìm kiếm Trưởng phòng");
                System.out.println("3.Gán nhiệm vụ cho trưởng phòng");
                System.out.println("0.Thoát khỏi tính năng phân công nhiệm vụ");
                int chioce = Untils.inputInteger(sc);
                BossService bossService = new BossService();
                if (chioce == 1){
                    bossService.displayStaffAndManagers(users);
                } else if (chioce == 2) {

                } else if (chioce == 3) {

                }else if (chioce == 0){
                    displayTasksAssignment();
                }else {
                    System.out.println("lỗi nhập vào");
                    break;
                }

                // hàm phân công
                break;
            case 3:
                tasksService.editTask(sc);
                break;
            case 4:
                tasksService.deleteTask(sc);
                break;
            case 5:
                tasksService.displayTasks();
                break;
            case 6:
                tasksService.inputFindTasksByTasksName(sc);
                break;
            case 0:
                System.out.println("thoát chương trình");
                forBoss(sc,user, users);
        }
    }


    public void forBoss(Scanner sc,  User user, ArrayList<User> users){
        BossService bossService = new BossService();
        do {
            diplayMenuBoss();
            int choice = Untils.inputInteger(sc);
            switch (choice){
                case 1:
                    bossService.addProject(sc);
                    break;
                case 2:
                    selectTasksAssignment(sc, user, users);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    selectManagerStaff(sc,user, users);
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    bossService.displayProject();
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                case 999:
                    selectLoginMenu(sc,user, users );
                default:
                    System.out.println("Chức năng bạn nhập chưa được cập nhật hãy chọn chức năng khác!");
            }
        }while (true);
    }


    // menu của manage
    public void diplayMenuManage(){
        System.out.println("Chức năng của Manage");
        System.out.println("1. Nhận Nhiệm vụ từ sếp(BOSS)");
        System.out.println("2. Phân Công Nhiệm Vụ cho Nhận viên");
        System.out.println("3. Theo dõi Tiến độ của nhân viên");
        System.out.println("4. Gửi thông báo nhắc nhở");
        System.out.println("5. Đánh giá hiệu suất của nhân viên");
        System.out.println("6. Báo cáo tiến độ cho sếp(BOSS)");
        System.out.println("7. Xem lịch sữ công việc");
        System.out.println("0. Thoát Chương Trình Ngay");
        System.out.println("999. Quản lý tài khoản");
        System.out.println("Hãy Chọn chức năng bạn muốn");
    }


    public void forManage(Scanner sc, User user, ArrayList<User> users){
        do {
            diplayMenuManage();
            int choice = Untils.inputInteger(sc);
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                case 999:
                    selectLoginMenu(sc,user, users );
                default:
                    System.out.println("Chức năng bạn nhập chưa được cập nhật hãy chọn chức năng khác!");
            }
        }while (true);
    }

// Nhập menu của staff
    public void displayMenuStaff(){
        System.out.println("chức năng của Staff");
        System.out.println("1. Nhận Nhiệm vụ");
        System.out.println("2. Cập Nhật Trạng Thái");
        System.out.println("3. Báo Cáo tiến độ");
        System.out.println("4. Gửi Yêu Cầu trợ giúp");
        System.out.println("5. Chĩnh Sữa Hoàn thiện công việc");
        System.out.println("6. Xem Lịch sữ công việc");
        System.out.println("0. thoát chương trình ngay");
        System.out.println("999. Quản lý tài khoản");
        System.out.println("Hãy Chọn chức năng bạn muốn");
    }
    public void forStaff(Scanner sc, User user, ArrayList<User> users){
        do {
            displayMenuStaff();
            int choice = Untils.inputInteger(sc);
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                case 999:
                    selectLoginMenu(sc,user, users );
                default:
                    System.out.println("Chức năng bạn nhập chưa được cập nhật hãy chọn chức năng khác!");
            }
        }while (true);
    }

}
