import java.math.BigDecimal;

import ProjectException.*;

public class TerminalImpl implements Terminal {
    private final PinValidator pinValidator;
    private final TerminalServer terminalServer;
    private final Integer multiplicitySums;

    public TerminalImpl(PinValidator pinValidator, TerminalServer terminalServer, Integer multiplicitySums) {
        this.pinValidator = pinValidator;
        this.terminalServer = terminalServer;
        this.multiplicitySums = multiplicitySums;
    }

    public boolean login(int pin) throws PinValidatorException {
        return pinValidator.login(pin);

    }

    public boolean unlogin(){
        return pinValidator.unlogin();
    }
    public Integer getBalance() throws InvalidAccessTerminalException {
        if (!pinValidator.isLogin()) throw new InvalidAccessTerminalException("Terminal is not authorized");
        return terminalServer.getBalance();
    }

    public boolean putMoney(Integer amount) throws TerminalException {
        if (!pinValidator.isLogin()) throw new InvalidAccessTerminalException("Terminal is not authorized");
        if(!checkMultiplicity(amount))throw new WrongAmountException("Invalid amount, amount must be a multiple of:"+multiplicitySums);
        if(terminalServer.putMoney(amount)) return true;
        throw new TerminalException("Unknown error");
    }

    public boolean getMoney(Integer amount) throws TerminalException, InsufficientFundsException {
        if (!pinValidator.isLogin()) throw new InvalidAccessTerminalException("Terminal is not authorized");
        if(!checkMultiplicity(amount)) throw new WrongAmountException("Invalid amount, amount must be a multiple of:"+multiplicitySums);
        if(terminalServer.getMoney(amount)) return true;
        throw new TerminalException("Unknown error");
      }

    private boolean checkMultiplicity(Integer count){
        if(count%multiplicitySums==0)return true;
        else return false;
    }
}
