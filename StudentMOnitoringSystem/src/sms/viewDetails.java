package sms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class viewDetails extends JFrame implements ActionListener {
    JScrollPane sp1;
    JTable details;

    JButton add , update , delete , back , home;
    Font f1 = new Font("Tahoma", Font.PLAIN,24);
    viewDetails(){
        setSize(1000,700);

        sp1 = new JScrollPane();
        sp1.setBounds(60,80,900,400);
        add(sp1);

        details = new JTable();
        details.setFont(new Font("Tahoma", Font.PLAIN, 16));
        details.setRowHeight(26);
        sp1.setViewportView(details);

        JTableHeader tb1 = details.getTableHeader();
        tb1.setFont(new Font("Tahoma", Font.BOLD, 22));
        tb1.setBackground(Color.cyan);

        getDetails();

        add = new JButton("Add");
        add.setBounds(200,550,150,50);
        add.setFont(f1);
        add.addActionListener(this);
        add(add);
        
        update = new JButton("Update");
        update.setBounds(400,550,150,50);
        update.setFont(f1);
        update.addActionListener(this);
        add(update);
        
        delete = new JButton("Delete");
        delete.setBounds(600,550,150,50);
        delete.setFont(f1);
        delete.addActionListener(this);
        add(delete);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/back.png"));
        Image i2 = i1.getImage().getScaledInstance(60,50,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        back = new JButton(i3);
        back.setBounds(10,10,50,50);
        back.addActionListener(this);
        add(back);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(60,50,Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        home = new JButton(i6);
        home.setBounds(930,10,50,50);
        home.addActionListener(this);
        add(home);




        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void getDetails(){
        conn c = new conn();
        String query = "select gr , name , aadhar , phoneno , bloodgrp , address , gender , dob from adddetails";
        try{
            ResultSet rs = c.s.executeQuery(query);
            details.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            new addDetails();
            this.setVisible(false);
        }
        if(ae.getSource() == update){
            new update();
            this.setVisible(false);
        }
        if(ae.getSource() == delete){
            new delete();
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
        new viewDetails();
    }
}
