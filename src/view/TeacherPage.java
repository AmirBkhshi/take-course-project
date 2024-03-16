package view;

import controller.TeacherPageController;
import model.Teacher;

import javax.swing.*;
import java.awt.*;

public class TeacherPage
{
    public JFrame frame;
    public KGradientPanel panel;
    public JLabel id;
    public JTextField idField;
    public JButton addCourse;
    public JButton deleteCourse;
    public JButton back;
    public ScrollPane allCourse;
    public JTable allCourseTable;
    public JLabel allCourseLabel;
    public JLabel grade;
    public JLabel studentId;
    public JTextField studentIdField;
    public JLabel courseId;
    public JTextField courseIdField;
    public JButton addGrade;
    public TeacherPageController controller;
    public Teacher teacher;

    public TeacherPage(Teacher teacher)
    {
        frame = new JFrame("Teacher Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setResizable(false);

        panel = new KGradientPanel();
        id = new JLabel();
        idField = new JTextField();
        addCourse = new JButton();
        deleteCourse = new JButton();
        allCourse = new ScrollPane();
        allCourseTable = new JTable();
        allCourseLabel = new JLabel();
        grade = new JLabel();
        studentId = new JLabel();
        studentIdField = new JTextField();
        courseId = new JLabel();
        courseIdField = new JTextField();
        addGrade = new JButton();
        back = new JButton();
        controller = new TeacherPageController(this, teacher);
        this.teacher = teacher;
        init();
    }

    public void init()
    {
        frame.add(panel);
        panel.setLayout(null);
        panel.setBounds(0, 0, 1200, 800);
        panel.setkStartColor(new Color(0, 0, 0));
        panel.setkEndColor(new Color(255, 255, 255));
        panel.setkTransparentControls(false);
        panel.setkGradientFocus(500);

        allCourseLabel.setText("All Courses");
        allCourseLabel.setFont(new Font("Serif", Font.BOLD, 50));
        allCourseLabel.setForeground(Color.WHITE);
        allCourseLabel.setBounds(450, 50, 1000, 100);

        allCourse.setBounds(450, 150, 500, 300);
        allCourseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Course ID", "Course Name", "Teacher ID", "Time", "Unit"
            }
        ));
        allCourse.add(allCourseTable);

        id.setText("Course ID");
        id.setFont(new Font("Serif", Font.BOLD, 20));
        id.setForeground(Color.WHITE);
        id.setBounds(100, 530, 200, 50);

        idField.setBounds(100, 580, 200, 50);

        addCourse.setText("Add Course");
        addCourse.setFont(new Font("Serif", Font.BOLD, 20));
        addCourse.setBounds(100, 630, 200, 50);
        addCourse.addActionListener(controller);

        deleteCourse.setText("Delete Course");
        deleteCourse.setFont(new Font("Serif", Font.BOLD, 20));
        deleteCourse.setBounds(100, 680, 200, 50);
        deleteCourse.addActionListener(controller);

        grade.setText("Grade");
        grade.setFont(new Font("Serif", Font.BOLD, 20));
        grade.setForeground(Color.WHITE);
        grade.setBounds(100, 150, 200, 50);

        studentId.setText("Student ID");
        studentId.setFont(new Font("Serif", Font.BOLD, 20));
        studentId.setForeground(Color.WHITE);
        studentId.setBounds(100, 200, 200, 50);

        studentIdField.setBounds(100, 250, 200, 50);

        courseId.setText("Course ID");
        courseId.setFont(new Font("Serif", Font.BOLD, 20));
        courseId.setForeground(Color.WHITE);
        courseId.setBounds(100, 300, 200, 50);

        courseIdField.setBounds(100, 350, 200, 50);

        addGrade.setText("Add Grade");
        addGrade.setFont(new Font("Serif", Font.BOLD, 20));
        addGrade.setBounds(100, 400, 200, 50);
        addGrade.addActionListener(controller);

        back.setText("Back");
        back.setFont(new Font("Serif", Font.BOLD, 20));
        back.setBounds(900, 700, 200, 50);
        back.addActionListener(controller);

        panel.add(id);
        panel.add(idField);
        panel.add(addCourse);
        panel.add(deleteCourse);
        panel.add(allCourse);
        panel.add(allCourseLabel);
        panel.add(grade);
        panel.add(studentId);
        panel.add(studentIdField);
        panel.add(courseId);
        panel.add(courseIdField);
        panel.add(addGrade);
        panel.add(back);

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
}
