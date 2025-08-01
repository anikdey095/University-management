package university.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EnterMarks extends JFrame implements ActionListener {

    Choice crollNum;
    JComboBox<String> cbsemester;
    JTextField tfsub1, tfsub2, tfsub3, tfsub4, tfsub5, tfmarks1, tfmarks2, tfmarks3, tfmarks4, tfmarks5;
    JButton cancel, submit;

    EnterMarks() {
        setSize(1000, 500);
        setLocation(300, 150);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 40, 400, 300);
        add(image);

        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel lblrollNum = new JLabel("Select Roll Number");
        lblrollNum.setBounds(50, 70, 150, 20);
        add(lblrollNum);

        crollNum = new Choice();
        crollNum.setBounds(200, 70, 150, 20);
        add(crollNum);

        try {
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("SELECT rollNum FROM students");
            while (rs.next()) {
                crollNum.add(rs.getString("rollNum"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(50, 110, 150, 20);
        add(lblsemester);

        String[] semester = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester"};
        cbsemester = new JComboBox<>(semester);
        cbsemester.setBounds(200, 110, 150, 20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);

        JLabel lblentersubject = new JLabel("Enter Subject");
        lblentersubject.setBounds(100, 150, 200, 40);
        add(lblentersubject);

        JLabel lblentermarks = new JLabel("Enter Credits");
        lblentermarks.setBounds(320, 150, 200, 40);
        add(lblentermarks);

        tfsub1 = new JTextField(); tfsub2 = new JTextField(); tfsub3 = new JTextField(); tfsub4 = new JTextField(); tfsub5 = new JTextField();
        tfmarks1 = new JTextField(); tfmarks2 = new JTextField(); tfmarks3 = new JTextField(); tfmarks4 = new JTextField(); tfmarks5 = new JTextField();

        int y = 200;
        for (int i = 0; i < 5; i++, y += 30) {
            JTextField subject = new JTextField();
            JTextField mark = new JTextField();

            switch (i) {
                case 0 -> { tfsub1.setBounds(50, y, 200, 20); add(tfsub1); tfmarks1.setBounds(250, y, 200, 20); add(tfmarks1); }
                case 1 -> { tfsub2.setBounds(50, y, 200, 20); add(tfsub2); tfmarks2.setBounds(250, y, 200, 20); add(tfmarks2); }
                case 2 -> { tfsub3.setBounds(50, y, 200, 20); add(tfsub3); tfmarks3.setBounds(250, y, 200, 20); add(tfmarks3); }
                case 3 -> { tfsub4.setBounds(50, y, 200, 20); add(tfsub4); tfmarks4.setBounds(250, y, 200, 20); add(tfmarks4); }
                case 4 -> { tfsub5.setBounds(50, y, 200, 20); add(tfsub5); tfmarks5.setBounds(250, y, 200, 20); add(tfmarks5); }
            }
        }

        submit = new JButton("Submit");
        submit.setBounds(70, 360, 150, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Back");
        cancel.setBounds(280, 360, 150, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                Conn con = new Conn();

                String query1 = "INSERT INTO subject VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt1 = con.con.prepareStatement(query1);
                pstmt1.setString(1, crollNum.getSelectedItem());
                pstmt1.setString(2, cbsemester.getSelectedItem().toString());
                pstmt1.setString(3, tfsub1.getText());
                pstmt1.setString(4, tfsub2.getText());
                pstmt1.setString(5, tfsub3.getText());
                pstmt1.setString(6, tfsub4.getText());
                pstmt1.setString(7, tfsub5.getText());
                pstmt1.executeUpdate();

                String query2 = "INSERT INTO marks VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt2 = con.con.prepareStatement(query2);
                pstmt2.setString(1, crollNum.getSelectedItem());
                pstmt2.setString(2, cbsemester.getSelectedItem().toString());
                pstmt2.setInt(3, Integer.parseInt(tfmarks1.getText().isEmpty() ? "0" : tfmarks1.getText()));
                pstmt2.setInt(4, Integer.parseInt(tfmarks2.getText().isEmpty() ? "0" : tfmarks2.getText()));
                pstmt2.setInt(5, Integer.parseInt(tfmarks3.getText().isEmpty() ? "0" : tfmarks3.getText()));
                pstmt2.setInt(6, Integer.parseInt(tfmarks4.getText().isEmpty() ? "0" : tfmarks4.getText()));
                pstmt2.setInt(7, Integer.parseInt(tfmarks5.getText().isEmpty() ? "0" : tfmarks5.getText()));
                pstmt2.executeUpdate();

                JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EnterMarks();
    }
}