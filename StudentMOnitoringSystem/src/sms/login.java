package sms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField password;
    JButton signin;
    JButton cancel;

    login() {
        setSize(500, 350);


        JLabel l1 = new JLabel("USERNAME");
        l1.setBounds(80, 60, 150, 50);
        l1.setFont(new Font("Tahoma", Font.BOLD, 24));
        l1.setForeground(Color.WHITE);
        add(l1);

        JLabel l2 = new JLabel("PASSWORD");
        l2.setBounds(80, 120, 150, 50);
        l2.setFont(new Font("Tahoma", Font.BOLD, 24));
        l2.setForeground(Color.WHITE);
        add(l2);

        username = new JTextField();
        username.setBounds(250, 60, 150, 40);
        username.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        add(username);

        password = new JPasswordField();
        password.setBounds(250, 120, 150, 40);
        add(password);

        signin = new JButton("SIGN IN");
        signin.setBounds(320, 220, 110, 20);
        signin.addActionListener(this);
        add(signin);

        cancel = new JButton("CANCEL");
        cancel.setBounds(320, 260, 110, 20);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/b15.jpg"));
        JLabel i3 = new JLabel(i1);
        i3.setBounds(0, 0, 500, 350);
        add(i3);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == signin) {
            String username = this.username.getText();
            String password = String.valueOf(this.password.getPassword());
            conn c = new conn();
            try {
                String str = "select * from login where username = '" + username + "' and password = '" + password + "';";
                ResultSet rs = c.s.executeQuery(str);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null,"Login Successfull");

                    this.setVisible(false);
                    new dashboard();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Login Credentials");
                }


            }
            catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"Some Error Occurred");
            }
        }

        if(ae.getSource() == cancel){
            System.exit(0);
        }

    }

        public static void main (String[]args){

            new login();
        }
}
