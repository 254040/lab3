package pl.guiapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class guiApp implements ActionListener {

    private JPanel panel;
    private JFrame frame;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JTextField userText;
    private JPasswordField passwordText;
    private JButton loginButton;
    private JButton resetButton;
    private Color defaultColor;



    public guiApp(){

        panel = new JPanel();
        panel.setLayout(null);
        defaultColor = panel.getBackground();

        frame = new JFrame();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165,25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80,25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        loginButton = new JButton("Log in");
        loginButton.setBounds(20,90,80,25);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        resetButton = new JButton("Reset");
        resetButton.setBounds(120,90,80,25);
        resetButton.addActionListener(this);
        panel.add(resetButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException{
        new guiApp();
    }

    private static final Boolean Login(String user, char[] password) throws IOException {

        Path inputPath = Paths.get("D:\\JetBrains\\IDEA Projects\\lab3\\src\\usersData.txt");
        List<String> lines;
        lines = Files.readAllLines(inputPath, Charset.forName("UTF-8"));


        String passwordString = String.valueOf(password);

        for (int i = 0; i< lines.size(); i=i+2){
            if(lines.get(i).equals(user)){
                if (lines.get(i+1).equals(passwordString)){
                    return true;
                }
                return false;
            }

        }
        return false;


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == loginButton){

            try {
                if (Login(userText.getText(), passwordText.getPassword())){
                    panel.setBackground(Color.GREEN);

                }
                else {
                    panel.setBackground(Color.RED);

                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (source == resetButton){
            panel.setBackground(defaultColor);
            userText.setText("");
            passwordText.setText("");
        }

    }
}
