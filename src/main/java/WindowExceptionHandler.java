import javax.swing.*;
import java.awt.*;

public class WindowExceptionHandler  extends JFrame implements ExceptionHandler {
    private JLabel messageLabel;
    public WindowExceptionHandler(){
        setSize(450,150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    @Override
    public void showExceptionMessage(Exception x) {
        Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int)dimension.getWidth()/2,(int)dimension.getHeight()/2);
        messageLabel = new JLabel(x.getMessage());
        add(messageLabel,BorderLayout.CENTER);
        setVisible(true);


    }
}
