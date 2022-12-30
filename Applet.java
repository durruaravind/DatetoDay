// Applet program
// Run this to get the result

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Applet implements ActionListener 
{
    private TextField t = new TextField();
    private JLabel Inputlabel = new JLabel("ENTER DATE IN 'DD MM YYYY' FORMAT:\n");
    private JLabel Outputlabel = new JLabel("DAY:");
    private JFrame frame = new JFrame();

    public Applet()
    {
        // submit button
        JButton button = new JButton("Submit");
        button.setFocusable(false);
        button.setBackground(new Color(0x009900));
        button.setForeground(Color.white);
        button.setFont(new Font("Courier New", Font.BOLD, 14));
        button.addActionListener(this);

        // the panel with the button and text
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(50, 150, 50, 150));
        panel.add(Inputlabel);
        panel.setLayout(new GridLayout(4,2));
        
        panel.add(t);
        panel.add(button);
        panel.add(Outputlabel);

        // setting up the frame and display
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720,720);
        frame.setResizable(false);
        frame.setTitle("Date to Day");
        frame.pack();
        frame.setVisible(true);
    }

    // calling DatetoDay program to display the result
    public void actionPerformed(ActionEvent e) 
    {
		Scanner sc= new Scanner(t.getText());
        int d= sc.nextInt();
        int m= sc.nextInt();
        int y= sc.nextInt();
        Outputlabel.setText("DAY:  " + DatetoDay.DateDay(d,m,y));
        sc.close();
    }

    // create one Frame
    public static void main(String[] args) {
        new Applet();
    }
}