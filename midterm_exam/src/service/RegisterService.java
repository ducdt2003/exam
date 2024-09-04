    package service;

    import entities.Register;
    import utils.AccountManager;
    import view.LoginMenu;

    import java.util.ArrayList;
    import java.util.Scanner;
    import java.util.regex.Pattern;

    public class RegisterService {
       private static String userName;
        private static String passWord;
        private static String email;
       /* public Register innputRegister(Scanner sc , ArrayList<Register> registers){
                System.out.println("---Tạo Tài Khoản---");
                System.out.print("Nhập userName: ");
                inputUserName(sc);
                System.out.print("Nhập email: ");
                inputEmail(sc);
                System.out.print("Nhập passWord: ");
                inputPassWord(sc);
                Register register = new Register(userName, passWord, email);
                registers.add(register);
                return register;
        }*/

        public ArrayList<Register> innputRegister(Scanner sc, ArrayList<Register> registers) {
               System.out.println("---Tạo Tài Khoản---");
               System.out.print("Nhập userName: ");
               inputUserName(sc);
               System.out.print("Nhập email: ");
               inputEmail(sc);
               System.out.print("Nhập passWord: ");
               inputPassWord(sc);
               Register register = new Register(userName, passWord, email);
               registers.add(register);
               AccountManager.setUSERNAME(userName);
               AccountManager.setEMAIL(email);
               AccountManager.setPASSWORD(passWord);
               return registers;
        }
        public void inputUserName(Scanner sc){
            do {
                userName = sc.nextLine();
                if(userName.equals(AccountManager.getUSERNAME())){
                    System.out.print("Tài khoản đã tồn tại! Hãy chọn tên tài khoản khác");
                    System.out.print("\nNhập userName:");
                }else {
                    System.out.println("Tài khoản hợp lệ! Tiếp Tục Nhập Email");
                    break;
                }
            }while (true);
        }

        public void inputEmail(Scanner sc){
            Pattern pattern = Pattern.compile("^[a-z0-9]+@[a-z]{5}.[a-z]{3}$");
            do {
                email = sc.nextLine();
                if (pattern.matcher(email).find()){
                    if (email.equals(AccountManager.getEMAIL())){
                        System.out.println("Email này đã được đăng ký từ trước rồi! Nhập email khác");
                        System.out.print("Nhập email: ");
                    }else {
                        System.out.println("Email Hợp Lệ! Tiếp Tục Nhập PassWord");
                        break;
                    }
                }else {
                    System.out.println("Lỗi khi đặt tên email");
                    System.out.print("Nhập lại email đúng quy tắc (---@gmail.com): ");
                }

            }while (true);
        }

        public void inputPassWord(Scanner sc){
            Pattern pattern = Pattern.compile("^(.*[A-Z])([a-z0-9]){7,15}$");
            do {
                passWord = sc.nextLine();
                if(pattern.matcher(passWord).find()){
                    System.out.println("Đăng ký hoàn tất");
                    break;
                }else {
                    System.out.print("Mật khẩu phải từ 7 đến 15 ký tự và chữ cái đầu tiền viết hoa");
                    System.out.println("\nNhập Lại: ");
                }
            }while (true);
        }
        public void displayRegisters(ArrayList<Register> registers) {
            System.out.println("Danh sách tài khoản đã đăng ký:");
            for (Register register : registers) {
                System.out.println("Username: " + register.getUsername() + ", Email: " + register.getEmail());
            }
        }

      public boolean login(Scanner sc, ArrayList<Register> registers) {
          do {
              System.out.println("---Đăng Nhập---");
              System.out.print("Nhập userName: ");
              String inputUserName = sc.nextLine();
              System.out.print("Nhập passWord: ");
              String inputPassword = sc.nextLine();
              for (Register register : registers) {
                  if (register.getUsername().equals(inputUserName) && register.getPassWord().equals(inputPassword)) {
                      System.out.println("Chào mừng--> " + inputUserName + "<-- Đã đăng nhập thành công");
                      LoginMenu loginMenu = new LoginMenu();
                      loginMenu.selectRegister(sc, registers);
                      return true;
                  }
              }
              System.out.println("Tên đăng nhập hoặc mật khẩu không đúng!");
          } while (true);
      }

        public void switchAccount(Scanner sc, ArrayList<Register> registers) {
            do {
                System.out.print("Nhập tên tài khoản cũ: ");
                String oldUserName = sc.nextLine();
                    if (userName.equals(oldUserName)) {
                        System.out.print("Nhập tên tài khoản mới: ");
                        String newUserName = sc.nextLine();
                        for ( Register register : registers) {
                            register.setUsername(newUserName);
                        }
                        System.out.println("Tài khoản đã được đổi thành công.");
                        break;
                    }
                System.out.println("Tài khoản cũ không tồn tại.");
            }while (true);
        }

        public void switchEmail(Scanner sc, ArrayList<Register> registers) {
            do {
                System.out.print("Nhập Email cũ: ");
                String oldEmail = sc.nextLine();
                if (email.equals(oldEmail)) {
                    System.out.print("Nhập Email mới: ");
                    String newEmail = sc.nextLine();
                    for ( Register register : registers) {
                        register.setEmail(newEmail);
                    }
                    System.out.println("Email đã được đổi thành công.");
                    break;
                }
                System.out.println("Email cũ không tồn tại.");
            }while (true);
        }
        public void switchPassWord(Scanner sc, ArrayList<Register> registers) {
            do {
                System.out.print("Nhập Mật khẩu cũ: ");
                String oldPassWord = sc.nextLine();
                if (passWord.equals(oldPassWord)) {
                    System.out.print("Nhập Mật Khẩu mới: ");
                    String newPassWord = sc.nextLine();
                    for ( Register register : registers) {
                        register.setPassWord(newPassWord);
                    }
                    System.out.println("Mật khẩu đã đổi thành công.");
                    break;
                }
                System.out.println("Mật khẩu cũ không tồn tại.");
            }while (true);
        }
    }
