package university.management;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Marks extends JFrame implements ActionListener {

    String rollNum;
    JButton cancel;

    Marks(String rollno) {
        this.rollNum = rollno; // ✅ Corrected bug

        setSize(500, 600);
        setLocation(500, 100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("ABC University");
        heading.setBounds(100, 10, 500, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel subheading = new JLabel("Result of Examination 2025");
        subheading.setBounds(100, 50, 500, 20);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(subheading);

        JLabel lblrollNum = new JLabel("Roll Number: " + rollNum);
        lblrollNum.setBounds(60, 100, 500, 20);
        lblrollNum.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollNum);

        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(60, 130, 500, 20);
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsemester);

        JLabel[] subjects = new JLabel[5];
        for (int i = 0; i < 5; i++) {
            subjects[i] = new JLabel();
            subjects[i].setBounds(100, 200 + i * 30, 500, 20);
            subjects[i].setFont(new Font("Tahoma", Font.PLAIN, 18));
            add(subjects[i]);
        }

        try {
            Conn con = new Conn();

            String query = "SELECT s.semester, s.subject1, s.subject2, s.subject3, s.subject4, s.subject5, " +
                           "m.marks1, m.marks2, m.marks3, m.marks4, m.marks5 " +
                           "FROM subject s INNER JOIN marks m ON s.rollNum = m.rollNum AND s.semester = m.semester " +
                           "WHERE s.rollNum = '" + rollNum + "'";

            ResultSet rs = con.s.executeQuery(query);

            if (rs.next()) {
                lblsemester.setText("Semester: " + rs.getString("semester"));
                subjects[0].setText(rs.getString("subject1") + " -------- " + rs.getString("marks1"));
                subjects[1].setText(rs.getString("subject2") + " -------- " + rs.getString("marks2"));
                subjects[2].setText(rs.getString("subject3") + " -------- " + rs.getString("marks3"));
                subjects[3].setText(rs.getString("subject4") + " -------- " + rs.getString("marks4"));
                subjects[4].setText(rs.getString("subject5") + " -------- " + rs.getString("marks5"));
            } else {
                JOptionPane.showMessageDialog(null, "Result not found for Roll No: " + rollNum);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        cancel = new JButton("Back");
        cancel.setBounds(250, 500, 120, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new Marks(""); // for testing
    }
}
