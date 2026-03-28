import java.util.ArrayList;

public class Customer {
    private String nama, email, noHp;
    private boolean isMember;
    private ArrayList<String> history;

    public Customer(String nama, String email, String noHp, boolean isMember, ArrayList<String> history) {
        this.nama = nama;
        this.email = email;
        this.noHp = noHp;
        this.isMember = isMember;
        this.history = history;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getNoHp() {
        return noHp;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public double getDiskon() {
        if (isMember) {
            return 0.15;
        }
        return 0;
    }

    public String getStatus() {
        if (isMember) {
            return "(MEMBER)";
        }
        return "(NON MEMBER)";
    }

    public void tambahHistory(String data) {
        if (isMember) {
            history.add(data);
        }
    }

    public void cetakHistory() {
        if (isMember) {
            System.out.println("\nHistory Pemesanan:");
            for (String h : history) {
                System.out.println(h);
            }
        }
    }
}
