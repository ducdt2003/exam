package services;

import java.util.Scanner;

public interface IAddDeleteUpdate {
    void findBy(Scanner sc);
    void remove(Scanner sc);
    void edit(Scanner sc);
    void display(Scanner sc);
}
