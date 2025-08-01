package university.management;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class StudentDetails extends JFrame implements ActionListener{
    Choice crollnum;
    JTable table;
    JButton search,print,update,add,cancel;

    StudentDetails() {
        setTitle("Student Details");
        getContentPane().setBackground(Color.white);
        setLayout(null);

        // Label for Roll Number Search
        JLabel heading = new JLabel("Search by Roll Number:");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        // Dropdown Choice for Roll Numbers
        crollnum = new Choice();
        crollnum.setBounds(180, 20, 150, 20);
        add(crollnum);

        try {
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                crollnum.add(rs.getString("rollnum"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Table Initialization
        table = new JTable();
        try {
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("SELECT * FROM students");
            table.setModel(DbUtils.resultSetToTableModel(rs)); // Fix: Set model once, not inside a loop
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Adding ScrollPane for Table
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 500);
        add(jsp);
        
        //search
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        
        //print   
        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
        //add
           
        add = new JButton("Add");
        add.setBounds(220,70,80,20);
        add.addActionListener(this);
        add(add);
        
        
        //update
           
        update = new JButton("Update");
        update.setBounds(320,70,80,20);
        update.addActionListener(this);
        add(update);
        
        //cancel
         cancel = new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);
        
        

        // Frame settings
        setSize(900, 850);
        setLocation(300, 100);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query="select*from students where rollNum ='"+crollnum.getSelectedItem()+"'";
            try{
                Conn con=new Conn();
                ResultSet rs=con.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==print){
            try{
                table.print ();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==add){
            //if we want to add details or student we need open addstudent page so 
            //close this page
            setVisible(false);
            new AddStudent();
            
        }else if(ae.getSource()==update){
              setVisible(false);
            new UpdateStudentDetails();
            
        }else if(ae.getSource()==cancel){
            setVisible(false);
            
        }
        
    }

    public static void main(String[] args) {
        new StudentDetails();
    }
}
