package sms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class viewAttendance extends JFrame implements ActionListener {
    JButton add , defaulters , refresh , back , home;
    JTable showDetails;
    JScrollPane sp1;
    Font f = new Font("Tahoma", Font.BOLD,36);
    Font f1 = new Font("Tahoma", Font.PLAIN,24);

    viewAttendance(){
        setSize(1000,700);

        JLabel l1 = new JLabel("ATTENDANCE");
        l1.setBounds(380,40,250,100);
        l1.setFont(f);
        add(l1);

        add = new JButton("Add/Update");
        add.setBounds(80,150,200,50);
        add.setFont(f1);
        add.addActionListener(this);
        add(add);

        defaulters = new JButton("Defaulters");
        defaulters.setBounds(80,300,200,50);
        defaulters.setFont(f1);
        defaulters.addActionListener(this);
        add(defaulters);

        refresh = new JButton("Refresh");
        refresh.setBounds(80,450,200,50);
        refresh.setFont(f1);
        refresh.addActionListener(this);
        add(refresh);

        sp1 = new JScrollPane();
        sp1.setBounds(350,150,600,500);
        add(sp1);

        showDetails = new JTable();
        showDetails.setFont(f1);
        showDetails.setRowHeight(30);
        sp1.setViewportView(showDetails);

        JTableHeader tb1 = showDetails.getTableHeader();
        tb1.setFont(new Font("Tahoma", Font.BOLD, 22));
        tb1.setBackground(Color.cyan);

        JLabel def = new JLabel("Defaulters");
        def.setBounds(400,70,250,100);
        def.setFont(f1);
        def.setVisible(false);
        add(def);


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






        getDetails();


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void getDetails(){
        conn c = new conn();
        String query = "select gr , name , attendance from adddetails;";
        try{
            ResultSet rs = c.s.executeQuery(query);
            showDetails.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            System.out.println(e);

        }
        
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            new addAttendance();
            this.setVisible(false);
        }
        if(ae.getSource() == defaulters){
            conn c = new conn();
                String query = "select gr , name , attendance from adddetails where attendance < 75 ;";
                try{
                 ResultSet rs = c.s.executeQuery(query);
                 showDetails.setModel(DbUtils.resultSetToTableModel(rs));
                }
            catch(Exception e){
                System.out.println(e);
            }

        }
        if(ae.getSource() == refresh){
            getDetails();
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
        new viewAttendance();
    }
}
