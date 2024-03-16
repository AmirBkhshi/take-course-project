package controller;

import model.*;
import view.AdminGUI;
import view.WelcomePage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class AdminGUIController implements ActionListener
{
    private AdminGUI adminGUI;

    public AdminGUIController(AdminGUI adminGUI)
    {
        this.adminGUI = adminGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == adminGUI.showAllCoursesBtn)
        {
            String[][] data = new String[Course.getIdGenerator()][5];
            for (int i = 0; i < Course.getIdGenerator(); i++)
            {
                try
                {
                    Course course = DataBase.getCourse(i);
                    if (course != null)
                    {
                        data[i][0] = String.valueOf(course.getId());
                        data[i][1] = course.getCourseName();
                        data[i][2] = String.valueOf(course.getTeacher().getFullName());
                        data[i][3] = String.valueOf(course.getUnits());
                    }
                }
                catch (IOException | ClassNotFoundException ignored)
                {

                }
            }
            adminGUI.courseTable.setModel(new DefaultTableModel(
                    data,
                    new String[]{"ID", "Name", "Teacher", "Units"}
            ));
        }
        else if(e.getSource() == adminGUI.addCourseBtn)
        {
            String name = JOptionPane.showInputDialog("Enter course name");
            int units = Integer.parseInt(JOptionPane.showInputDialog("Enter units"));
            int teacherId = Integer.parseInt(JOptionPane.showInputDialog("Enter teacher id"));
            Teacher teacher = null;
            try
            {
                teacher = DataBase.getTeacher(teacherId);
            }
            catch (IOException | ClassNotFoundException ignored)
            {

            }
            CourseTime time = new CourseTime(new ClassTime(Integer.parseInt(JOptionPane.showInputDialog("Enter start hour")), Integer.parseInt(JOptionPane.showInputDialog("Enter start minute")), Integer.parseInt(JOptionPane.showInputDialog("Enter end hour")), Integer.parseInt(JOptionPane.showInputDialog("Enter end minute"))), Day.valueOf(JOptionPane.showInputDialog("Enter day")));
            try
            {
                DataBase.save(new Course(name, units, time, teacher));
                JOptionPane.showMessageDialog(adminGUI.frame, "Course added successfully");
            }
            catch (IOException ignored)
            {

            }
            adminGUI.updateTable();
        }
        else if(e.getSource() == adminGUI.addStudentBtn)
        {
            String firstName = JOptionPane.showInputDialog("Enter First name");
            String lastName = JOptionPane.showInputDialog("Enter Last name");
            char sex = JOptionPane.showInputDialog("Enter your sex").toLowerCase().charAt(0);
            try
            {
                DataBase.save(new Student(firstName, lastName, sex));
                JOptionPane.showMessageDialog(adminGUI.frame, "Student added successfully");
            }
            catch (IOException ignored)
            {
            }
            adminGUI.updateTable();
        }
        else if(e.getSource() == adminGUI.addTeacherBtn)
        {
            String firstName = JOptionPane.showInputDialog("Enter First name");
            String lastName = JOptionPane.showInputDialog("Enter Last name");
            char sex = JOptionPane.showInputDialog("Enter your sex").toLowerCase().charAt(0);
            try
            {
                DataBase.save(new Teacher(firstName, lastName, sex));
                JOptionPane.showMessageDialog(adminGUI.frame, "Teacher added successfully");
            }
            catch (IOException ignored)
            {}
            adminGUI.updateTable();
        }
        else if(e.getSource() == adminGUI.deleteCourseBtn)
        {
            int id = Integer.parseInt(adminGUI.courseIDField.getText());
            DataBase.delete(DataBase.courseUrl, id);
            JOptionPane.showMessageDialog(adminGUI.frame, "Course deleted successfully");
            adminGUI.updateTable();
        }
        else if(e.getSource() == adminGUI.deleteStudentBtn)
        {
            int id = Integer.parseInt(adminGUI.studentIDField.getText());
            DataBase.delete(DataBase.studentUrl, id);
            JOptionPane.showMessageDialog(adminGUI.frame, "Student deleted successfully");
            adminGUI.updateTable();
        }
        else if(e.getSource() == adminGUI.deleteTeacherBtn)
        {
            int id = Integer.parseInt(adminGUI.teacherIDField.getText());
            DataBase.delete(DataBase.teacherUrl, id);
            JOptionPane.showMessageDialog(adminGUI.frame, "Student deleted successfully");
            adminGUI.updateTable();
        }
        else if(e.getSource() == adminGUI.showAllStudentsBtn)
        {
            adminGUI.updateTable();
        }
        else if(e.getSource() == adminGUI.showAllTeachersBtn)
        {
            adminGUI.updateTable();
        }
        else if(e.getSource() == adminGUI.searchCourseBtn)
        {
            int id = Integer.parseInt(adminGUI.searchCourse.getText());
            try
            {
                Course course = DataBase.getCourse(id);
                if (course != null)
                {
                    JOptionPane.showMessageDialog(adminGUI.frame, course.toString());
                }
                else
                {
                    JOptionPane.showMessageDialog(adminGUI.frame, "Course not found");
                }
            }
            catch (IOException | ClassNotFoundException ignored)
            {

            }
        }
        else if(e.getSource() == adminGUI.searchStudentBtn)
        {
            int id = Integer.parseInt(adminGUI.searchStudent.getText());
            try
            {
                Student student = DataBase.getStudent(id);
                if (student != null)
                {
                    JOptionPane.showMessageDialog(adminGUI.frame, student.toString());
                }
                else
                {
                    JOptionPane.showMessageDialog(adminGUI.frame, "Student not found");
                }
            }
            catch (IOException | ClassNotFoundException ignored)
            {

            }
        }
        else if(e.getSource() == adminGUI.searchTeacherBtn)
        {
            int id = Integer.parseInt(adminGUI.searchTeacher.getText());
            try
            {
                Teacher teacher = DataBase.getTeacher(id);
                if (teacher != null)
                {
                    JOptionPane.showMessageDialog(adminGUI.frame, teacher.toString());
                }
                else
                {
                    JOptionPane.showMessageDialog(adminGUI.frame, "Teacher not found");
                }
            }
            catch (IOException | ClassNotFoundException ignored)
            {

            }
        }
        else if(e.getSource() == adminGUI.showAllCoursesBtn)
        {
            adminGUI.updateTable();
        }
        else if(e.getSource() == adminGUI.backBtn1 || e.getSource() == adminGUI.backBtn2 || e.getSource() == adminGUI.backBtn3)
        {
            adminGUI.frame.dispose();
            WelcomePage welcomePage = new WelcomePage();
            welcomePage.show();
        }
    }
}
