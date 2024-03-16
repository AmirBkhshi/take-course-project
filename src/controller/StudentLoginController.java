package controller;

import model.DataBase;
import model.Student;
import view.StudentLogin;
import view.StudentPage;
import view.WelcomePage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StudentLoginController implements ActionListener
{
    private StudentLogin studentLogin;

    public StudentLoginController(StudentLogin studentLogin)
    {
        this.studentLogin = studentLogin;
    }

    public void setStudentLogin(StudentLogin studentLogin)
    {
        this.studentLogin = studentLogin;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == studentLogin.login)
        {
            try
            {
                Student student = DataBase.getStudent(Integer.parseInt(studentLogin.idField.getText()));
                if (student != null)
                {
                    StudentPage studentPage = new StudentPage(student);
                    studentPage.show();
                }
                else
                {
                    JOptionPane.showMessageDialog(studentLogin.frame, "Student not found");
                }
            }
            catch (IOException | ClassNotFoundException ex)
            {
                JOptionPane.showMessageDialog(studentLogin.frame, "Error: " + ex.getMessage());
            }
        }
        else
        {
            studentLogin.frame.dispose();
            WelcomePage welcomePage = new WelcomePage();
            welcomePage.show();
        }
    }
}
