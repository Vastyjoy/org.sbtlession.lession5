import ProjectException.InsufficientFundsException;


public class TerminalServer {
    private final Account account;

    public TerminalServer(Account account) {
        this.account = account;
    }

    public Integer getBalance(){
        return account.getBalance();
    }

    public boolean putMoney(Integer amount)  {
        account.setBalance(account.getBalance()+amount);
        return true;
    }

    public boolean getMoney(Integer amount) throws InsufficientFundsException {
        if(account.getBalance()<amount)throw  new InsufficientFundsException("There is not enough money in the account");
        else account.setBalance(account.getBalance()-amount);
        return true;
    }
}
