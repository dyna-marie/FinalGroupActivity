package finalGroupActivity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationAndLoginApp extends JFrame{
        public void show() {
        JPanel registrationAndLoginForm = new JPanel();
        registrationAndLoginForm.setBackground(Color.lightGray);

        JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(490, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(registrationAndLoginForm);

        JLabel message1 = new JLabel("This application allows you to");
        message1.setFont(new Font("Courier New", Font.BOLD, 20));
        message1.setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
        registrationAndLoginForm.add(message1);

        JLabel message2 = new JLabel("log in to an existing account");
        message2.setFont(new Font("Courier New", Font.BOLD, 20));
        registrationAndLoginForm.add(message2);

        JLabel message3 = new JLabel("or to create a new one.");
        message3.setFont(new Font("Courier New", Font.BOLD, 20));
        message3.setBorder(BorderFactory.createEmptyBorder(0,100,100,100));
        registrationAndLoginForm.add(message3);

        JButton logInButton = new JButton("Log In");
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogIn logInUser = new LogIn(null);
            }
        });
        logInButton.setBackground(Color.gray);
        registrationAndLoginForm.add(logInButton);

        JButton createAnAccountButton = new JButton("Register");
        createAnAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registration myForm = new Registration(null);
            }
        });
        createAnAccountButton.setBackground(Color.gray);
        registrationAndLoginForm.add(createAnAccountButton);
    } //end of show() method

    public static void main (String[]args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistrationAndLoginApp().show();
            }
        });
    } //end of main method
} //end of RegistrationAndLoginApp class

