package university.management;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About() {
        setSize(700, 500);
        setLocation(400, 150);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Heading text
        JLabel heading = new JLabel("<html>University Management System</html>");
        heading.setBounds(70, 20, 300, 130);
        heading.setFont(new Font("Tahoma",Font.ITALIC, 15));
        add(heading);
        
        
         JLabel text = new JLabel("The project is made by:");
        text.setBounds(70, 130, 500, 40);
        text.setFont(new Font("Tahoma", Font.ITALIC, 20));
        add(text);

        // Names
        JLabel name = new JLabel("MD Jakuar Hossain Ovi(231-115-090)");
        name.setBounds(70, 200, 500, 40);
        name.setFont(new Font("Tahoma", Font.ITALIC, 20));
        add(name);
        
         JLabel name1 = new JLabel("Anik Dey(231-115-095)");
        name1.setBounds(70, 230, 500, 40);
        name1.setFont(new Font("Tahoma", Font.ITALIC, 20));
        add(name1);
        
         JLabel name2 = new JLabel("Rafi(231-115-109)");
        name2.setBounds(70, 260, 500, 40);
        name2.setFont(new Font("Tahoma", Font.ITALIC, 20));
        add(name2);
        
        
         JLabel name3 = new JLabel("Dibyo Roy(231-115-120)");
        name3.setBounds(70, 290, 500, 40);
        name3.setFont(new Font("Tahoma", Font.ITALIC, 20));
        add(name3);
        
        

        

        setVisible(true);
    }

    public static void main(String[] args) {
        // Make GUI thread-safe
        SwingUtilities.invokeLater(() -> new About());
    }
}