package university.management;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class Project extends JFrame implements ActionListener {
    Project() {
        setTitle("University Management System");
        setSize(1920, 1080); // Laptop display size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1880, 980, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        setLayout(new BorderLayout());
        add(image, BorderLayout.CENTER);

        // Menu bar
        JMenuBar mb = new JMenuBar();

        // New Information
        JMenu newInformation = new JMenu("New Information");
        mb.add(newInformation);

        JMenuItem newDeptInfo = new JMenuItem("New Department Information");
        newDeptInfo.addActionListener(this);
        newInformation.add(newDeptInfo);

        JMenuItem newStudentInfo = new JMenuItem("New Student Information");
        newStudentInfo.addActionListener(this);
        newInformation.add(newStudentInfo);

        // View Details
        JMenu details = new JMenu("View Details");
        mb.add(details);

        JMenuItem viewDeptInfo = new JMenuItem("View Department Details");
        viewDeptInfo.addActionListener(this);
        details.add(viewDeptInfo);

        JMenuItem viewStudentInfo = new JMenuItem("View Student Details");
        viewStudentInfo.addActionListener(this);
        details.add(viewStudentInfo);

        // Apply Leave
        JMenu leave = new JMenu("Apply Leave");
        mb.add(leave);

        JMenuItem teacherLeave = new JMenuItem("Teacher Leave");
        teacherLeave.addActionListener(this);
        leave.add(teacherLeave);

        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        // Leave Details
        JMenu leaveDetails = new JMenu("Leave Details");
        mb.add(leaveDetails);

        JMenuItem teacherLeaveDetails = new JMenuItem("Teacher Leave Details");
        teacherLeaveDetails.addActionListener(this);
        leaveDetails.add(teacherLeaveDetails);

        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);

        // Examination
        JMenu exam = new JMenu("Examination");
        mb.add(exam);

        JMenuItem examinationDetails = new JMenuItem("Examination Result");
        examinationDetails.addActionListener(this);
        exam.add(examinationDetails);

        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        enterMarks.addActionListener(this);
        exam.add(enterMarks);

        // Update Info
        JMenu updateInfo = new JMenu("Update Info");
        mb.add(updateInfo);

        JMenuItem updateDeptInfo = new JMenuItem("Update Department Information");
        updateDeptInfo.addActionListener(this);
        updateInfo.add(updateDeptInfo);

        JMenuItem updateStudentInfo = new JMenuItem("Update Student Information");
        updateStudentInfo.addActionListener(this);
        updateInfo.add(updateStudentInfo);

        // Fee Details
        JMenu fee = new JMenu("Fee Details");
        mb.add(fee);

        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.addActionListener(this);
        fee.add(feeStructure);

        JMenuItem feeForm = new JMenuItem("Fee Form");
        feeForm.addActionListener(this);
        fee.add(feeForm);

        // Utility
        JMenu utility = new JMenu("Utility");
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.addActionListener(this);
        utility.add(calc);

        // About Section
        JMenu about = new JMenu("About");
        mb.add(about);

        JMenuItem aboutItem = new JMenuItem("About"); // Renamed to 'aboutItem'
        aboutItem.addActionListener(this);
        about.add(aboutItem);

        // Exit
        JMenu exit = new JMenu("Exit");
        mb.add(exit);

        JMenuItem ex = new JMenuItem("Exit");
        ex.addActionListener(this);
        exit.add(ex);

        setJMenuBar(mb);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        if (msg.equals("Exit")) {
            System.exit(0); // Proper exit
        } else if (msg.equals("Calculator")) {
            openApplication("calc.exe");
        } else if (msg.equals("Notepad")) {
            openApplication("notepad.exe");
        } else if (msg.equals("New Department Information")) {
            new AddTeacher(); // Ensure class exists
        } else if (msg.equals("New Student Information")) {
            new AddStudent(); // Ensure class exists
        } else if (msg.equals("View Department Details")) {
            new TeacherDetails(); // Ensure class exists
        } else if (msg.equals("View Student Details")) {
            new StudentDetails(); // Ensure class exists
        } else if (msg.equals("Student Leave")) {
            new StudentLeave(); // Ensure class exists
        } else if (msg.equals("Teacher Leave")) {
            new TeacherLeave(); // Ensure class exists
        } else if (msg.equals("Teacher Leave Details")) {
            new TeacherLeaveDetails(); // Ensure class exists
        } else if (msg.equals("Student Leave Details")) {
            new StudentLeaveDetails(); // Ensure class exists
        } else if (msg.equals("Update Department Information")) {
            new UpdateTeacherDetails(); // Ensure class exists
        } else if (msg.equals("Update Student Information")) {
            new UpdateStudentDetails(); // Ensure class exists
        } else if (msg.equals("Enter Marks")) {
            new EnterMarks(); // Ensure class exists
        } else if (msg.equals("Examination Result")) {
        new ExaminationDetails();  
        }else if (msg.equals("Fee Structure")) {
        new FeeStructure();  
        }else if (msg.equals("Fee Form")) {
        new StudentFeeForm();  
        }else if (msg.equals("About")) {
        new About();  
        }
    }

    private void openApplication(String app) {
        try {
            Runtime.getRuntime().exec(app);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error opening " + app, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Project();
    }
}