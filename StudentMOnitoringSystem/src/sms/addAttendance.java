package sms;

import net.proteanit.sql.DbUtils;

import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class addAttendance extends JFrame implements ActionListener {
    JLabel l1 , l2;
    JButton display , update , back , home;
    JTextField gr , newatt;
    JTable att;

    JScrollPane sp1;
    Font f1 = new Font("Tahoma", Font.PLAIN,24);
    Font f2 = new Font("Tahoma", Font.PLAIN,20);
    addAttendance(){
        setSize(600,700);

        l1 = new JLabel("Enter GR NO");
        l1.setBounds(140,50,150,50);
        l1.setFont(f1);
        add(l1);

        gr = new JTextField();
        gr.setBounds(300,50,80,50);
        gr.setFont(f2);
        add(gr);

        display =new JButton("Display");
        display.setBounds(400,50,150,50);
        display.setFont(f1);
        display.addActionListener(this);
        add(display);

        sp1 = new JScrollPane();
        sp1.setBounds(50,200,480,64);
        add(sp1);

        att = new JTable();
        att.setFont(f1);
        att.setRowHeight(30);
        sp1.setViewportView(att);

        JTableHeader tb1 = att.getTableHeader();
        tb1.setFont(new Font("Tahoma", Font.BOLD, 22));
        tb1.setBackground(Color.cyan);


        l2 = new JLabel("Add / Update Attendance");
        l2.setBounds(100,350,250,50);
        l2.setFont(f2);
        add(l2);

        newatt = new JTextField();
        newatt.setBounds(350,350,80,50);
        newatt.setFont(f2);
        add(newatt);

        update = new JButton("Update");
        update.setBounds(220,500,150,50);
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
        home.setBounds(530,600,50,50);
        home.addActionListener(this);
        add(home);






        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String gr = this.gr.getText();
        conn c = new conn();
        if(ae.getSource() == display){
            String query1 = "select gr , name , attendance from adddetails where gr = '"+gr+"'; ";
            try{
                ResultSet rs = c.s.executeQuery(query1);
                att.setModel(DbUtils.resultSetToTableModel(rs));

            }catch(Exception e){
                System.out.println(e);
            }
        }
        if(ae.getSource() == update){
            String newatt = this.newatt.getText();
            String query2 = "update adddetails set attendance = '"+newatt+"'  where gr = '"+gr+"';";
            try{
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null , "Data Added Successfully!!");
            }
            catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null , "Some Error Occured!!");
            }
            this.newatt.setText(null);

        }
        if(ae.getSource() == back){
            new viewAttendance();
            this.setVisible(false);
        }

        if(ae.getSource() == home){
            new dashboard();
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new addAttendance();
    }

}
