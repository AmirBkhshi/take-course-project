package view;

import controller.WelcomePageController;

import javax.swing.*;
import java.awt.*;

public class WelcomePage
{
    public JFrame frame;
    public KGradientPanel panel;
    public JLabel label;
    public JLabel hint;
    public JButton students;
    public JButton teachers;
    public JButton managers;
    private WelcomePageController controller;
    
    public WelcomePage()
    {
        frame = new JFrame("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setResizable(false);
        
        panel = new KGradientPanel();
        label = new JLabel();
        hint = new JLabel();
        controller = new WelcomePageController();
        students = new JButton();
        teachers = new JButton();
        managers = new JButton();
        init();
    }

    public void init()
    {
        panel.setLayout(null);
        panel.setBounds(0, 0, 1200, 800);
        panel.setkStartColor(new Color(0, 0, 0));
        panel.setkEndColor(new Color(100, 100, 100));
        panel.setkTransparentControls(false);
        panel.setkGradientFocus(500);

        label.setText("Welcome to the take course system");
        label.setFont(new Font("Serif", Font.BOLD, 50));
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(100, 50, 1000, 100);

        hint.setText("Please choose your identity");
        hint.setFont(new Font("Serif", Font.BOLD, 30));
        hint.setForeground(Color.WHITE);
        hint.setBounds(150, 350, 1000, 100);

        students.setText("Students");
        students.setBounds(150, 500, 200, 50);
        students.setBackground(Color.WHITE);
        students.setForeground(Color.BLACK);
        students.setFont(new Font("Serif", Font.BOLD, 20));

        teachers.setText("Teachers");
        teachers.setBounds(450, 500, 200, 50);
        teachers.setBackground(Color.WHITE);
        teachers.setForeground(Color.BLACK);
        teachers.setFont(new Font("Serif", Font.BOLD, 20));

        managers.setText("Managers");
        managers.setBounds(750, 500, 200, 50);
        managers.setBackground(Color.WHITE);
        managers.setForeground(Color.BLACK);
        managers.setFont(new Font("Serif", Font.BOLD, 20));

        panel.add(label);
        panel.add(hint);
        panel.add(students);
        panel.add(teachers);
        panel.add(managers);

        frame.add(panel);

        controller.setWelcomePage(this);
        students.addActionListener(controller);
        teachers.addActionListener(controller);
        managers.addActionListener(controller);
    }

    public void show()
    {
        frame.setVisible(true);
    }

    public void hide()
    {
        frame.setVisible(false);
    }

    public static void main(String[] args)
    {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.init();
        welcomePage.show();
    }
}
