import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MainForm {

    private final String REGEX_VALIDATION = "[а-яА-Яa-zA-Z]+";

    private JPanel mainPanel;
    private JTextField textFieldFamily;
    private JTextField textFieldName;
    private JTextField textFieldmiddleName;
    private JPanel jPanelLabels;
    private JPanel jPanelFields;
    private JButton button;
    private JPanel jPanelButton;
    private JLabel labelFamily;
    private JLabel labelName;
    private JLabel labelMiddleName;
    private JPanel childPanel;
    private JPanel jPanelFio;
    private JTextField textFieldFio;

    public MainForm(){
        button.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonText = button.getText();
                switch (buttonText){
                    case "Collapse" -> {
                        String textFamilyField = textFieldFamily.getText();
                        String textNameField = textFieldName.getText();
                        if (!textFamilyField.matches(REGEX_VALIDATION) || !textNameField.matches(REGEX_VALIDATION))
                            JOptionPane.showMessageDialog(mainPanel, """
                                        Поля "Фамилия" и "Имя" должны быть заполнены.
                                        При заполнении необходимо использовать символы русскоязычного или английского алфавитов.
                                        Пожалуйста, заполните недостающую информацию и повторите попытку.
                                        """, "Ошибка заполнения", JOptionPane.ERROR_MESSAGE);
                        else {
                            jPanelFields.setVisible(false);
                            jPanelLabels.setVisible(false);
                            jPanelFio.setVisible(true);
                            button.setText("Expand");
                            String textMiddleName = textFieldmiddleName.getText();
                            textFieldFio.setText(textFamilyField + " " + textNameField + " " + textMiddleName);
                        }
                    }
                    case "Expand" -> {
                        String[] textValues = textFieldFio.getText().split(" ");
                        if (textValues.length < 2 || textValues.length > 3)
                            JOptionPane.showMessageDialog(mainPanel, """
                                        В поле "ФИО" требуется задать не менее двух и не более трех слов,
                                        разделенных пробелом, каждое из которых должно состоять из букв русскоязычного или английского алфавитов.
                                        """, "Ошибка заполнения", JOptionPane.ERROR_MESSAGE);
                        else if (textValues[0].matches(REGEX_VALIDATION) && textValues[1].matches(REGEX_VALIDATION)){
                            textFieldFamily.setText(textValues[0]);
                            textFieldName.setText(textValues[1]);
                            textFieldmiddleName.setText( (textValues.length == 3) ? textValues[2] : "");
                            jPanelFio.setVisible(false);
                            jPanelFields.setVisible(true);
                            jPanelLabels.setVisible(true);
                            button.setText("Collapse");
                        } else
                            JOptionPane.showMessageDialog(mainPanel, """
                                        В значениях полей фамилии и имени выявлены недопустимые символы.
                                        Повторите попытку ввода данных значений, используя символы русскоязычного или английского алфавитов.
                                        """, "Ошибка заполнения", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    public JPanel getMainPanel(){
        return mainPanel;
    }
}
