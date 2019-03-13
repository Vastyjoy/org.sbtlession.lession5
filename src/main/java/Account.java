import java.util.Date;

public class Account {

    private final String id;
    private  int balance;

    public Account(String id){
        this.id=id;
        balance=0;
    }

    public String getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
