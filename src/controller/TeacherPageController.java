package controller;

import model.Course;
import model.DataBase;
import model.Student;
import model.Teacher;
import view.TeacherPage;
import view.WelcomePage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TeacherPageController implements ActionListener
{
    private TeacherPage teacherPage;
    private Teacher teacher;


    public TeacherPageController(TeacherPage teacherPage, Teacher teacher)
    {
        this.teacherPage = teacherPage;
        this.teacher = teacher;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == teacherPage.addCourse)
        {
            try
            {
                teacher.addCourse(DataBase.getCourse(Integer.parseInt(teacherPage.idField.getText())));
                updateTable();
            }
            catch (IOException | ClassNotFoundException ex)
            {
                throw new RuntimeException(ex);
            }
        }
        else if (e.getSource() == teacherPage.deleteCourse)
        {
            try
            {
                if (teacher.deleteCourse(DataBase.getCourse(Integer.parseInt(teacherPage.idField.getText()))))
                {
                    JOptionPane.showMessageDialog(teacherPage.frame, "Course deleted successfully");
                    updateTable();
                }
                else
                {
                    JOptionPane.showMessageDialog(teacherPage.frame, "Course not found");
                }
            }
            catch (IOException | ClassNotFoundException ex)
            {
                throw new RuntimeException(ex);
            }
        }
        else if (e.getSource() == teacherPage.addGrade)
        {
            try
            {
                Student student = DataBase.getStudent(Integer.parseInt(teacherPage.studentIdField.getText()));
                Course course = DataBase.getCourse(Integer.parseInt(teacherPage.courseIdField.getText()));
                double grade = Double.parseDouble(teacherPage.grade.getText());
                if(!student.setGrade(course.getId(), grade))
                {
                    JOptionPane.showMessageDialog(teacherPage.frame, "Student doesn't have this course");
                }
                else
                {
                    JOptionPane.showMessageDialog(teacherPage.frame, "Grade added successfully");
                }
            }
            catch (IOException | ClassNotFoundException ex)
            {
                JOptionPane.showMessageDialog(teacherPage.frame, "Student doesn't exist");
            }
        }
        else if (e.getSource() == teacherPage.back)
        {
            teacherPage.frame.dispose();
            WelcomePage welcomePage = new WelcomePage();
            welcomePage.show();
        }
    }

    private void updateTable()
    {
        teacherPage.allCourseTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [teacher.getCourses().size()][5],
                new String [] {
                        "Course Name", "Course ID", "Units", "Course Time", "Teacher Name"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        for (int i = 0; i < teacher.getCourses().size(); i++)
        {
            teacherPage.allCourseTable.setValueAt(teacher.getCourses().get(i).getCourseName(), i, 0);
            teacherPage.allCourseTable.setValueAt(teacher.getCourses().get(i).getId(), i, 1);
            teacherPage.allCourseTable.setValueAt(teacher.getCourses().get(i).getUnits(), i, 2);
            teacherPage.allCourseTable.setValueAt(teacher.getCourses().get(i).getTime().toString(), i, 3);
            teacherPage.allCourseTable.setValueAt(teacher.getCourses().get(i).getTeacher().getFullName(), i, 4);
        }
    }
}
