package university.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TeacherLeave extends JFrame implements ActionListener {
    JTextField tfName, tfEmpId, tfReason;
    JButton btnSubmit, btnCancel;

    TeacherLeave() {
        setTitle("Teacher Leave Application");
        setSize(500, 400);
        setLocation(550, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel heading = new JLabel("Apply Leave (Teacher):");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 10, 300, 30);
        add(heading);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(50, 60, 100, 30);
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(180, 60, 200, 30);
        add(tfName);

        JLabel lblEmpId = new JLabel("Emp ID:");
        lblEmpId.setBounds(50, 100, 100, 30);
        add(lblEmpId);

        tfEmpId = new JTextField();
        tfEmpId.setBounds(180, 100, 200, 30);
        add(tfEmpId);

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
            String empId = tfEmpId.getText();
            String reason = tfReason.getText();

         

            try {
//                Conn con = new Conn();
               String query = "INSERT INTO teacher_leave (empId, name, reason) VALUES ('"+empId+"', '"+name+"', '"+reason+"')";
//                PreparedStatement pstmt = con.c.prepareStatement(query);
//                pstmt.setString(1, empid);
//                pstmt.setString(2, name);
//                pstmt.setString(3, reason);
//
//                int inserted = pstmt.executeUpdate();
//                if (inserted > 0) {
//                    JOptionPane.showMessageDialog(this, "Leave applied for " + name + " (EmpId: " + empid + ")");
//                } else {
//                    JOptionPane.showMessageDialog(this, "Failed to apply leave.", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//
//                // Close connection
//                pstmt.close();
//                con.c.close();
//                
//                setVisible(false);
                
                
                Conn con=new Conn();
                 con.s.executeUpdate(query);
                  JOptionPane.showMessageDialog(this, "Leave applied for " + name + " (Roll: " + empId + ")");
             setVisible(false);
                
                        
            } catch (Exception ae) {
                ae.printStackTrace();
               // JOptionPane.showMessageDialog(this, "Database error: " + ae.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnCancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherLeave();
    }
}
