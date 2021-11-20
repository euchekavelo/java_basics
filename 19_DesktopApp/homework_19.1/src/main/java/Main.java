import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Форма валидации");
        jFrame.setSize(350, 210);
        jFrame.add(new MainForm().getMainPanel());
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

}
