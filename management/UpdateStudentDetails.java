package university.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudentDetails extends JFrame implements ActionListener {

    JTextField tfaddress, tfphone, tfemail;
    JLabel labelrollNum, labelbloodgroup;
    JLabel labelname, labelfathername, labeldob;
    JButton submit, cancel;
    Choice crollNum;
    JComboBox<String> cbProgram;

    UpdateStudentDetails() {

        setSize(1200, 700);
        setLocation(350, 50);
        setLayout(null);

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 35));
        add(heading);

        JLabel lblrollNum = new JLabel("Select Roll Number");
        lblrollNum.setBounds(50, 100, 200, 20);
        lblrollNum.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblrollNum);

        crollNum = new Choice();
        crollNum.setBounds(250, 100, 200, 20);
        add(crollNum);

        try {
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                String roll = rs.getString("rollNum");
                crollNum.add(roll);
                System.out.println("Loaded rollNum: " + roll);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 300, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(200, 150, 300, 30);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelname);

        JLabel lblfathername = new JLabel("Father's Name");
        lblfathername.setBounds(550, 150, 200, 30);
        lblfathername.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfathername);

        labelfathername = new JLabel();
        labelfathername.setBounds(800, 150, 150, 30);
        labelfathername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelfathername);

        JLabel lblroll = new JLabel("Roll Number");
        lblroll.setBounds(50, 200, 200, 30);
        lblroll.setFont(new Font("serif", Font.BOLD, 20));
        add(lblroll);

        labelrollNum = new JLabel();
        labelrollNum.setBounds(200, 200, 200, 30);
        labelrollNum.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelrollNum);

        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(550, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);

        labeldob = new JLabel();
        labeldob.setBounds(800, 200, 150, 30);
        labeldob.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labeldob);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(550, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(800, 250, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 200, 30);
        add(tfemail);

        JLabel lblblood = new JLabel("Blood Group");
        lblblood.setBounds(550, 300, 200, 30);
        lblblood.setFont(new Font("serif", Font.BOLD, 20));
        add(lblblood);

        labelbloodgroup = new JLabel();
        labelbloodgroup.setBounds(800, 300, 300, 30);
        labelbloodgroup.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelbloodgroup);

        JLabel lblProgram = new JLabel("Program");
        lblProgram.setBounds(50, 350, 200, 30);
        lblProgram.setFont(new Font("serif", Font.BOLD, 20));
        add(lblProgram);

        String[] Program = {
            "B.Sc. in Computer Science & Engineering",
            "B.Sc. in EEE",
            "B.Sc. in Software Engineering",
            "BSS in Economics",
            "LL.B. (Hons.)",
            "BBA",
            "B.A. (Hons.) in English"
        };
        cbProgram = new JComboBox<>(Program);
        cbProgram.setBounds(200, 350, 300, 30);
        add(cbProgram);

        crollNum.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                loadStudentDetails(crollNum.getSelectedItem());
            }
        });

        // Initial trigger for first item
        if (crollNum.getItemCount() > 0) {
            loadStudentDetails(crollNum.getItem(0));
        }

        submit = new JButton("Update");
        submit.setBounds(250, 500, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 500, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    void loadStudentDetails(String rollNum) {
        try {
            Conn con = new Conn();
            String query = "SELECT * FROM students WHERE rollNum='" + rollNum + "'";
            ResultSet rs = con.s.executeQuery(query);

            if (rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfathername.setText(rs.getString("fathername"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelrollNum.setText(rs.getString("rollNum"));
                cbProgram.setSelectedItem(rs.getString("Program"));
                labelbloodgroup.setText(rs.getString("blood"));
                System.out.println("Loaded student data for: " + rollNum);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String rollNum = labelrollNum.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String Program = (String) cbProgram.getSelectedItem();

            try {
                String query = "UPDATE students SET address='" + address + "', phone='" + phone + "', email='" + email + "', Program='" + Program + "' WHERE rollNum='" + rollNum + "'";
                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateStudentDetails();
    }
}
