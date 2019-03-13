import ProjectException.*;

import java.math.BigDecimal;

public interface Terminal {
    public Integer getBalance() throws InvalidAccessTerminalException;
    public boolean putMoney(Integer count) throws TerminalException, TerminalServerException;
    public boolean getMoney(Integer count) throws TerminalException, InsufficientFundsException;

}
