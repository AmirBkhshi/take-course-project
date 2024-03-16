package view;

import controller.AdminGUIController;
import model.Course;
import model.DataBase;
import model.Student;
import model.Teacher;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AdminGUI
{
    public JFrame frame;
    public JTabbedPane pane;
    public KGradientPanel teachers;
    public KGradientPanel students;
    public KGradientPanel courses;
    public AdminGUIController controller;


    // Teacher
    public JLabel addTeacher;
    public JLabel deleteTeacher;
    public JLabel searchTeacher;
    public JLabel teacherID;
    public JButton addTeacherBtn;
    public JButton deleteTeacherBtn;
    public JButton searchTeacherBtn;
    public JTextField teacherIDField;
    public JTable teacherTable;
    public JScrollPane teacherScroll;
    public JLabel showAllTeachers;
    public JButton showAllTeachersBtn;

    // Student
    public JLabel addStudent;
    public JLabel deleteStudent;
    public JLabel searchStudent;
    public JLabel studentID;
    public JButton addStudentBtn;
    public JButton deleteStudentBtn;
    public JButton searchStudentBtn;
    public JTextField studentIDField;
    public JTable studentTable;
    public JScrollPane studentScroll;
    public JLabel showAllStudents;
    public JButton showAllStudentsBtn;
    public JButton backBtn1;
    public JButton backBtn2;
    public JButton backBtn3;

    // Course
    public JLabel addCourse;
    public JLabel deleteCourse;
    public JLabel searchCourse;
    public JLabel updateCourse;
    public JLabel courseID;
    public JButton addCourseBtn;
    public JButton deleteCourseBtn;
    public JButton searchCourseBtn;
    public JButton updateCourseBtn;
    public JTextField courseIDField;
    public JTable courseTable;
    public JScrollPane courseScroll;
    public JLabel showAllCourses;
    public JButton showAllCoursesBtn;

    public AdminGUI()
    {
        frame = new JFrame("Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setResizable(false);
        controller = new AdminGUIController(this);

        pane = new JTabbedPane();
        teachers = new KGradientPanel();
        students = new KGradientPanel();
        courses = new KGradientPanel();

        // Teacher
        addTeacher = new JLabel();
        deleteTeacher = new JLabel();
        searchTeacher = new JLabel();
        teacherID = new JLabel();
        addTeacherBtn = new JButton();
        deleteTeacherBtn = new JButton();
        searchTeacherBtn = new JButton();
        teacherIDField = new JTextField();
        teacherTable = new JTable();
        teacherScroll = new JScrollPane();

        // Student
        addStudent = new JLabel();
        deleteStudent = new JLabel();
        searchStudent = new JLabel();
        studentID = new JLabel();
        addStudentBtn = new JButton();
        deleteStudentBtn = new JButton();
        searchStudentBtn = new JButton();
        studentIDField = new JTextField();
        studentTable = new JTable();
        studentScroll = new JScrollPane();

        // Course
        addCourse = new JLabel();
        deleteCourse = new JLabel();
        searchCourse = new JLabel();
        updateCourse = new JLabel();
        courseID = new JLabel();
        addCourseBtn = new JButton();
        deleteCourseBtn = new JButton();
        searchCourseBtn = new JButton();
        updateCourseBtn = new JButton();
        courseIDField = new JTextField();
        courseTable = new JTable();
        courseScroll = new JScrollPane();
        init();
    }

    public void init()
    {
        frame.add(pane);
        pane.setBounds(0, 0, 1200, 800);
        pane.add("Teachers", teachers);
        pane.add("Students", students);
        pane.add("Courses", courses);

        // Teacher
        teachers.setLayout(null);
        teachers.setBounds(0, 0, 1200, 800);
        teachers.setkStartColor(new Color(213, 213, 213));
        teachers.setkEndColor(new Color(100, 100, 100));
        teachers.setkTransparentControls(false);
        teachers.setkGradientFocus(500);

        addTeacher.setText("Add Teacher");
        addTeacher.setFont(new Font("Serif", Font.BOLD, 30));
        addTeacher.setForeground(Color.WHITE);
        addTeacher.setBounds(50, 50, 200, 50);

        deleteTeacher.setText("Delete Teacher");
        deleteTeacher.setFont(new Font("Serif", Font.BOLD, 30));
        deleteTeacher.setForeground(Color.WHITE);
        deleteTeacher.setBounds(50, 150, 200, 50);

        searchTeacher.setText("Search Teacher");
        searchTeacher.setFont(new Font("Serif", Font.BOLD, 30));
        searchTeacher.setForeground(Color.WHITE);
        searchTeacher.setBounds(50, 250, 200, 50);

        teacherID.setText("Teacher ID");
        teacherID.setFont(new Font("Serif", Font.BOLD, 20));
        teacherID.setForeground(Color.WHITE);
        teacherID.setBounds(50, 350, 200, 50);

        addTeacherBtn.setText("Add");
        addTeacherBtn.setBounds(50, 100, 100, 50);
        addTeacherBtn.setBackground(Color.WHITE);
        addTeacherBtn.setForeground(Color.BLACK);
        addTeacherBtn.setFont(new Font("Serif", Font.BOLD, 20));

        deleteTeacherBtn.setText("Delete");
        deleteTeacherBtn.setBounds(50, 200, 100, 50);
        deleteTeacherBtn.setBackground(Color.WHITE);
        deleteTeacherBtn.setForeground(Color.BLACK);
        deleteTeacherBtn.setFont(new Font("Serif", Font.BOLD, 20));

        searchTeacherBtn.setText("Search");
        searchTeacherBtn.setBounds(50, 300, 100, 50);
        searchTeacherBtn.setBackground(Color.WHITE);
        searchTeacherBtn.setForeground(Color.BLACK);
        searchTeacherBtn.setFont(new Font("Serif", Font.BOLD, 20));

        teacherIDField.setBounds(50, 400, 200, 50);
        teacherIDField.setFont(new Font("Serif", Font.BOLD, 20));
        teacherIDField.setForeground(Color.BLACK);
        teacherIDField.setBackground(Color.WHITE);

        showAllTeachers = new JLabel();
        showAllTeachers.setText("Show All Teachers");
        showAllTeachers.setFont(new Font("Serif", Font.BOLD, 30));
        showAllTeachers.setForeground(Color.WHITE);
        showAllTeachers.setBounds(50, 500, 300, 50);

        showAllTeachersBtn = new JButton();
        showAllTeachersBtn.setText("Show");
        showAllTeachersBtn.setBounds(50, 550, 100, 50);
        showAllTeachersBtn.setBackground(Color.WHITE);
        showAllTeachersBtn.setForeground(Color.BLACK);
        showAllTeachersBtn.setFont(new Font("Serif", Font.BOLD, 20));


        List<Teacher> teacherss = DataBase.getTeachers();
        String[][] data = new String[teacherss.size()][5];
        for (int i = 0; i < teacherss.size(); i++)
        {
            data[i][0] = String.valueOf(teacherss.get(i).getId());
            data[i][1] = teacherss.get(i).getFirstName();
            data[i][2] = teacherss.get(i).getLastName();
            data[i][3] = String.valueOf(teacherss.get(i).getSex());
            data[i][4] = String.valueOf(teacherss.get(i).getUnits());
        }
        teacherTable.setModel(new DefaultTableModel(
                data,
                new String[]{"ID", "First Name", "Last Name", "Sex", "UnitS"}));
        teacherScroll.setViewportView(teacherTable);
        teacherScroll.setBounds(300, 50, 800, 450);
        teacherScroll.setBackground(Color.WHITE);
        teacherScroll.setForeground(Color.BLACK);
        teacherScroll.setFont(new Font("Serif", Font.BOLD, 20));

        backBtn1 = new JButton();
        backBtn1.setText("Back");
        backBtn1.setBounds(900, 650, 100, 50);
        backBtn1.setBackground(Color.WHITE);
        backBtn1.setForeground(Color.BLACK);
        backBtn1.setFont(new Font("Serif", Font.BOLD, 20));


        teachers.add(addTeacher);
        teachers.add(deleteTeacher);
        teachers.add(searchTeacher);
        teachers.add(teacherID);
        teachers.add(addTeacherBtn);
        teachers.add(deleteTeacherBtn);
        teachers.add(searchTeacherBtn);
        teachers.add(teacherIDField);
        teachers.add(teacherScroll);
        teachers.add(showAllTeachers);
        teachers.add(showAllTeachersBtn);
        teachers.add(backBtn1);

        // Student
        students.setLayout(null);
        students.setBounds(0, 0, 1200, 800);
        students.setkStartColor(new Color(213, 213, 213));
        students.setkEndColor(new Color(100, 100, 100));
        students.setkTransparentControls(false);
        students.setkGradientFocus(500);

        addStudent.setText("Add Student");
        addStudent.setFont(new Font("Serif", Font.BOLD, 30));
        addStudent.setForeground(Color.WHITE);
        addStudent.setBounds(50, 50, 200, 50);

        deleteStudent.setText("Delete Student");
        deleteStudent.setFont(new Font("Serif", Font.BOLD, 30));
        deleteStudent.setForeground(Color.WHITE);
        deleteStudent.setBounds(50, 150, 200, 50);

        searchStudent.setText("Search Student");
        searchStudent.setFont(new Font("Serif", Font.BOLD, 30));
        searchStudent.setForeground(Color.WHITE);
        searchStudent.setBounds(50, 250, 200, 50);

        studentID.setText("Student ID");
        studentID.setFont(new Font("Serif", Font.BOLD, 20));
        studentID.setForeground(Color.WHITE);
        studentID.setBounds(50, 350, 200, 50);

        addStudentBtn.setText("Add");
        addStudentBtn.setBounds(50, 100, 100, 50);
        addStudentBtn.setBackground(Color.WHITE);
        addStudentBtn.setForeground(Color.BLACK);
        addStudentBtn.setFont(new Font("Serif", Font.BOLD, 20));

        deleteStudentBtn.setText("Delete");
        deleteStudentBtn.setBounds(50, 200, 100, 50);
        deleteStudentBtn.setBackground(Color.WHITE);
        deleteStudentBtn.setForeground(Color.BLACK);
        deleteStudentBtn.setFont(new Font("Serif", Font.BOLD, 20));

        searchStudentBtn.setText("Search");
        searchStudentBtn.setBounds(50, 300, 100, 50);
        searchStudentBtn.setBackground(Color.WHITE);
        searchStudentBtn.setForeground(Color.BLACK);
        searchStudentBtn.setFont(new Font("Serif", Font.BOLD, 20));

        studentIDField.setBounds(50, 400, 200, 50);
        studentIDField.setFont(new Font("Serif", Font.BOLD, 20));
        studentIDField.setForeground(Color.BLACK);
        studentIDField.setBackground(Color.WHITE);

        showAllStudents = new JLabel();
        showAllStudents.setText("Show All Students");
        showAllStudents.setFont(new Font("Serif", Font.BOLD, 30));
        showAllStudents.setForeground(Color.WHITE);
        showAllStudents.setBounds(50, 500, 300, 50);

        showAllStudentsBtn = new JButton();
        showAllStudentsBtn.setText("Show");
        showAllStudentsBtn.setBounds(50, 550, 100, 50);
        showAllStudentsBtn.setBackground(Color.WHITE);
        showAllStudentsBtn.setForeground(Color.BLACK);
        showAllStudentsBtn.setFont(new Font("Serif", Font.BOLD, 20));


        ArrayList<Student> studentss = DataBase.getStudents();
        data = new String[studentss.size()][5];
        for (int i = 0; i < studentss.size(); i++)
        {
            data[i][0] = String.valueOf(studentss.get(i).getId());
            data[i][1] = studentss.get(i).getFirstName();
            data[i][2] = studentss.get(i).getLastName();
            data[i][3] = String.valueOf(studentss.get(i).getSex());
            data[i][4] = String.valueOf(studentss.get(i).getUnits());
        }

        studentTable.setModel(new DefaultTableModel(
                data,
                new String[]{"ID", "First Name", "Last Name", "Sex", "Units"}));
        studentScroll.setViewportView(studentTable);
        studentScroll.setBounds(300, 50, 800, 450);
        studentScroll.setBackground(Color.WHITE);
        studentScroll.setForeground(Color.BLACK);
        studentScroll.setFont(new Font("Serif", Font.BOLD, 20));

        backBtn2 = new JButton();
        backBtn2.setText("Back");
        backBtn2.setBounds(900, 650, 100, 50);
        backBtn2.setBackground(Color.WHITE);
        backBtn2.setForeground(Color.BLACK);
        backBtn2.setFont(new Font("Serif", Font.BOLD, 20));


        students.add(addStudent);
        students.add(deleteStudent);
        students.add(searchStudent);
        students.add(studentID);
        students.add(addStudentBtn);
        students.add(deleteStudentBtn);
        students.add(searchStudentBtn);
        students.add(studentIDField);
        students.add(studentScroll);
        students.add(showAllStudents);
        students.add(showAllStudentsBtn);
        students.add(backBtn2);



        // Course
        courses.setLayout(null);
        courses.setBounds(0, 0, 1200, 800);
        courses.setkStartColor(new Color(213, 213, 213));
        courses.setkEndColor(new Color(100, 100, 100));
        courses.setkTransparentControls(false);
        courses.setkGradientFocus(500);

        addCourse.setText("Add Course");
        addCourse.setFont(new Font("Serif", Font.BOLD, 30));
        addCourse.setForeground(Color.WHITE);
        addCourse.setBounds(50, 50, 200, 50);

        deleteCourse.setText("Delete Course");
        deleteCourse.setFont(new Font("Serif", Font.BOLD, 30));
        deleteCourse.setForeground(Color.WHITE);
        deleteCourse.setBounds(50, 150, 200, 50);

        searchCourse.setText("Search Course");
        searchCourse.setFont(new Font("Serif", Font.BOLD, 30));
        searchCourse.setForeground(Color.WHITE);
        searchCourse.setBounds(50, 250, 200, 50);

        courseID.setText("Course ID");
        courseID.setFont(new Font("Serif", Font.BOLD, 20));
        courseID.setForeground(Color.WHITE);
        courseID.setBounds(50, 350, 200, 50);

        addCourseBtn.setText("Add");
        addCourseBtn.setBounds(50, 100, 100, 50);
        addCourseBtn.setBackground(Color.WHITE);
        addCourseBtn.setForeground(Color.BLACK);
        addCourseBtn.setFont(new Font("Serif", Font.BOLD, 20));

        deleteCourseBtn.setText("Delete");
        deleteCourseBtn.setBounds(50, 200, 100, 50);
        deleteCourseBtn.setBackground(Color.WHITE);
        deleteCourseBtn.setForeground(Color.BLACK);
        deleteCourseBtn.setFont(new Font("Serif", Font.BOLD, 20));

        searchCourseBtn.setText("Search");
        searchCourseBtn.setBounds(50, 300, 100, 50);
        searchCourseBtn.setBackground(Color.WHITE);
        searchCourseBtn.setForeground(Color.BLACK);
        searchCourseBtn.setFont(new Font("Serif", Font.BOLD, 20));

        courseIDField.setBounds(50, 400, 200, 50);
        courseIDField.setFont(new Font("Serif", Font.BOLD, 20));
        courseIDField.setForeground(Color.BLACK);
        courseIDField.setBackground(Color.WHITE);

        showAllCourses = new JLabel();
        showAllCourses.setText("Show All Courses");
        showAllCourses.setFont(new Font("Serif", Font.BOLD, 30));
        showAllCourses.setForeground(Color.WHITE);
        showAllCourses.setBounds(50, 500, 300, 50);

        showAllCoursesBtn = new JButton();
        showAllCoursesBtn.setText("Show");
        showAllCoursesBtn.setBounds(50, 550, 100, 50);
        showAllCoursesBtn.setBackground(Color.WHITE);
        showAllCoursesBtn.setForeground(Color.BLACK);
        showAllCoursesBtn.setFont(new Font("Serif", Font.BOLD, 20));

        ArrayList<Course> coursess = DataBase.getCourses();
        data = new String[coursess.size()][5];
        for (int i = 0; i < coursess.size(); i++)
        {
            data[i][0] = String.valueOf(coursess.get(i).getId());
            data[i][1] = coursess.get(i).getCourseName();
            data[i][2] = String.valueOf(coursess.get(i).getUnits());
            data[i][3] = String.valueOf(coursess.get(i).getTeacher().getId());
            data[i][4] = String.valueOf(coursess.get(i).getTeacher().getFirstName());
        }
        courseTable.setModel(new DefaultTableModel(
                data,
                new String[]{"ID", "Name", "Units", "Teacher", "Time"}));
        courseScroll.setViewportView(courseTable);
        courseScroll.setBounds(300, 50, 800, 450);
        courseScroll.setBackground(Color.WHITE);
        courseScroll.setForeground(Color.BLACK);
        courseScroll.setFont(new Font("Serif", Font.BOLD, 20));

        backBtn3 = new JButton();
        backBtn3.setText("Back");
        backBtn3.setBounds(900, 650, 100, 50);
        backBtn3.setBackground(Color.WHITE);
        backBtn3.setForeground(Color.BLACK);
        backBtn3.setFont(new Font("Serif", Font.BOLD, 20));

        courses.add(addCourse);
        courses.add(deleteCourse);
        courses.add(searchCourse);
        courses.add(courseID);
        courses.add(addCourseBtn);
        courses.add(deleteCourseBtn);
        courses.add(searchCourseBtn);
        courses.add(courseIDField);
        courses.add(courseScroll);
        courses.add(showAllCourses);
        courses.add(showAllCoursesBtn);
        courses.add(backBtn3);

        // Action Listeners
        showAllCoursesBtn.addActionListener(controller);
        addCourseBtn.addActionListener(controller);
        addStudentBtn.addActionListener(controller);
        addTeacherBtn.addActionListener(controller);
        deleteCourseBtn.addActionListener(controller);
        deleteStudentBtn.addActionListener(controller);
        deleteTeacherBtn.addActionListener(controller);
        showAllStudentsBtn.addActionListener(controller);
        showAllTeachersBtn.addActionListener(controller);
        searchCourseBtn.addActionListener(controller);
        searchStudentBtn.addActionListener(controller);
        searchTeacherBtn.addActionListener(controller);
        showAllCoursesBtn.addActionListener(controller);
        backBtn1.addActionListener(controller);
        backBtn2.addActionListener(controller);
        backBtn3.addActionListener(controller);

    }

    public void show()
    {
        frame.setVisible(true);
    }

    public void hide()
    {
        frame.setVisible(false);
    }

    public void updateTable()
    {
        ArrayList<Course> coursess = DataBase.getCourses();
        String[][] data = new String[coursess.size()][5];
        for (int i = 0; i < coursess.size(); i++)
        {
            data[i][0] = String.valueOf(coursess.get(i).getId());
            data[i][1] = coursess.get(i).getCourseName();
            data[i][2] = String.valueOf(coursess.get(i).getUnits());
            data[i][3] = String.valueOf(coursess.get(i).getTeacher().getId());
            data[i][4] = String.valueOf(coursess.get(i).getTeacher().getFirstName());
        }
        courseTable.setModel(new DefaultTableModel(
                data,
                new String[]{"ID", "Name", "Units", "Teacher", "Time"}));

        ArrayList<Student> studentss = DataBase.getStudents();
        data = new String[studentss.size()][5];
        for (int i = 0; i < studentss.size(); i++)
        {
            data[i][0] = String.valueOf(studentss.get(i).getId());
            data[i][1] = studentss.get(i).getFirstName();
            data[i][2] = studentss.get(i).getLastName();
            data[i][3] = String.valueOf(studentss.get(i).getSex());
            data[i][4] = String.valueOf(studentss.get(i).getUnits());
        }

        studentTable.setModel(new DefaultTableModel(
                data,
                new String[]{"ID", "First Name", "Last Name", "Sex", "Units"}));


        List<Teacher> teacherss = DataBase.getTeachers();
        data = new String[teacherss.size()][5];
        for (int i = 0; i < teacherss.size(); i++)
        {
            data[i][0] = String.valueOf(teacherss.get(i).getId());
            data[i][1] = teacherss.get(i).getFirstName();
            data[i][2] = teacherss.get(i).getLastName();
            data[i][3] = String.valueOf(teacherss.get(i).getSex());
            data[i][4] = String.valueOf(teacherss.get(i).getUnits());
        }
        teacherTable.setModel(new DefaultTableModel(
                data,
                new String[]{"ID", "First Name", "Last Name", "Sex", "UnitS"}));
    }

    public static void main(String[] args)
    {
        AdminGUI adminGUI = new AdminGUI();
        adminGUI.show();
    }
}
