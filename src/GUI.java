import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GUI extends JFrame{
    private JPanel contentPane;
    private JLabel firstName;
    private JLabel secondName;
    private JLabel proff;
    private JTextField inputName;
    private JTextField inputSurname;
    private JComboBox inputJob;
    private JLabel zapytanie;
    private JSpinner spinner1;
    private JCheckBox duzeZnaki;
    private JCheckBox liczby;
    private JCheckBox specjalne;
    private JButton generujButton;
    private JButton zatwierdźButton;
    private JPanel danePracownika;
    private JPanel generujHaslo;
    String ENDhaslo;

    public GUI(){
        add(contentPane);
        danePracownika.setBorder(BorderFactory.createTitledBorder("Dane Pracownika"));
        generujHaslo.setBorder(BorderFactory.createTitledBorder("Generator Hasła"));
        danePracownika.setBackground(Color.decode("#b0c4de"));
        generujHaslo.setBackground(Color.decode("#b0c4de"));
        generujButton.setBackground(Color.decode("#4682B4"));
        zatwierdźButton.setBackground(Color.decode("#4682B4"));
        generujButton.setForeground(Color.decode("#ffffff"));
        zatwierdźButton.setForeground(Color.decode("#ffffff"));
        contentPane.setBackground(Color.decode("#b0c4de"));
        duzeZnaki.setBackground(Color.decode("#b0c4de"));
        liczby.setBackground(Color.decode("#b0c4de"));
        specjalne.setBackground(Color.decode("#b0c4de"));


        generujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ENDhaslo = "";
                String defaultHaslo = "qwertyuiopasdfghjklzxcvbnm";
                String duzeHaslo = "QWERTYUIOPASDFGHJKLZXCVBNM";
                String znakiHaslo = "`~!@#$%^&*()_+-=[]{};':,.<>/?";
                String liczbyHaslo = "1234567890";
                int value = (Integer) spinner1.getValue();

                if (duzeZnaki.isSelected()){
                    defaultHaslo += duzeHaslo;
                }
                if (specjalne.isSelected()){
                    defaultHaslo += znakiHaslo;
                }
                if (liczby.isSelected()){
                    defaultHaslo += liczbyHaslo;
                }

                char[] KluczoweLitery = defaultHaslo.toCharArray();
                for (int i = 0; i<value; i++){
                    Random random = new Random();
                    int losow = random.nextInt(0,defaultHaslo.length());

                    ENDhaslo += KluczoweLitery[losow];
                }
                JOptionPane.showMessageDialog(generujButton, ENDhaslo);

            }
        });
        zatwierdźButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String imie = inputName.getText();
                String nazwisko = inputSurname.getText();
                String praca = (String) inputJob.getSelectedItem();
                String haslo = ENDhaslo;

                JOptionPane.showMessageDialog(zatwierdźButton, "Imie: " + imie + "\n" + "Nazwisko: " + nazwisko + "\n"+"Stanowisko: " + praca + "\n" + "Hasło: " + haslo);
            }
        });
    }

}
