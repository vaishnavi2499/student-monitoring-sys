package sms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class delete extends JFrame implements ActionListener {
    JButton delete , display , home , back;
    JLabel l1;
    JTextField gr;
    JScrollPane sp1;
    JTable t1;
    Font f1 = new Font("Tahoma", Font.PLAIN,20);
    Font f = new Font("Tahoma", Font.PLAIN,16);
    Font f2 = new Font("Tahoma", Font.BOLD,24);
    delete(){
        setSize(970,600);

        l1 = new JLabel("Enter GR NO");
        l1.setBounds(150,60,150,50);
        l1.setFont(f2);
        add(l1);

        gr = new JTextField();
        gr.setBounds(320,60,80,50);
        gr.setFont(f1);
        add(gr);

        display = new JButton("Display");
        display.setBounds(450,60,150,50);
        display.setFont(f1);
        display.addActionListener(this);
        add(display);

        sp1 = new JScrollPane();
        sp1.setBounds(30,170,900,64);
        add(sp1);

        t1 = new JTable();
        t1.setFont(f);
        t1.setRowHeight(30);
        sp1.setViewportView(t1);

        JTableHeader tb1 = t1.getTableHeader();
        tb1.setFont(new Font("Tahoma", Font.BOLD, 22));
        tb1.setBackground(Color.cyan);

        delete = new JButton("Delete");
        delete.setBounds(400,480,150,50);
        delete.setFont(f1);
        delete.addActionListener(this);
        add(delete);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(60,50,Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        home = new JButton(i6);
        home.setBounds(870,10,50,50);
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
    public void actionPerformed(ActionEvent ae) {
        conn c = new conn();
        String gr = this.gr.getText();
        if (ae.getSource() == display) {
            String query = "select gr , name , aadhar , dob , phoneno , bloodgrp , address , gender from adddetails where gr = '"+gr+"';";
            try {
                ResultSet rs = c.s.executeQuery(query);
                t1.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                System.out.println(e);
            }

        }
        if(ae.getSource() == delete){
            String query = "delete from adddetails  where gr = '"+gr+"';";
            try {
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Data Deleted Successfully");

            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"Some Error Occured");
            }
        }

        if(ae.getSource() == back){
            new viewDetails();
            this.setVisible(false);
        }
        if(ae.getSource() == home){
            new dashboard();
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new delete();
    }
}
