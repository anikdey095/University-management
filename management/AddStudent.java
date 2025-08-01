package university.management;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudent extends JFrame implements ActionListener {
    JTextField tfname, tffathername, tfphone, tfaddress, tfemail, tfsscResult, tfhscResult, tfnidCard;
    JLabel labelrollNum;
    JDateChooser dcdob;
    JComboBox<String> cbProgram, cbbloodgroup; 
    JButton submit, cancel;  

    Random ran = new Random();
    long first4 = Math.abs(ran.nextLong() % 900L) + 100L;

    AddStudent() {
        // Frame setup
        setSize(850, 700);  
        setLocation(350, 50);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Heading
        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        add(heading);

        // Name Field
        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(50, 100, 150, 30);
        lblname.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 100, 200, 30);
        add(tfname);

        // Father's Name Field
        JLabel lblfname = new JLabel("Father's Name:");
        lblfname.setBounds(450, 100, 150, 30);
        lblfname.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblfname);

        tffathername = new JTextField();
        tffathername.setBounds(600, 100, 200, 30);
        add(tffathername);

        // Roll Number Field
        JLabel lblrollNum = new JLabel("Roll Number:");
        lblrollNum.setBounds(50, 140, 150, 30);
        lblrollNum.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblrollNum);

        labelrollNum = new JLabel("111-222-" + first4);
        labelrollNum.setBounds(200, 140, 150, 30);
        labelrollNum.setFont(new Font("Serif", Font.BOLD, 20));
        add(labelrollNum);

        // Date of Birth Field
        JLabel lbldob = new JLabel("Date of Birth:");
        lbldob.setBounds(450, 140, 150, 30);
        lbldob.setFont(new Font("Serif", Font.BOLD, 20));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(600, 140, 200, 30);
        add(dcdob);

        // Phone Number Field
        JLabel lblphone = new JLabel("Phone Number:");
        lblphone.setBounds(50, 180, 150, 30);
        lblphone.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 180, 200, 30);
        add(tfphone);

        // Address Field
        JLabel lbladdress = new JLabel("Address:");
        lbladdress.setBounds(450, 180, 150, 30);
        lbladdress.setFont(new Font("Serif", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(600, 180, 200, 30);
        add(tfaddress);

        // Email Field
        JLabel lblemail = new JLabel("Email:");
        lblemail.setBounds(50, 220, 150, 30);
        lblemail.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 220, 200, 30);
        add(tfemail);

        // SSC Result Field
        JLabel lblsscResult = new JLabel("SSC Result:");
        lblsscResult.setBounds(450, 220, 150, 30);
        lblsscResult.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblsscResult);

        tfsscResult = new JTextField();
        tfsscResult.setBounds(600, 220, 80, 30);
        add(tfsscResult);

        // HSC Result Field
        JLabel lblhscResult = new JLabel("HSC Result:");
        lblhscResult.setBounds(450, 260, 150, 30);
        lblhscResult.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblhscResult);

        tfhscResult = new JTextField();
        tfhscResult.setBounds(600, 260, 80, 30);
        add(tfhscResult);

        // NID Card Field
        JLabel lblNidCard = new JLabel("NID Card:");
        lblNidCard.setBounds(50, 260, 150, 30);
        lblNidCard.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblNidCard);

        tfnidCard = new JTextField();
        tfnidCard.setBounds(200, 260, 200, 30);
        add(tfnidCard);

        // Program Dropdown
        JLabel lblProgram = new JLabel("Program:");
        lblProgram.setBounds(50, 320, 150, 30);
        lblProgram.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblProgram);
        
        
        String[] program = {"B.Sc. in Computer Science & Engineering", "B.Sc. in EEE", "B.Sc. in Software Engineering", "BSS in Economics", "LL.B. (Hons.)", "BBA", "B.A. (Hons.) in English"};
        cbProgram = new JComboBox<>(program);
        cbProgram.setBounds(200, 320, 250, 30);
        add(cbProgram);

      

        // Blood Group Dropdown
        JLabel lblBlood = new JLabel("Blood Group:");
        lblBlood.setBounds(50, 360, 150, 30);
        lblBlood.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblBlood);

        String[] blood = {"A+", "B+", "AB+", "O+"};
        cbbloodgroup = new JComboBox<>(blood);
        cbbloodgroup.setBounds(200, 360, 80, 30);
        add(cbbloodgroup);

        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(280, 450, 120, 40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 450, 120, 40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = tfname.getText();
            String fathername = tffathername.getText();
            String rollNum = labelrollNum.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String phone = tfphone.getText();
            String address = tfaddress.getText();
            String email = tfemail.getText();
            String sscResult = tfsscResult.getText();
            String hscResult = tfhscResult.getText();
            String nidCard = tfnidCard.getText();
            String program = (String) cbProgram.getSelectedItem();
            String blood = (String) cbbloodgroup.getSelectedItem();

            try {
                String query = "INSERT INTO students (name, fathername, rollnum, dob, phone, address, email, sscResult, hscResult, nidCard, program, blood) " +
                               "VALUES ('" + name + "','" + fathername + "','" + rollNum + "','" + dob + "','" + phone + "','" + address + "','" + email + "','" + sscResult + "','" + hscResult + "','" + nidCard + "','" + program + "','" + blood + "')";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}