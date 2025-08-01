package university.management;

import javax.swing.*;
import java.awt.*;
import java.sql.*;  // This imports java.sql.SQLException
import java.awt.event.*;

public class StudentFeeForm extends JFrame implements ActionListener {

    Choice crollNum;
    JComboBox<String> cbcourse, cbsemester;
    JLabel labeltotal, labelname, labelfathername;
    JButton update, pay, back;

    StudentFeeForm() {
        setSize(900, 500);
        setLocation(300, 100);
        setLayout(null);
        setTitle("Student Fee Payment Form");

        getContentPane().setBackground(Color.WHITE);

        // Load and display image
        try {
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
            Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(400, 50, 500, 300);
            add(image);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading image", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Roll Number Selection
        JLabel lblrollNum = new JLabel("Select Roll No");
        lblrollNum.setBounds(40, 60, 150, 20);
        lblrollNum.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblrollNum);

        crollNum = new Choice();
        crollNum.setBounds(200, 60, 150, 20);
        add(crollNum);

        // Fetch roll numbers from students table
        try {
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("SELECT rollNum FROM students");
            while (rs.next()) {
                crollNum.add(rs.getString("rollNum"));
            }
            rs.close();
        } catch (Exception e) {  // Changed from SQLException to Exception
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading student data", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Student Name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 100, 150, 20);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(200, 100, 150, 20);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelname);

        // Father's Name
        JLabel lblfathername = new JLabel("Father's Name");
        lblfathername.setBounds(40, 140, 150, 20);
        lblfathername.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblfathername);

        labelfathername = new JLabel();
        labelfathername.setBounds(200, 140, 150, 20);
        labelfathername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelfathername);

        // Update student details when roll number changes
        crollNum.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn con = new Conn();
                    String query = "SELECT * FROM students WHERE rollNum='" + crollNum.getSelectedItem() + "'";
                    ResultSet rs = con.s.executeQuery(query);
                    if (rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfathername.setText(rs.getString("fathername"));
                    }
                    rs.close();
                } catch (Exception e) {  // Changed from SQLException to Exception
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error loading student details", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Course Selection
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(40, 180, 150, 20);
        lblcourse.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblcourse);

        String courses[] = {"BSc IN CSE", "BSc IN EEE", "BSc IN SWE", "LAW", "English", "BBA", "Economics"};
        cbcourse = new JComboBox<>(courses);
        cbcourse.setBounds(200, 180, 150, 20);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        // Semester Selection
        JLabel lblsemester = new JLabel("Semester");
        lblsemester.setBounds(40, 220, 150, 20);
        lblsemester.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblsemester);

        String semesters[] = {"semester1", "semester2", "semester3", "semester4", 
                            "semester5", "semester6", "semester7", "semester8"};
        cbsemester = new JComboBox<>(semesters);
        cbsemester.setBounds(200, 220, 150, 20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);

        // Total Payable
        JLabel lbltotal = new JLabel("Total Payable");
        lbltotal.setBounds(40, 260, 150, 20);
        lbltotal.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbltotal);

        labeltotal = new JLabel();
        labeltotal.setBounds(200, 260, 150, 20);
        labeltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labeltotal);

        // Buttons
        update = new JButton("Update");
        update.setBounds(30, 320, 100, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        pay = new JButton("Pay Fee");
        pay.setBounds(150, 320, 100, 30);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Back");
        back.setBounds(270, 320, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            
            if (course == null || semester == null) {
                JOptionPane.showMessageDialog(null, "Please select both course and semester", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            try {
                Conn con = new Conn();
                ResultSet rs = con.s.executeQuery("SELECT * FROM fee WHERE Program = '" + course + "'");
                if (rs.next()) {
                    String fee = rs.getString(semester);
                    if (fee == null || fee.trim().isEmpty()) {
                        labeltotal.setText("N/A");
                        JOptionPane.showMessageDialog(null, "Fee not available for this semester", "Information", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        labeltotal.setText(fee);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Fee structure not found for selected course", "Error", JOptionPane.ERROR_MESSAGE);
                }
                rs.close();
            } catch (Exception e) {  // Changed from SQLException to Exception
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error updating fee information", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (ae.getSource() == pay) {
            String rollNum = crollNum.getSelectedItem();
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            String total = labeltotal.getText();

            if (rollNum == null || rollNum.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select a student", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (total == null || total.trim().isEmpty() || total.equals("N/A")) {
                JOptionPane.showMessageDialog(null, "Please update the fee first", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                Conn con = new Conn();
                // Check if fee already paid for this semester
                ResultSet rs = con.s.executeQuery("SELECT * FROM collegefee WHERE rollNum = '" + rollNum + 
                                               "' AND semester = '" + semester + "'");
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Fee already paid for this semester", "Warning", JOptionPane.WARNING_MESSAGE);
                    rs.close();
                    return;
                }
                rs.close();
                
                // Insert payment record
                String query = "INSERT INTO collegefee (rollNum, course, semester, total) VALUES ('" + 
                              rollNum + "', '" + course + "', '" + semester + "', '" + total + "')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Fee payment submitted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
            } catch (Exception e) {  // Changed from SQLException to Exception
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error submitting fee payment", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentFeeForm();
    }
}