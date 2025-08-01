package university.management;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTeacher extends JFrame implements ActionListener {
    JTextField tfname, tffathername, tfphone, tfaddress, tfemail, tfsscResult, tfhscResult, tfnidCard;
    JLabel labelEmpId;
    JDateChooser dcdob;
    JComboBox<String> cbProgram, cbbloodgroup;
    JButton submit, cancel;

   Random ran = new Random();
long empId = Math.abs(ran.nextLong() % 900L) + 100L; // Auto-generated Emp ID

AddTeacher() {
    // Frame setup
    setSize(850, 750);
    setLocation(350, 50);
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Heading
    JLabel heading = new JLabel("New Teacher Details");
    heading.setBounds(310, 30, 500, 50);
    heading.setFont(new Font("Tahoma", Font.BOLD, 24));
    add(heading);

    // Name Label and TextField
    JLabel lblname = new JLabel("Name:");
    lblname.setBounds(50, 100, 150, 30);
    lblname.setFont(new Font("Serif", Font.BOLD, 20));
    add(lblname);

    tfname = new JTextField();
    tfname.setBounds(200, 100, 200, 30);
    add(tfname);

    // Father's Name Label and TextField
    JLabel lblfname = new JLabel("Father's Name:");
    lblfname.setBounds(450, 100, 150, 30);
    lblfname.setFont(new Font("Serif", Font.BOLD, 20));
    add(lblfname);

    tffathername = new JTextField();
    tffathername.setBounds(600, 100, 200, 30);
    add(tffathername);

    // Emp ID Label and Auto-generated Emp ID
    JLabel lblrollNum = new JLabel("Emp ID: ");
    lblrollNum.setBounds(50, 140, 150, 30);
    lblrollNum.setFont(new Font("Serif", Font.BOLD, 20));
    add(lblrollNum);

    labelEmpId = new JLabel(String.valueOf("AB"+empId)); // Auto-generated Emp ID
    labelEmpId.setBounds(200, 140, 200, 30);
    labelEmpId.setFont(new Font("Serif", Font.BOLD, 20));
    add(labelEmpId);

    // Date of Birth Label and Date Picker
    JLabel lbldob = new JLabel("Date of Birth:");
    lbldob.setBounds(450, 140, 150, 30);
    lbldob.setFont(new Font("Serif", Font.BOLD, 20));
    add(lbldob);

    dcdob = new JDateChooser();
    dcdob.setBounds(600, 140, 200, 30);
    add(dcdob);

    // Phone Number Label and TextField
    JLabel lblphone = new JLabel("Phone Number:");
    lblphone.setBounds(50, 180, 150, 30);
    lblphone.setFont(new Font("Serif", Font.BOLD, 20));
    add(lblphone);

    tfphone = new JTextField();
    tfphone.setBounds(200, 180, 200, 30);
    add(tfphone);

    // Address Label and TextField
    JLabel lbladdress = new JLabel("Address:");
    lbladdress.setBounds(450, 180, 150, 30);
    lbladdress.setFont(new Font("Serif", Font.BOLD, 20));
    add(lbladdress);

    tfaddress = new JTextField();
    tfaddress.setBounds(600, 180, 200, 30);
    add(tfaddress);

    // Email Label and TextField
    JLabel lblemail = new JLabel("Email:");
    lblemail.setBounds(50, 220, 150, 30);
    lblemail.setFont(new Font("Serif", Font.BOLD, 20));
    add(lblemail);

    tfemail = new JTextField();
    tfemail.setBounds(200, 220, 200, 30);
    add(tfemail);

    // B.Sc Result Label and TextField
    JLabel lblsscResult = new JLabel("B.Sc Result:");
    lblsscResult.setBounds(450, 220, 150, 30);
    lblsscResult.setFont(new Font("Serif", Font.BOLD, 20));
    add(lblsscResult);

    tfsscResult = new JTextField();
    tfsscResult.setBounds(600, 220, 80, 30);
    add(tfsscResult);

    // M.Sc Result Label and TextField
    JLabel lblhscResult = new JLabel("M.Sc Result:");
    lblhscResult.setBounds(450, 260, 150, 30);
    lblhscResult.setFont(new Font("Serif", Font.BOLD, 20));
    add(lblhscResult);

    tfhscResult = new JTextField();
    tfhscResult.setBounds(600, 260, 80, 30);
    add(tfhscResult);

    // NID Card Label and TextField
    JLabel lblNidCard = new JLabel("NID Card:");
    lblNidCard.setBounds(50, 260, 150, 30);
    lblNidCard.setFont(new Font("Serif", Font.BOLD, 20));
    add(lblNidCard);

    tfnidCard = new JTextField();
    tfnidCard.setBounds(200, 260, 200, 30);
    add(tfnidCard);

    // Program Label and ComboBox
    JLabel lblProgram = new JLabel("Program:");
    lblProgram.setBounds(50, 320, 150, 30);
    lblProgram.setFont(new Font("Serif", Font.BOLD, 20));
    add(lblProgram);

    String[] program = {"Dept of CSE", "Dept of EEE", "BBA", "Dept of Economics"};
    cbProgram = new JComboBox<>(program);
    cbProgram.setBounds(200, 320, 250, 30);
    add(cbProgram);

    // Blood Group Label and ComboBox
    JLabel lblBlood = new JLabel("Blood Group:");
    lblBlood.setBounds(50, 360, 150, 30);
    lblBlood.setFont(new Font("Serif", Font.BOLD, 20));
    add(lblBlood);

    String[] blood = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
    cbbloodgroup = new JComboBox<>(blood);
    cbbloodgroup.setBounds(200, 360, 80, 30);
    add(cbbloodgroup);

    // Submit and Cancel Buttons
    submit = new JButton("Submit");
    submit.setBounds(280, 450, 120, 40);
    submit.setBackground(Color.BLACK);
    submit.setForeground(Color.WHITE);
    submit.addActionListener(this);
    submit.setFont(new Font("Tahoma", Font.BOLD, 15));
    add(submit);

    cancel = new JButton("Cancel");
    cancel.setBounds(450, 450, 120, 40);
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.WHITE);
    cancel.addActionListener(this);
    add(cancel);

    setVisible(true);
}

@Override
public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == submit) {
        // Collect data from form fields
        String name = tfname.getText();
        String fathername = tffathername.getText();
        String empId = labelEmpId.getText();
        String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String email = tfemail.getText();
        String bscResult = tfsscResult.getText();
        String mscResult = tfhscResult.getText();
        String nidCard = tfnidCard.getText();
        String program = (String) cbProgram.getSelectedItem();
        String blood = (String) cbbloodgroup.getSelectedItem();

        // Database insertion query
        try {
           String query = "INSERT INTO teachers (EmpId, name, fathername, dob, phone, address, email, nidCard, program, blood, bscresult, mscresult) " +
               "VALUES ('" + empId + "','" + name + "','" + fathername + "','" + dob + "','" + phone + "','" + address + "','" + email + "', '" + nidCard + "','" + program + "','" + blood + "','" + bscResult + "','" + mscResult + "')"; 
           Conn con = new Conn();
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
            setVisible(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } else if (ae.getSource() == cancel) {
        setVisible(false);
    }
}

public static void main(String[] args) {
    new AddTeacher();
}
}