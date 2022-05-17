package finalGroupActivity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class LogIn extends JFrame {
    private JPasswordField pfPassword;
    private JTextField tfUsername;
    private JButton createAnAccountButton;
    private JButton logInButton;
    private JPanel logInForm;

    public LogIn(JFrame parent){
        setTitle("Login to Account");
        setContentPane(logInForm);
        setMinimumSize(new Dimension(490,500));
        setLocationRelativeTo(parent);
        setVisible(true);
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logInUser();
            }
        });
        createAnAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registration myForm = new Registration(null);

            }
        });

    }

    private void logInUser() {
        try{
            String user = tfUsername.getText();
            String pass = String.valueOf(pfPassword.getPassword());
            String username = "";
            String password = "";
            if(user.isEmpty() || pass.isEmpty()){
                JOptionPane.showMessageDialog(null,"Field Should Not Be Empty!!!");
            }else{
                try {
                    String path = "d:\\Users\\user\\Documents\\GitHub\\FinalGroupActivity\\UserInformationDontHack.txt";
                    File file = new File(path);
                    FileReader fr=new FileReader(file);
                    BufferedReader br=new BufferedReader(fr);
                    String line;
                    if(file.exists()){
                        while((line = br.readLine()) != null) {
                            String[] columns = line.split(",");
                            username = columns[1];
                            password = columns[4];
                        }
                        if(username.contains(user) && password.contains(pass)){
                            JOptionPane.showMessageDialog(null,"Login Successful.");
                            tfUsername.setText("");
                            pfPassword.setText("");
                        }else{
                            JOptionPane.showMessageDialog(null,"User Does Not Exist.");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"File Not Found.");
                    }
                } catch (IOException e){
                    JOptionPane.showMessageDialog(null,"Exception Error Occurred");
                    e.printStackTrace();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LogIn myForm = new LogIn(null);
    }
}

