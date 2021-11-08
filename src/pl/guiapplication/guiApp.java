package pl.guiapplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guiApp implements ActionListener {

    private JPanel panel;
    private JFrame frame;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JTextField userText;
    private JPasswordField passwordText;
    private JButton loginButton;

    public guiApp(){

        panel = new JPanel();
        panel.setLayout(null);

        frame = new JFrame();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        /* loginButton.addActionListener(new guiApp()); */
        panel.add(loginButton);



        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new guiApp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       /* String user =  userText.getText();
        String password = passwordText.getText();

        if (user.equals("Denis") && password.equals("123")){
            System.out.println("XD");

        */



    }
}
