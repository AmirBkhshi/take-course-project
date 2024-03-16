package view;

import controller.StudentPageController;
import model.Student;

import javax.swing.*;
import java.awt.*;

public class StudentPage
{
    public JFrame frame;
    public KGradientPanel panel;
    public JScrollPane allCourse;
    public JTable allCourseTable;
    public JLabel allCourseLabel;
    public JLabel id;
    public JTextField idField;
    public JButton addCourse;
    public JButton deleteCourse;
    public JButton back;
    public StudentPageController controller;

    public StudentPage(Student student)
    {
        frame = new JFrame("Student Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setResizable(false);

        panel = new KGradientPanel();
        allCourse = new JScrollPane();
        allCourseTable = new JTable();
        allCourseLabel = new JLabel();
        idField = new JTextField();
        addCourse = new JButton();
        deleteCourse = new JButton();
        controller = new StudentPageController(student, this);
        back = new JButton();
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

        allCourseLabel.setText("All Courses");
        allCourseLabel.setFont(new Font("Serif", Font.BOLD, 50));
        allCourseLabel.setForeground(Color.WHITE);
        allCourseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        allCourseLabel.setBounds(450, 50, 1000, 100);

        allCourse.setBounds(450, 150, 500, 300);
        allCourseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Course ID", "Course Name", "Teacher Name", "Time"
            }
        ));
        allCourse.setViewportView(allCourseTable);

        id = new JLabel();
        id.setText("Course ID");
        id.setFont(new Font("Serif", Font.BOLD, 20));
        id.setForeground(Color.WHITE);
        id.setBounds(100, 200, 100, 50);

        idField.setBounds(100, 300, 200, 50);
        idField.setFont(new Font("Serif", Font.BOLD, 20));

        addCourse.setText("Add Course");
        addCourse.setFont(new Font("Serif", Font.BOLD, 20));
        addCourse.setBounds(100, 400, 200, 50);

        deleteCourse.setText("Delete Course");
        deleteCourse.setFont(new Font("Serif", Font.BOLD, 20));
        deleteCourse.setBounds(100, 500, 200, 50);

        back.setText("Back");
        back.setFont(new Font("Serif", Font.BOLD, 20));
        back.setBounds(900, 600, 200, 50);

        panel.add(allCourseLabel);
        panel.add(allCourse);
        panel.add(id);
        panel.add(idField);
        panel.add(addCourse);
        panel.add(deleteCourse);
        panel.add(back);
        deleteCourse.addActionListener(controller);
        addCourse.addActionListener(controller);
        back.addActionListener(controller);
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
