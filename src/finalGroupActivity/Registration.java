package finalGroupActivity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class Registration extends JFrame {
    private JPasswordField pfPassword;
    private JTextField tfAge;
    private JTextField tfUsername;
    private JPasswordField pfConfirmPassword;
    private JTextField tfName;
    private JButton createMyAccountButton;
    private JPanel registrationForm;

    public Registration(JFrame parent){
        setTitle("Create a New Account");
        setContentPane(registrationForm);
        setMinimumSize(new Dimension(490,500));
        setLocationRelativeTo(parent);
        setVisible(true);
        createMyAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String name = tfName.getText();
        String username = tfUsername.getText();
        String age = tfAge.getText();
        String password = String.valueOf(pfPassword.getPassword());
        String confirmPassword = String.valueOf(pfConfirmPassword.getPassword());

        if (name.isEmpty() || username.isEmpty() || age.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
            JOptionPane.showMessageDialog(this,
                    "Please enter all fields",
                    "Please Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;

        }
        if (!password.equals(confirmPassword)){
            JOptionPane.showMessageDialog(this,
                    "Passwords do not match",
                    "Please Try Again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (password.length() < 6){
            JOptionPane.showMessageDialog(this,
                    "Password must have more than 5 characters",
                    "Please Try Again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try{
            FileWriter writer = new FileWriter("UserInformationDontHack.txt",true);
            writer.write(name + "," + username + "," + age + "," + password + "," + confirmPassword);
            writer.write(System.getProperty("line.separator"));
            writer.close();
            JOptionPane.showMessageDialog(this, "Account Successfully Created");
            setVisible(false);
            new Registration(this).setVisible(true);
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,"ERROR");
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        Registration myForm = new Registration(null);
    }
}

