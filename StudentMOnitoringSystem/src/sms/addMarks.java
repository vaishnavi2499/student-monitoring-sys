package sms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class addMarks extends JFrame implements ActionListener {
    int lw = 150 , lh = 50 , tw = 70 , th = 50;
    JLabel l1;
    JTextField gr;
    JButton display , update1 , update2 , home , back;
    JTabbedPane tabs;
    JPanel p1, p2;
    JScrollPane sp1, sp2;
    JTable sem1, sem2;
    JTextField english, maths , marathi , geography , history , science;
    Font f1 = new Font("Tahoma", Font.PLAIN,22);
    Font f2 = new Font("Tahoma", Font.BOLD,24);
    addMarks(){
        setSize(650,800);

        l1 = new JLabel("Enter GR");
        l1.setBounds(120,60,150,50);
        l1.setFont(f1);
        add(l1);

        gr = new JTextField();
        gr.setBounds(250,60,100,50);
        gr.setFont(f1);
        add(gr);

        display = new JButton("Display");
        display.setBounds(400,60,120,50);
        display.setFont(f1);
        display.addActionListener(this);
        add(display);

        tabs = new JTabbedPane();
        tabs.setBounds(50,180,550,550);
        tabs.setFont(f2);
        add(tabs);

        p1 = new JPanel();
        p1.setLayout(null);

        p2 = new JPanel();
        p2.setLayout(null);

        tabs.addTab("SEM 1", p1);
        tabs.addTab("SEM 2", p2);

        sem1 = new JTable();
        sem1.setFont(new Font("Tahoma", Font.PLAIN,20));
        sem1.setRowHeight(30);
        sem2 = new JTable();
        sem2.setFont(new Font("Tahoma", Font.PLAIN,20));
        sem2.setRowHeight(30);

        JTableHeader tb1 = sem1.getTableHeader();
        tb1.setFont(f1);

        JTableHeader tb2 = sem2.getTableHeader();
        tb2.setFont(f1);

        sp1 = new JScrollPane();
        sp1.setBounds(30,40,470,80);
        p1.add(sp1);

        sp2 = new JScrollPane();
        sp2.setBounds(30,40,470,80);
        p2.add(sp2);

        sp1.setViewportView(sem1);
        sp2.setViewportView(sem2);

        JLabel l1 = new JLabel("ENGLISH");
        l1.setBounds(80,180,lw,lh);
        l1.setFont(f1);
        p1.add(l1);

        JLabel l2 = new JLabel("MATHS");
        l2.setBounds(80,240,lw,lh);
        l2.setFont(f1);
        p1.add(l2);

        JLabel l3 = new JLabel("SCIENCE");
        l3.setBounds(80,300,lw,lh);
        l3.setFont(f1);
        p1.add(l3);

        JLabel l4 = new JLabel("GEOGRAPHY");
        l4.setBounds(80,180,lw,lh);
        l4.setFont(f1);
        p2.add(l4);

        JLabel l5 = new JLabel("HISTORY");
        l5.setBounds(80,240,lw,lh);
        l5.setFont(f1);
        p2.add(l5);

        JLabel l6 = new JLabel("MARATHI");
        l6.setBounds(80,300,lw,lh);
        l6.setFont(f1);
        p2.add(l6);


        english = new JTextField();
        english.setBounds(250,180,tw,th);
        english.setFont(f1);
        p1.add(english);

        maths = new JTextField();
        maths.setBounds(250,240,tw,th);
        maths.setFont(f1);
        p1.add(maths);

        science = new JTextField();
        science.setBounds(250,300,tw,th);
        science.setFont(f1);
        p1.add(science);
        
        geography = new JTextField();
        geography.setBounds(250,180,tw,th);
        geography.setFont(f1);
        p2.add(geography);

        history = new JTextField();
        history.setBounds(250,240,tw,th);
        history.setFont(f1);
        p2.add(history);

        marathi = new JTextField();
        marathi.setBounds(250,300,tw,th);
        marathi.setFont(f1);
        p2.add(marathi);

        update1 = new JButton("UPDATE");
        update1.setBounds(190,400,150,50);
        update1.setFont(f1);
        update1.addActionListener(this);
        p1.add(update1);
        
        update2 = new JButton("UPDATE");
        update2.setBounds(190,400,150,50);
        update2.setFont(f1);
        update2.addActionListener(this);
        p2.add(update2);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(60,50,Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        home = new JButton(i6);
        home.setBounds(575,10,50,50);
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
        String gr = this.gr.getText();
        if(ae.getSource() == display){
            conn c = new conn();
            //sem1
            String query1 = "select name , english , maths , science from adddetails where gr='"+gr+"';";

            try{
                ResultSet rs1 = c.s.executeQuery(query1);
                sem1.setModel(DbUtils.resultSetToTableModel(rs1));
            }
            catch(Exception e){
                System.out.println(e);
            }

            //sem2
            String query2 = "select name , history , geography , marathi from adddetails where gr='"+gr+"';";

            try{
                ResultSet rs2 = c.s.executeQuery(query2);
                sem2.setModel(DbUtils.resultSetToTableModel(rs2));
            }
            catch(Exception e){
                System.out.println(e);
            }
        }

        if(ae.getSource() == update1){
            String english = this.english.getText();
            String maths = this.maths.getText();
            String science = this.science.getText();

            conn c = new conn();
            String query1 = "update adddetails set english = '"+english+"', maths = '"+maths+"', science = '"+science+"'  where gr = '"+gr+"';";

            try{
                c.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null,"SEM 1 data updated successfully!!");
            }
            catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"Some error occured!!");
            }
        }

        if(ae.getSource() == update2){
            String history = this.history.getText();
            String marathi = this.marathi.getText();
            String geography = this.geography.getText();

            conn c = new conn();
            String query2 = "update adddetails set history = '"+history+"', geography = '"+geography+"', marathi = '"+marathi+"'  where gr = '"+gr+"';";

            try{
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"SEM 2 data updated successfully!!");
            }
            catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"Some error occured!!");
            }



        }
        this.marathi.setText(null);
        this.maths.setText(null);
        this.science.setText(null);
        this.english.setText(null);
        this.history.setText(null);
        this.geography.setText(null);

        if(ae.getSource() == back){
            new viewMarks();
            this.setVisible(false);
        }
        if(ae.getSource() == home){
            new dashboard();
            this.setVisible(false);
        }





    }

    public static void main(String[] args) {
        new addMarks();
    }
}
