
package service;
import entities.LogIn;
import entities.Register;
import utils.AccountManager;
import view.LoginMenu;


import java.util.ArrayList;
import java.util.Scanner;

public class LogInService {
    private static String userName;
    private static String passWord;

    public LogIn inputLogin(Scanner sc, ArrayList<Register> registers){
            System.out.println("Nhập tài khoản của bạn ");
            userName = sc.nextLine();
            System.out.println("Nhập mật khẩu của bạn ");
            passWord = sc.nextLine();
            checkLogin(sc, registers);
            return new LogIn(userName, passWord);
    }

    public void checkLogin(Scanner sc, ArrayList<Register> registers){
        do {
            if (userName.equals(AccountManager.getUSERNAME()) && passWord.equals(AccountManager.getPASSWORD())){
                System.out.println("Chào mừng --> " + AccountManager.getUSERNAME() + " <-- đã đăng nhập thành công");
                LoginMenu loginMenu = new LoginMenu();
                loginMenu.selectLoginMenu(sc, registers);
                break;
            }else if (!userName.equals(AccountManager.getUSERNAME())){
                System.out.println("Kiểm tra lại username! hãy nhập lại ");
                inputLogin(sc, registers);
            } else {
                LoginMenu loginMenu = new LoginMenu();
                loginMenu.selectPassWordMenu(sc, registers);
            }
        }while (true);
    }

    public void forgotPassword(Scanner sc, ArrayList<Register> registers) {
        do {
            System.out.print("Nhập email đã liên kết với tài khoản: ");
            String email = sc.nextLine();
            if (email.equals(AccountManager.getEMAIL())) {
                System.out.print("Email chính xác! Mời bạn nhập mật khẩu mới: ");
                passWord = sc.nextLine();
                AccountManager.PASSWORD = passWord;
                System.out.println("Mật khẩu đã được cập nhật. Vui lòng đăng nhập lại.");
                inputLogin(sc, registers);
                checkLogin(sc, registers);
                break;
            } else {
                System.out.println("Email chưa được liên kết với tài khoản nào! Vui lòng thử lại.");
            }
        } while (true);
    }


    public void changeUserName(Scanner sc){
        do {
            System.out.print("Nhập Tài khoản cũ: ");
            String name = sc.nextLine();
            if (name.equals(AccountManager.getUSERNAME())){
                System.out.print("Nhập tài khoản mới");
                String name1 = sc.nextLine();
                AccountManager.USERNAME = name1;
                System.out.println("Tài Khoản đã được đổi thành công");
                break;
            }else {
                System.out.println("Tài khoản này chưa tồn tại từ trước! Hãy nhập đúng tài khoản ban đầu");
            }
        }while (true);
    }

    public void changeEmail(Scanner sc){
        do {
            System.out.print("Nhập Email cũ: ");
            String email = sc.nextLine();
            if (email.equals(AccountManager.getEMAIL())){
                System.out.print("Nhập Email mới");
                String email1 = sc.nextLine();
                AccountManager.EMAIL = email1;
                System.out.println("Email đã được đổi thành công");
                break;
            }else {
                System.out.println("Email này chưa tồn tại từ trước! Hãy nhập đúng Email bạn đầu ");
            }
        }while (true);
    }
    public void changePassWord(Scanner sc){
        do {
            System.out.print("Nhập mật khẩu cũ: ");
            String pass = sc.nextLine();
            if (pass.equals(AccountManager.getPASSWORD())){
                System.out.print("Nhập mật khẩu mới");
                String passWord = sc.nextLine();
                AccountManager.PASSWORD = passWord;
                System.out.println("Mật khẩu đã được đổi thành công");
                break;
            }else {
                System.out.println("Mật khẩu này chưa tồn tại từ trước! Hãy nhập đúng password bạn đầu");
            }
        }while (true);
    }
}

