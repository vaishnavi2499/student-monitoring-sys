package sms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class viewMarks extends JFrame implements ActionListener {
    JScrollPane sp1, sp2;
    JTabbedPane tabs;
    JTable sem1 , sem2;
    JButton add, pf , home , back;
    viewMarks(){
        setSize(1000,700);

        //declaring scrollpane
        sp1 = new JScrollPane();
        sp2 = new JScrollPane();

        //declaring tables
        sem1 = new JTable();
        sp1.setViewportView(sem1);
        sem2 = new JTable();
        sp2.setViewportView(sem2);

      //declaring tab containers
        tabs = new JTabbedPane();
        tabs.setBounds(280,80,650,500);

        //declaring individual tabs
        tabs.add("SEM 1", sp1);
        tabs.add("SEM 2", sp2);

        add(tabs);

        conn c = new conn();

        //sem1
        try{
            String str1 = "select  gr, name , english ,  maths , science  from adddetails ";
         ResultSet rs = c.s.executeQuery(str1);
            sem1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            System.out.println(e);
        }

        //sem2
        try{
            String str2 = "select  gr , name , geography , history , marathi  from adddetails ";
            ResultSet rs = c.s.executeQuery(str2);
            sem2.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            System.out.println(e);
        }

        add = new JButton("Add/Update");
        add.setBounds(70,300,150,50);
        add.addActionListener(this);
        add(add);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(60,50,Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        home = new JButton(i6);
        home.setBounds(930,10,50,50);
        home.addActionListener(this);
        add(home);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/back.png"));
        Image i2 = i1.getImage().getScaledInstance(60,50,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        back = new JButton(i3);
        back.setBounds(10,10,50,50);
        back.addActionListener(this);
        add(back);




        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            new addMarks();
            this.setVisible(false);
        }
        if(ae.getSource() == back){
            new option();
            this.setVisible(false);
        }
        if(ae.getSource() == home){
            new dashboard();
            this.setVisible(false);
        }


    }


    public static void main(String[] args) {
        new viewMarks();
    }
}
