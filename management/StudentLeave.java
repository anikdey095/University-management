package university.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentLeave extends JFrame implements ActionListener {
    JTextField tfName, tfRoll, tfReason;
    JButton btnSubmit, btnCancel;

    StudentLeave() {
        setTitle("Student Leave Application");
        setSize(500, 400);
        setLocation(550, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel heading = new JLabel("Apply Leave (Student):");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 10, 300, 30);
        add(heading);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(50, 60, 100, 30);
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(180, 60, 200, 30);
        add(tfName);

        JLabel lblRoll = new JLabel("Roll No:");
        lblRoll.setBounds(50, 100, 100, 30);
        add(lblRoll);

        tfRoll = new JTextField();
        tfRoll.setBounds(180, 100, 200, 30);
        add(tfRoll);

        JLabel lblReason = new JLabel("Reason:");
        lblReason.setBounds(50, 140, 100, 30);
        add(lblReason);

        tfReason = new JTextField();
        tfReason.setBounds(180, 140, 200, 30);
        add(tfReason);

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(100, 200, 100, 30);
        btnSubmit.addActionListener(this);
        add(btnSubmit);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(250, 200, 100, 30);
        btnCancel.addActionListener(this);
        add(btnCancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            String name = tfName.getText();
            String rollNum = tfRoll.getText();
            String reason = tfReason.getText();
            //JOptionPane.showMessageDialog(this, "Leave applied for " + name + " (Roll: " + roll + ")");
             String query = "INSERT INTO student_leave (rollNum, name, reason) VALUES ('" + rollNum + "', '" + name + "', '" + reason + "')";
             try{
                 Conn con=new Conn();
                 con.s.executeUpdate(query);
                  JOptionPane.showMessageDialog(this, "Leave applied for " + name + " (Roll: " + rollNum + ")");
             setVisible(false);
                 
             }catch(Exception ae)
             {
                 ae.printStackTrace();
             }
        } else if (e.getSource() == btnCancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentLeave();
    }
}
