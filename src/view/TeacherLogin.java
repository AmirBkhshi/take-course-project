package view;

import controller.TeacherLoginController;

import javax.swing.*;
import java.awt.*;

public class TeacherLogin
{
    public JFrame frame;
    public KGradientPanel panel;
    public JLabel id;
    public JTextField idField;
    public JLabel hint;
    public JButton login;
    public JButton back;
    public TeacherLoginController controller;

    public TeacherLogin()
    {
        frame = new JFrame("Teacher Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setResizable(false);

        panel = new KGradientPanel();
        id = new JLabel();
        idField = new JTextField();
        hint = new JLabel();
        login = new JButton();
        back = new JButton();
        controller = new TeacherLoginController(this);
        init();
    }

    public void init()
    {
        frame.add(panel);
        panel.setLayout(null);
        panel.setBounds(0, 0, 1200, 800);
        panel.setkStartColor(new Color(0, 0, 0));
        panel.setkEndColor(new Color(100, 100, 100));
        panel.setkTransparentControls(false);
        panel.setkGradientFocus(500);

        id.setText("Teacher ID");
        id.setFont(new Font("Serif", Font.BOLD, 20));
        id.setForeground(Color.WHITE);
        id.setBounds(400, 500, 100, 50);

        idField.setBounds(500, 500, 200, 50);

        hint.setText("Please enter your teacher id");
        hint.setFont(new Font("Serif", Font.BOLD, 30));
        hint.setForeground(Color.WHITE);
        hint.setBounds(400, 350, 1000, 100);

        login.setText("Login");
        login.setFont(new Font("Serif", Font.BOLD, 20));
        login.setForeground(Color.WHITE);
        login.setBounds(500, 600, 200, 50);
        login.addActionListener(controller);

        back.setText("Back");
        back.setFont(new Font("Serif", Font.BOLD, 20));
        back.setForeground(Color.WHITE);
        back.setBounds(500, 700, 200, 50);
        back.addActionListener(controller);

        panel.add(id);
        panel.add(idField);
        panel.add(hint);
        panel.add(login);
        panel.add(back);
    }

    public void show()
    {
        frame.setVisible(true);
    }

    public void hide()
    {
        frame.setVisible(false);
    }
}
