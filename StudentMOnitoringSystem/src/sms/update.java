package sms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update extends JFrame implements ActionListener {
    JLabel l1 , l2 , l3 , l4;
    JButton update , display , home , back;
    JTextField gr , data;
    JComboBox fields;
    JScrollPane sp1;

    String [] list = {"Name" , "Address" , "Aadhar"  , "Gender" , "Phoneno" };
    JTable t1;
    Font f1 = new Font("Tahoma", Font.PLAIN,20);
    Font f = new Font("Tahoma", Font.PLAIN,16);
    Font f2 = new Font("Tahoma", Font.BOLD,24);
    update(){
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

        l2 = new JLabel("Choose Field");
        l2.setBounds(150,300,250,50);
        l2.setFont(f2);
        add(l2);

        //combobox

        fields = new JComboBox(list);
        fields.setBounds(380,300,200,50);
        fields.setFont(f1);
        fields.setSelectedIndex(-1);
        add(fields);

        l3 = new JLabel("Updated Data");
        l3.setBounds(150,400,250,50);
        l3.setFont(f2);
        add(l3);

        data = new JTextField();
        data.setBounds(380,400,150,40);
        data.setFont(f1);
        add(data);

        update = new JButton("Update");
        update.setBounds(400,480,150,50);
        update.setFont(f1);
        update.addActionListener(this);
        add(update);

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
        home.setBounds(850,10,50,50);
        home.addActionListener(this);
        add(home);






        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        conn c = new conn();
        String gr = this.gr.getText();
        if(ae.getSource() == display){
            String query = "select gr , name , aadhar , dob , phoneno , bloodgrp , address , gender from adddetails where gr = '"+gr+"';";
            try{
                ResultSet rs = c.s.executeQuery(query);
                t1.setModel(DbUtils.resultSetToTableModel(rs));

            }
            catch(Exception e){
                System.out.println(e);
            }

        }
        if(ae.getSource() == update){
            String value = this.data.getText();
            String choice = fields.getSelectedItem().toString();
            String query = "update adddetails set "+choice+" = '"+value+"' where gr = '"+gr+"';";
            try{
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Data Updated Successfully!!");
            }
            catch (Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"Some Error Occurred!");
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
        new update();
    }
}
