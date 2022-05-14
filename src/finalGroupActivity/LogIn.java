package finalGroupActivity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class LogIn extends JFrame {
    private JPasswordField pfPassword;
    private JTextField tfAge;
    private JTextField tfUsername;
    private JPasswordField pfConfirmPassword;
    private JTextField tfName;
    private JButton createAnAccountButton;
    private JButton logInButton;
    private JPanel logInForm;

    public LogIn(JFrame parent){
        setTitle("Create a New Account");
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
                registerUser();
            }
        });
    }


    /*
    LOGIN NOT COMPLETELY WORKING YET
     */
    private void logInUser() {
        try{
            String user = tfUsername.getText();
            String pass = pfPassword.getText();
            ArrayList<String> username = new ArrayList<String>();
            ArrayList<String> password = new ArrayList<String>();
            if(user.isEmpty() || pass.isEmpty()){
                JOptionPane.showMessageDialog(null,"Field Should Not Be Empty!!!");
            }else{
                try {
                    String path = "C:\\Users\\Gerwin\\Documents\\GitHub\\FinalGroupActivity\\UserInformationDontHack.txt";
                    File file = new File(path);
                    FileReader fr=new FileReader(file);
                    BufferedReader br=new BufferedReader(fr);
                    String line;
                    if(file.exists()){
                        while((line = br.readLine()) != null) {
                            String[] columns = line.split(",");
                            for(int i=0;i<columns.length;i=i+4){
                                username.add(columns[i]);
                            }
                            for(int i=1;i<columns.length;i=i+4){
                                password.add(columns[i]);
                            }
                        }
                        if(username.contains(user) && password.contains(pass)){
                            JOptionPane.showMessageDialog(null,"Login Successfull.");
                            tfUsername.setText("");
                            pfPassword.setText("");
                        }else{
                            JOptionPane.showMessageDialog(null,"User Does Not Exists.");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"File Not Found.");
                    }
                } catch (IOException e){
                    JOptionPane.showMessageDialog(null,"Exception Error Occured");
                    e.printStackTrace();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
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
            writer.write("" + name + " " + username + " " + age + " " + password + " " + confirmPassword);
            writer.write(System.getProperty("line.separator"));
            writer.close();
            JOptionPane.showMessageDialog(this, "Account Successfully Created");
            setVisible(false);
            new Registration(this).setVisible(true);
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,"ERROR");
        }
    }
    public static void main(String[] args) {
        LogIn myForm = new LogIn(null);
    }
}

