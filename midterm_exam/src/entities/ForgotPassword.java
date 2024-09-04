package entities;

public class ForgotPassword {
    private String gmail;

    public ForgotPassword() {
    }

    public ForgotPassword(String gmail) {
        this.gmail = gmail;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    @Override
    public String toString() {
        return "ForgotPassword{" +
                "gmail='" + gmail + '\'' +
                '}';
    }
}
