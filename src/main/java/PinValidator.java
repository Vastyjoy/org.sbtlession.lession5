import java.time.LocalDateTime;

import ProjectException.*;

public class PinValidator {
    int pin;
    boolean login;
    private boolean lock;

    /**
     * Время нахождения в блокировке
     */
    private final long lockTime;
    /**
     * Количество неверного ввода пина до блокировки
     */
    private final int lockCount;

    /**
     * Количество проваленых авторизаций
     */
    private int countFailLogin;

    /**
     * время блокировки
     */
    private LocalDateTime lockDate;


    public PinValidator(int pin, long lockTime, int lockCount) {
        if(lockTime<0 || lockCount<0) throw new IllegalArgumentException();
        countFailLogin = 0;
        login = false;
        this.pin = pin;

        this.lockTime = lockTime;
        this.lockCount=lockCount;
    }

    /**
     * Внутренний вспомогательный метод
     * Добавлен на случай, если на проверку пина будут наложены дополнительные условия.
     * @param pin
     * @return
     */
    private boolean checkPin(int pin) {
        if (this.pin == pin) return true;
        else return false;
    }

    /**
     * Метод проверки валидности введенного пина
     * @param pin
     * @return
     * @throws AccountLockedException выбрасывается, если на момент авторизаци акаунт находится в заблокированном состоянии
     * @throws AuthorizationsException выбрасывается, если на момент авторизации аккаунт не заблокирован, но введен некоректный пин код
     */
    public boolean login(int pin) throws AccountLockedException, AuthorizationsException {


        if (lock) {
            long blockingTime = LocalDateTime.now().getSecond() - lockDate.getSecond();
            if (blockingTime <= lockTime)
                throw new AccountLockedException("Terminal locked, time to unlock:" + (lockTime - blockingTime)+"seconds");
            else {
                lock = false;
                countFailLogin=0;
            }
        }

        if(checkPin(pin)){
            login=true;
            return true;
        }else{
            countFailLogin+=1;
            if(countFailLogin>lockCount){
                lock=true;
                lockDate=LocalDateTime.now();
                throw new AccountLockedException("Terminal locked, time to unlock :"+lockTime +"seconds");

            }
            throw new AuthorizationsException("Invalid pin, Number of attempts before blocking:"+(lockCount-countFailLogin));
        }

    }

    public boolean unlogin(){
        login=false;
        return true;
    }

    public boolean isLogin() {
        return login;
    }
}
