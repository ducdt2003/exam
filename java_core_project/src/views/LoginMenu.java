package views;

import data.Database;
import entities.Project;
import entities.User;
import entities.Work;
import services.ProjectService;
import services.UserServices;
import services.WorkService;
import utils.Untils;

import javax.imageio.event.IIOWriteWarningListener;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginMenu {


    // thêm digi patter
    ProjectService projectService = ProjectService.getInstance();
    WorkService workService = WorkService.getInstance();

    public void displayMenu(Scanner sc){
        System.out.println("Hãy chọn 1 trong 2");
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        System.out.println("Hãy lựa chọn chức năng");
    }

    public void selectDisplayMenu(Scanner sc, User user, ArrayList<User> users){
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
            default:
                System.out.println("lỗi đang nhập");
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
        System.out.println("1. Quản lý dự án");
        System.out.println("2. Quản lý công việc");
        System.out.println("3. Phân công công việc theo id nhân sự");
        System.out.println("4. Theo dỗi tiến độ");
        System.out.println("5. Quản lý thành viên");
        System.out.println("6. Đánh giá hiệu suất");
        System.out.println("7. Báo cáo kết qủa");
        System.out.println("9. Xem lịch sữ công việc");
        System.out.println("999. Quản lý tài khoản");
        System.out.println("Hãy Chọn chức năng bạn muốn");
    }
//        System.out.println("5. Gửi thông báo công việc");
    // tính năng trong chức năng số 1 của boss (quản lý dự án)

    public void projectManagement(Scanner sc){
        System.out.println("Các Tính năng ");
        System.out.println("1. Thêm mới Dự án");
        System.out.println("2. Tìm kiếm dự án ");
        System.out.println("3. Xóa dự án theo id và tên ");
        System.out.println("4. Thay đổi/chỉnh sữa dự án");
        System.out.println("5. Xem dự án");
        System.out.println("0. Thoát chương trình menu các tính năng của chức năng 1 quản lý dự án");
        System.out.println("Mời bạn lựa chọn");
    }

    public void selectProjectManagement(Scanner sc, User user, ArrayList<User>users){
        do {
            projectManagement(sc);
            int choice = Untils.inputInteger(sc);
            switch (choice){
                case 1:
                    System.out.println("-----Thêm mới dự án-----");
                    projectService.inputProject(sc);
                    break;
                case 2:
                    System.out.println("-----Tìm kiếm dự án -----");
                    System.out.println("1. Tìm kiếm theo id");
                    System.out.println("2. Tìm kiếm tên");
                    System.out.println("Mời Bạn chọn tính năng");
                    int choiceFind = Untils.inputInteger(sc);
                    if (choiceFind == 1){
                        System.out.println("tìm kiếm thoe tên");
                        projectService.displayFindByProjecId(sc);
                    }else if (choiceFind == 2){
                        projectService.findByProjectName(sc);
                    }else if (choiceFind < 1 || choiceFind > 2){
                        System.out.println("Chưa cập nhật chức năng " + choiceFind);
                    }else {
                        System.out.println("Lỗi nhập vào");
                    }
                    break;
                case 3:
                    System.out.println("-----Xóa dự án theo id và tên-----");
                    projectService.remove(sc);
                    break;
                case 4:
                    System.out.println("-----Xóa dự án theo id và tên-----");
                    projectService.edit(sc);
                    break;
                case 5:
                    System.out.println("-----Danh sách dự án-----");
                    projectService.display(sc);
                    break;
                case 0:
                    System.out.println("Đã thoát khỏi menu của tính năng của chức năng số 1 quản lý dự án");
                    forBoss(sc, user, users);
                default:
                    System.out.println("Lỗi Nhập vào");
                    forBoss(sc, user, users);
            }
        }while (true);

    }


    // chức năng số 2
    public void workAssignment(){
        System.out.println("Thông tin các tính năng");
        System.out.println("1. Hiễn thị tất cả dự án");
        System.out.println("2. Thêm công việc cho dự án");
        System.out.println("3. Xóa công việc cho dự án hiện tại ");
        System.out.println("4. Sữa công việc cho dự án hiện tại ");
        System.out.println("5. Xem chi tiết công việc ");
        System.out.println("0. Thoát khỏi chức năng quản lý phân công công việc");
        System.out.println("Mời bạn chọn tính năng");
    }

    public void selectWorkAssignment(Scanner sc,User user, ArrayList<User>users){
        do {
            workAssignment();
            int choice = Untils.inputInteger(sc);
            switch (choice){
                case 1:
                    projectService.display(sc);
//                    selectWorkAssignment(sc, user, users);
                    break;
                case 2:
                    projectService.display(sc);
                    workService.addWorkToProject(sc);
//                    selectWorkAssignment(sc, user, users);
                    break;
                case 3:
                    workService.remove(sc);
//                    selectWorkAssignment(sc, user, users);
                    break;
                case 4:
                    workService.edit(sc);
//                    selectWorkAssignment(sc, user, users);
                    break;
                case 5:
                    workService.display(sc);
//                    selectWorkAssignment(sc, user, users);
                    break;
                case 0:
                    System.out.println("thoát khỏi menu tính năng của chức năng 2 quản lý phân công nhiệm vụ");
                    forBoss(sc,user, users);
                default:
                    System.out.println("Lỗi nhập vào");
                    forBoss(sc,user, users);
            }
        }while (true);

    }


    // chức năng số 9 xem lịch sư
    public void viewHistory(){
        System.out.println("Các tính năng");
        System.out.println("1. Xem lịch sữ tạo dự án");
        System.out.println("2. Xem lịch sữ tạo công việc");
        System.out.println("3. xem lịch sữ phân công công việc");
        System.out.println("0. Thoát tính năng xẻm lịch sữ");
        System.out.println(" lưu ai là người tác động , lưu thông tin của dự án nào , nội dung commen mô tả");
        System.out.println("Mời bạn chọn");
    }
    public void selectViewHistory(Scanner sc, User user, ArrayList<User> users){
        do {
            viewHistory();
            int choice = Untils.inputInteger(sc);
            switch (choice){
                case 1:
                    System.out.println("Các dự án đã tạo");
                    projectService.display(sc);
                    System.out.println("Thông thông tin chi tiết dự án bạn muốn xem");
                    projectService.findBy(sc);
                    break;
                case 2:
                    System.out.println("Các công việc đã tạo");
                    workService.display(sc);
                    break;
                case 3:
                    System.out.println("Nhập ID dự án để xem lịch sử phân công:");
                    int projectId = Untils.inputInteger(sc);
                    workService.viewAssignmentHistory(projectId);
                    break;
                case 0:
                    System.out.println("Đã thoát khỏi tính năng xem lịch sữ");
                    forBoss(sc, user, users);
                default:
                    System.out.println("Lỗi nhập vào");
                    forBoss(sc, user, users);
            }
        }while (true);

    }


    // menu chức năng số 5 quản lý thành viên
    public void managerStaff(){
        System.out.println("Tính Năng Chính quản lý thành viên");
        System.out.println("1. Thay đổi chức vụ");
        System.out.println("2. Xem thành viên");
        System.out.println("0. thoát chức năng quản lý thành viên");
        System.out.println("Hãy chọn tính năng");
    }
    public void selectManagerStaff(Scanner sc,User user, ArrayList<User> users){
        do {
            managerStaff();
            int choice = Untils.inputInteger(sc);
            switch (choice){
                case 1:
                    UserServices userServices = new UserServices();
                    userServices.displayRegisters(users);
                    System.out.println("chọn tính năng bạn muốn");
                    System.out.println("1.Từ nhân viên lên trưởng phòng");
                    System.out.println("2.Từ trưởng phòng xuống nhân viên");
                    int choice1 = Untils.inputInteger(sc);
                    if (choice1 == 1){
                        workService.appointManagerById(sc, users);
                    } else if ( choice1 == 2) {
                        workService.demoteManagerById(sc, users);
                    }
                    break;
                case 2:
                    workService.displayStaffAndManagers(users);
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

   /* // chức năng số 2 của boss phân công nhiệm vụ
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
    }*/








    public void forBoss(Scanner sc,  User user, ArrayList<User> users){
        do {
            diplayMenuBoss();
            int choice = Untils.inputInteger(sc);
            switch (choice){
                case 1:
                    selectProjectManagement(sc, user, users);
                    break;
                case 2:
                    selectWorkAssignment(sc, user, users);
                    break;
                case 3:
                    workService.assignByUserId(sc,user,users);
                    break;
                case 4:
                    break;
                case 5:
                    selectManagerStaff(sc, user, users);
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 9:
                    selectViewHistory(sc, user, users);
                    break;
                case 999:
                    selectLoginMenu(sc,user, users);
                default:
                    System.out.println("Chức năng bạn nhập chưa được cập nhật hãy chọn chức năng khác!");
            }
        }while (true);
    }


    // menu của manage
    public void diplayMenuManage(){
        System.out.println("Chức năng của Manage");
        System.out.println("1. Công việc của tôi");
        System.out.println("2. Quản lý nhiệm vụ");
        System.out.println("3. Phân công nhiệm vụ");
        System.out.println("4. Xem thông báo từ xếp");
        System.out.println("5. Gửi thông báo nhắc nhở");
        System.out.println("6. Đánh giá hiệu suất của nhân viên");
        System.out.println("7. Báo cáo tiến độ cho sếp(BOSS)");
        System.out.println("8. Xem lịch sữ công việc");
        System.out.println("0. Thoát Chương Trình Ngay");
        System.out.println("999. Quản lý tài khoản");
        System.out.println("Hãy Chọn chức năng bạn muốn");
    }



    public void forManage(Scanner sc, User user, ArrayList<User> users){
        Work work = new Work();
        do {
            diplayMenuManage();
            int choice = Untils.inputInteger(sc);
            switch (choice){
                case 1:
                    // công việc của tôi
                   workService.viewAssignedWorksByUserId(sc, user);

                    break;
                case 2:
                    // quản lý nhiệm vụ
                    break;
                case 3:
                    // phân công nhiệm vụ
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    // xem lịch sữ công việc
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                case 999:
                    selectLoginMenu(sc,user, users);
                default:
                    System.out.println("Chức năng bạn nhập chưa được cập nhật hãy chọn chức năng khác!");
            }
        }while (true);
    }







// Nhập menu của staff
    public void displayMenuStaff(){
        System.out.println("chức năng của Staff");
        System.out.println("1. Công viec của tôi ");
        System.out.println("2. Cập Nhật Trạng Thái");
        System.out.println("3. Báo Cáo kết quả");
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
                    workService.viewAssignedWorksByUserId(sc, user);
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
