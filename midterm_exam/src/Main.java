import entities.Register;
import service.RegisterService;
import view.LoginMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Register> registers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.selectDisplayMenu(sc, registers);
    }
}
