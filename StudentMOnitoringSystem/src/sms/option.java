package sms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class option extends JFrame implements ActionListener  {
    JButton details , attendance , marks , back;
    Font f1 = new Font("Tahoma", Font.BOLD,24);
    option(){
        setSize(700,400);


        details = new JButton("Details");
        details.setBounds(50,140,180,50);
        details.setFont(f1);
        details.addActionListener(this);
        add(details); 
        
        attendance = new JButton("Attendance");
        attendance.setBounds(250,140,180,50);
        attendance.setFont(f1);
        attendance.addActionListener(this);
        add(attendance); 
        
        marks = new JButton("Marks");
        marks.setBounds(450,140,180,50);
        marks.setFont(f1);
        marks.addActionListener(this);
        add(marks);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/back.png"));
        Image i2 = i1.getImage().getScaledInstance(60,50,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        back = new JButton(i3);
        back.setBounds(10,10,50,50);
        back.addActionListener(this);
        add(back);
        ImageIcon i12 = new ImageIcon(ClassLoader.getSystemResource("images/b9.jpg"));
        JLabel i13 = new JLabel(i12);
        i13.setBounds(0,0,900,800);
        add(i13);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == details){
            new viewDetails();
            this.setVisible(false);
        }
        if(ae.getSource() == attendance){
            new viewAttendance();
            this.setVisible(false);
        }
        if(ae.getSource() == marks) {
            new viewMarks();
            this.setVisible(false);
        }
        if(ae.getSource() == back){
            new dashboard();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
     new option();
    }
}
