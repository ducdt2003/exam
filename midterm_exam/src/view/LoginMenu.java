package view;

import entities.LogIn;
import entities.Register;
import service.LogInService;
import service.RegisterService;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginMenu {
    public void displayMenu(Scanner sc){
        System.out.println("Hãy chọn 1 trong 2");
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        System.out.println("Hãy lựa chọn chức năng");
    }

    public void selectDisplayMenu(Scanner sc,ArrayList<Register> registers){
        displayMenu(sc);
        int choice = Integer.parseInt(sc.nextLine());
        LogInService logInService = new LogInService();
        switch (choice){
            case 1:
                logInService.inputLogin(sc, registers);
                break;
            case 2:
                    RegisterService registerService = new RegisterService();
                    ArrayList<Register> register = registerService.innputRegister(sc, registers);
                    System.out.println(register);
                    registerService.displayRegisters(registers);
                    registerService.login(sc,registers);
            default:
                System.out.println("Lỗi đăng nhập");
        }
    }


    public void inputpasswordMenu(Scanner sc){
        System.out.println("---Sai Mật Khẩu Rồi---");
        System.out.println("1. đăng nhập lại ");
        System.out.println("2. quên mật khẩu");
        System.out.println("0. thoát! sau nhớ nhập lại nak");
        System.out.println(" hãy chọn cái bạn muốn ");

    }
    public void selectPassWordMenu(Scanner sc, ArrayList<Register> registers){
        inputpasswordMenu(sc);
        int choice = Integer.parseInt(sc.nextLine());
        LogInService logInService = new LogInService();
        switch (choice){
            case 1:
                logInService.inputLogin(sc, registers);
                break;
            case 2:
                logInService.forgotPassword(sc, registers);
                break;
            case 0:
                System.out.println("Thoát chương trình!");
                System.exit(0);
            default:
                System.out.println("Lỗi đăng nhập");
        }
    }

    public void loginMenu(){
        System.out.println("---Bạn Muốn Làm Gì Tiếp Theo---");
        System.out.println("1 - Thay đổi username");
        System.out.println("2 - Thay đổi email");
        System.out.println("3 - Thay đổi mật khẩu");
        System.out.println("4 - Đăng xuất");
        System.out.println("0 - Thoát chương trình");
        System.out.print("Lựa chọn của bạn: ");
    }
    public void selectLoginMenu(Scanner sc, ArrayList<Register> registers){
        loginMenu();
        int choice = Integer.parseInt(sc.nextLine());
        LogInService logInService = new LogInService();
        switch (choice){
            case 1:
                logInService.changeUserName(sc);
                selectDisplayMenu(sc, registers);
                break;
            case 2:
                logInService.changeEmail(sc);
                selectDisplayMenu(sc, registers);
                break;
            case 3:
                logInService.changePassWord(sc);
                selectDisplayMenu(sc, registers);
                break;
            case 4:
                System.out.println("---Đăng xuất thành công---");
                selectDisplayMenu(sc, registers);
                break;
            case 0:
                System.out.println("---Thoát chương trình thành công!---");
                System.exit(0);
                break;
            default:
                System.out.println("Lỗi hệ thống");
        }
    }



    public void selectRegister(Scanner sc, ArrayList<Register> registers){
        loginMenu();
        int choice = Integer.parseInt(sc.nextLine());
        RegisterService registerService = new RegisterService();
        switch (choice){
            case 1:
                registerService.switchAccount(sc, registers);
                selectLoginMenu(sc, registers);
                break;
            case 2:
                registerService.switchEmail(sc, registers);
                selectLoginMenu(sc, registers);
                break;
            case 3:
                registerService.switchPassWord(sc, registers);
                selectLoginMenu(sc, registers);
                break;
            case 4:
                System.out.println("---Đăng xuất thành công---");
                selectDisplayMenu(sc, registers);
                break;
            case 0:
                System.out.println("---Thoát Chương Trình");
                System.exit(0);
                break;
            default:
                System.out.println("lỗi hệ thống");
        }
    }
}
