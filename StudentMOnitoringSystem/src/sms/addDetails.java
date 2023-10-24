package sms;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class addDetails extends JFrame implements ActionListener {
    Font font = new Font("Tahoma", Font.BOLD,20);
    Font fontxt = new Font("Tahoma", Font.PLAIN,15);
    int x=80;
    int x1=250;
    int txtWidth=180;
    int txtHeight=40;
    JTextField name , phoneNo , address , aadhar;
    JDateChooser dob;
    ButtonGroup gender;
    JButton add , back , home;
    JComboBox bldgrp;
    JRadioButton male , female;

    addDetails(){
        setSize(600,800);

        JLabel l1=new JLabel("Name");
        l1.setBounds(x,80,180,50);
        l1.setFont(font);
        l1.setForeground(Color.white);
        add(l1);
        
        JLabel l2=new JLabel("Address");
        l2.setBounds(x,160,180,50);
        l2.setFont(font);
        l2.setForeground(Color.white);
        add(l2);
        
        JLabel l3=new JLabel("D.O.B.");
        l3.setBounds(x,240,180,50);
        l3.setFont(font);
        l3.setForeground(Color.white);
        add(l3);
        
        JLabel l4=new JLabel("Aadhar");
        l4.setBounds(x,320,180,50);
        l4.setFont(font);
        l4.setForeground(Color.white);
        add(l4);
        
        JLabel l5=new JLabel("Gender");
        l5.setBounds(x,400,180,50);
        l5.setFont(font);
        l5.setForeground(Color.white);
        add(l5);
        
        JLabel l6=new JLabel("Phone No");
        l6.setBounds(x,480,180,50);
        l6.setFont(font);
        l6.setForeground(Color.white);
        add(l6);
        
        JLabel l7=new JLabel("Blood Grp");
        l7.setBounds(x,560,180,50);
        l7.setFont(font);
        l7.setForeground(Color.white);
        add(l7);

        name= new JTextField();
        name.setBounds(x1,80,txtWidth,txtHeight);
        name.setFont(fontxt);
        add(name);

        address= new JTextField();
        address.setBounds(x1,160,txtWidth,txtHeight);
        address.setFont(fontxt);
        add(address);

        phoneNo= new JTextField();
        phoneNo.setBounds(x1,480,txtWidth,txtHeight);
        phoneNo.setFont(fontxt);
        add(phoneNo);

        aadhar= new JTextField();
        aadhar.setBounds(x1,320,txtWidth,txtHeight);
        aadhar.setFont(fontxt);
        add(aadhar);

        dob = new JDateChooser();
        dob.setBounds(x1,240,txtWidth,txtHeight);
        dob.setFont(fontxt);
        add(dob);

        gender = new ButtonGroup();

         male = new JRadioButton("Male");
        male.setBounds(x1,400,txtWidth/2,txtHeight);
        male.setFont(fontxt);
        gender.add(male);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(x1+100,400,txtWidth/2,txtHeight);
        female.setFont(fontxt);
        gender.add(female);
        add(female);

        String [] arr = {"A+","AB+","O+","AB-","O-","B+","B-"};
       bldgrp = new JComboBox(arr);
        bldgrp.setBounds(x1,560,txtWidth,txtHeight);
        bldgrp.setFont(fontxt);
        bldgrp.setSelectedIndex(-1);
        add(bldgrp);

        add= new JButton("Add Details");
        add.setBounds(250,650,100,50);
        add.addActionListener(this);
        add(add);



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/back.png"));
        Image i10 = i1.getImage().getScaledInstance(60,50,Image.SCALE_SMOOTH);
        ImageIcon i11 = new ImageIcon(i10);
        back = new JButton(i11);
        back.setBounds(0,0,50,50);
        back.addActionListener(this);
        add(back);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(60,50,Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        home = new JButton(i6);
        home.setBounds(480,700,50,50);
        home.addActionListener(this);
        add(home);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("images/b9.jpg"));
        JLabel i3 = new JLabel(i2);
        i3.setBounds(0,0,600,800);
        add(i3);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){

            String name = this.name.getText();
            String address = this.address.getText();
            String phoneno = this.phoneNo.getText();
            String aadhar = this.aadhar.getText();

            String bldgrp = (String) this.bldgrp.getSelectedItem();

            String gender = null;
            if(male.isSelected()){
                gender = "Male";
            }
            else if(female.isSelected()){
                gender = "Female";
            }
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            String dob = df.format(this.dob.getDate());

            conn c = new conn();

            String query = "insert into adddetails (name,address,aadhar,phoneno,gender,bloodgrp,dob) values ('"+name+"','"+address+"','"+aadhar+"','"+phoneno+"','"+gender+"','"+bldgrp+"','"+dob+"');";
            try{
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Data Added Successfully!!");

                this.name.setText(null);
                this.address.setText(null);
                this.phoneNo.setText(null);
                this.aadhar.setText(null);
                this.male.setSelected(false);
                this.female.setSelected(false);
                this.bldgrp.setSelectedItem(null);
            }
            catch(Exception e){
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
        new addDetails();
    }
}
