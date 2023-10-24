package sms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dashboard extends JFrame implements ActionListener {
    JMenuBar mb;
    JButton prim , p1 , p2 ,logout;
    Font f1 = new Font("Tahoma", Font.PLAIN,20);
    Font f = new Font("Tahoma", Font.PLAIN,16);
    Font f2 = new Font("Tahoma", Font.BOLD,24);
    dashboard(){
        setSize(800,700);

        mb = new JMenuBar();
        mb.setBounds(0,0,300,700);
        mb.setBackground(Color.CYAN);
        mb.setLayout(new GridLayout(5,1,0,20));
        add(mb);

        p1 = new JButton();
        p1.setFont(f2);
        mb.add(p1);
        
        prim = new JButton("STUDENT DETAILS");
        prim.setFont(f2);
        prim.addActionListener(this);
        mb.add(prim);
        
        


        logout = new JButton("Log Out");
        logout.setFont(f2);
        logout.addActionListener(this);
        mb.add(logout);
        
        p2 = new JButton();
        mb.add(p2);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("images/b18.jpg"));
        JLabel i3 = new JLabel(i2);
        i3.setBounds(300,0,600,700);
        add(i3);






        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == logout){
            new login();
            this.setVisible(false);
        }

        if(ae.getSource() == prim){
            new option();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new dashboard();
    }
}
