import ProjectException.AccountLockedException;
import ProjectException.PinValidatorException;
import ProjectException.TerminalException;
import ProjectException.TerminalServerException;

import java.io.IOException;
import java.util.Scanner;

public class Console {
    public static void printMenu() {
        System.out.println(
                "Menu:\n" +
                        "1.Логин\n" +
                        "2.Положить деньги на счет\n" +
                        "3.Снять деньги с счета\n" +
                        "4.Запросить баланс\n" +
                        "0.Выйти из терминала\n"
        );
    }

    public static void main(String[] args) {
        Account account = new Account("Account");
        TerminalServer terminalServer = new TerminalServer(account);
        PinValidator pinValidator = new PinValidator(1234, 5, 3);
        TerminalImpl terminal = new TerminalImpl(pinValidator, terminalServer, 100);
        Integer choice = -1;
        Integer amount;
        Integer pin ;
        ExceptionHandler exceptionHandler = new WindowExceptionHandler();
        try (Scanner scanner = new Scanner(System.in)) {
            while (choice != 0) {
                try {

                    printMenu();
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Пожалуйста введите пинкод:");
                             pin=scanner.nextInt();
                            terminal.login(pin);
                            break;
                        case 2:
                            System.out.println("Пожалуйста введите сумму");
                            amount=scanner.nextInt();
                            terminal.putMoney(amount);
                            System.out.println("Текущий баланс:"+ terminal.getBalance());
                            break;
                        case 3:
                            System.out.println("Пожалуйста введите сумму");
                            amount=scanner.nextInt();
                           terminal.getMoney(amount);
                            System.out.println("Текущий баланс:"+ terminal.getBalance());
                            break;
                        case 4:
                            System.out.println("Текущий баланс:"+ terminal.getBalance());
                            break;
                        case 0:
                            System.out.println("Всего доброго");
                            terminal.unlogin();
                            break;
                            default:
                                System.out.println("Неверный пункт меню");
                                break;
                    }


                }catch (PinValidatorException x){
                    exceptionHandler.showExceptionMessage(x);
                }catch (TerminalException x){
                    exceptionHandler.showExceptionMessage(x);
                }catch (TerminalServerException x){
                    exceptionHandler.showExceptionMessage(x);
                }

            }

        } catch (Exception x) {
            x.printStackTrace();
        }


    }
}
