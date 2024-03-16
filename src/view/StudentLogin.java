package view;

import controller.StudentLoginController;

import javax.swing.*;
import java.awt.*;

public class StudentLogin
{
    public JFrame frame;
    public KGradientPanel panel;
    public JLabel label;
    public JLabel hint;
    public JLabel id;
    public JTextField idField;
    public JButton login;
    public StudentLoginController controller;

    public JButton back;

    public StudentLogin()
    {
        frame = new JFrame("Student Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setResizable(false);

        panel = new KGradientPanel();
        label = new JLabel();
        hint = new JLabel();
        id = new JLabel();
        login = new JButton();
        controller = new StudentLoginController(this);
        back = new JButton();
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

        hint.setText("Please enter your student id");
        hint.setFont(new Font("Serif", Font.BOLD, 30));
        hint.setForeground(Color.WHITE);
        hint.setBounds(400, 350, 1000, 100);

        id.setText("Student ID");
        id.setFont(new Font("Serif", Font.BOLD, 20));
        id.setForeground(Color.WHITE);
        id.setBounds(400, 500, 100, 50);

        idField = new JTextField();
        idField.setBounds(500, 500, 200, 50);
        idField.setFont(new Font("Serif", Font.BOLD, 20));
        idField.setForeground(Color.BLACK);
        idField.setBackground(Color.WHITE);
        panel.add(idField);

        login.setText("Login");
        login.setBounds(400, 600, 200, 50);
        login.setBackground(Color.WHITE);
        login.setForeground(Color.BLACK);
        login.setFont(new Font("Serif", Font.BOLD, 20));
        login.addActionListener(controller);

        back.setText("Back");
        back.setFont(new Font("Serif", Font.BOLD, 20));
        back.setBounds(900, 600, 200, 50);

        panel.add(label);
        panel.add(hint);
        panel.add(id);
        panel.add(login);
        panel.add(back);

        back.addActionListener(controller);
        login.addActionListener(controller);

        frame.add(panel);
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
        StudentLogin studentLogin = new StudentLogin();
        studentLogin.init();
        studentLogin.show();
    }


}
