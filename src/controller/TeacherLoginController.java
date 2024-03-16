package controller;

import model.DataBase;
import model.Teacher;
import view.TeacherLogin;
import view.TeacherPage;
import view.WelcomePage;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TeacherLoginController implements ActionListener
{
    private TeacherLogin teacherLogin;
    public TeacherLoginController(TeacherLogin teacherLogin)
    {
        this.teacherLogin = teacherLogin;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == teacherLogin.login)
        {
            try
            {
                Teacher teacher = DataBase.getTeacher(Integer.parseInt(teacherLogin.idField.getText()));
                if (teacher != null)
                {
                    teacherLogin.frame.dispose();
                    TeacherPage teacherPage = new TeacherPage(teacher);
                    teacherPage.show();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Wrong ID");
                }
            }
            catch (IOException | ClassNotFoundException ex)
            {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
        else if (e.getSource() == teacherLogin.back)
        {
            teacherLogin.frame.dispose();
            WelcomePage welcomePage = new WelcomePage();
            welcomePage.show();
        }
    }
}
