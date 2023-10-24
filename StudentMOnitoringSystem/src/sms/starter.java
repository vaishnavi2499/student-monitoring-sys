package sms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class starter extends JFrame implements ActionListener {

    JButton login;
    starter(){
        setSize(800,700);
        JLabel l1=new JLabel("SIES");
        l1.setBounds(325,50,500,100);
        l1.setForeground(Color.white);
        l1.setFont(new Font("TAHOMA", Font.BOLD,50));
        add(l1);

        login=new JButton("LOGIN");
        login.setBounds(650,550,100,70);
        login.setFont(new Font("Ariel",Font.ITALIC,15));
        login.addActionListener(this);
        add(login);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("images/b9.jpg"));
        JLabel i3 = new JLabel(i2);
        i3.setBounds(0,0,900,800);
        add(i3);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            new login();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new starter();
    }
}
