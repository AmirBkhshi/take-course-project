package controller;

import model.DataBase;
import model.Student;
import view.StudentPage;
import view.WelcomePage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StudentPageController implements ActionListener
{
    private Student student;
    private StudentPage studentPage;

    public StudentPageController(Student student, StudentPage studentPage)
    {
        this.student = student;
        this.studentPage = studentPage;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == studentPage.back)
        {
            studentPage.frame.dispose();
            WelcomePage welcomePage = new WelcomePage();
            welcomePage.show();
        }
        else if(e.getSource() == studentPage.deleteCourse)
        {
            try
            {
                student.deleteCourse(DataBase.getCourse(Integer.parseInt(studentPage.idField.getText())).getId());
                updateTable();
            }
            catch (IOException | ClassNotFoundException ex)
            {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
        else if(e.getSource() == studentPage.addCourse)
        {
            try
            {
                if(student.addCourse(DataBase.getCourse(Integer.parseInt(studentPage.idField.getText()))))
                {
                    JOptionPane.showMessageDialog(null, "Course added successfully");
                    updateTable();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Course has conflict");
                }
            }
            catch (IOException | ClassNotFoundException ex)
            {
                JOptionPane.showMessageDialog(studentPage.frame, "Course not found");
            }
        }
    }

    private void updateTable()
    {
        studentPage.idField.setText("");
        studentPage.allCourseTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String [] {
                        "Course Name", "Course ID", "Units", "Course Time", "Teacher Name"
                }
        ));
        for (int i = 0; i < student.getCourses().size(); i++)
        {
            studentPage.allCourseTable.setValueAt(student.getCourses().get(i).getCourseName(), i, 0);
            studentPage.allCourseTable.setValueAt(student.getCourses().get(i).getId(), i, 1);
            studentPage.allCourseTable.setValueAt(student.getCourses().get(i).getUnits(), i, 2);
            studentPage.allCourseTable.setValueAt(student.getCourses().get(i).getTime().toString(), i, 3);
            studentPage.allCourseTable.setValueAt(student.getCourses().get(i).getTeacher().getFullName(), i, 4);
        }
    }
}
