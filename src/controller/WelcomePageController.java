package controller;

import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePageController implements ActionListener
{
    private WelcomePage welcomePage;

    public WelcomePage getWelcomePage()
    {
        return welcomePage;
    }

    public void setWelcomePage(WelcomePage welcomePage)
    {
        this.welcomePage = welcomePage;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == welcomePage.students)
        {
            welcomePage.frame.dispose();
            StudentLogin login = new StudentLogin();
            login.show();
        }
        else if (e.getSource() == welcomePage.teachers)
        {
            welcomePage.frame.dispose();
            TeacherLogin login = new TeacherLogin();
            login.show();
        }
        else if (e.getSource() == welcomePage.managers)
        {
            welcomePage.frame.dispose();
            AdminGUI adminGUI = new AdminGUI();
            adminGUI.show();
        }
    }
}
