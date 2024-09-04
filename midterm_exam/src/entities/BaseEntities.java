package entities;

import java.util.ArrayList;

public class BaseEntities {
    private ArrayList<LogIn> logIns;
    private ArrayList<Register> registers;

    public BaseEntities() {
        logIns = new ArrayList<>();
        registers = new ArrayList<>();
    }

    public void addLogIn(LogIn logIn) {
        logIns.add(logIn);
    }

    public ArrayList<LogIn> getLogIns() {
        return logIns;
    }

    public void addRegister(Register register) {
        registers.add(register);
    }

    public ArrayList<Register> getRegisters() {
        return registers;
    }
}
