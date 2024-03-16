package model;

import java.io.File;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course implements Serializable
{
    private static int idGenerator = 1 + DataBase.maxID("src\\data\\courses.bin");
    private String courseName;
    private int id;
    private int units;
    private CourseTime time;
    private Teacher teacher;
    private List<Student> students;

    public Course (String courseName, int units, CourseTime courseTime, Teacher teacher)
    {
        this.courseName = courseName;
        this.units = units;
        this.time = courseTime;
        this.teacher = teacher;
        this.teacher.addCourse(this);
        this.students = new ArrayList<>();
        id = idGenerator;
        idGenerator++;
    }


    public static int getIdGenerator ()
    {
        return idGenerator;
    }

    public static void setIdGenerator (int idGenerator)
    {
        Course.idGenerator = idGenerator;
    }

    public String getCourseName ()
    {
        return courseName;
    }

    public void setCourseName (String courseName)
    {
        this.courseName = courseName;
    }

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public int getUnits ()
    {
        return units;
    }

    public void setUnits (int units)
    {
        this.units = units;
    }

    public CourseTime getTime ()
    {
        return time;
    }

    public void setTime (CourseTime time)
    {
        this.time = time;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj instanceof Course course)
        {
            return course.getId() == this.getId();
        }
        return false;
    }

    public boolean setGrade (int studentId, double grade)
    {
        for (Student student : students)
        {
            if (student.getId() == studentId)
            {
                return student.setGrade(id, grade);
            }
        }
        return false;
    }

    public void addStudent (Student student)
    {
        students.add(student);
    }

    public Student[] sortByGrade()
    {
        Student[] sortedStudents = new Student[students.size()];
        for (int i = 0; i < students.size(); i++)
        {
            sortedStudents[i] = students.get(i);
        }
        for (int i = 0; i < sortedStudents.length; i++)
        {
            for (int j = i + 1; j < sortedStudents.length; j++)
            {
                if (sortedStudents[i].getGrade(id) > sortedStudents[j].getGrade(id))
                {
                    Student temp = sortedStudents[i];
                    sortedStudents[i] = sortedStudents[j];
                    sortedStudents[j] = temp;
                }
            }
        }
        return sortedStudents;
    }

    public Student getStudent(int studentId)
    {
        for (Student student : students)
        {
            if (student.getId() == studentId)
            {
                return student;
            }
        }
        return null;
    }

    public Student maxGrade()
    {
        Student maxGradeStudent = null;
        double maxGrade = 0;
        for (Student student : students)
        {
            if (student.getGrade(id) > maxGrade)
            {
                maxGrade = student.getGrade(id);
                maxGradeStudent = student;
            }
        }
        return maxGradeStudent;
    }

    public Student minGrade()
    {
        Student minGradeStudent = null;
        double minGrade = 20;
        for (Student student : students)
        {
            if (student.getGrade(id) < minGrade)
            {
                minGrade = student.getGrade(id);
                minGradeStudent = student;
            }
        }
        return minGradeStudent;
    }

    public boolean isConflict (Course course)
    {
        return this.time.isConflict(course.getTime());
    }

    public Student[] failes()
    {
        List<Student> fails = new ArrayList<>();
        for (Student student : students)
        {
            if (student.getGrade(id) < 10)
            {
                fails.add(student);
            }
        }
        return fails.toArray(new Student[0]);
    }

    public Teacher getTeacher()
    {
        return teacher;
    }

    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    @Override
    public String toString()
    {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", id=" + id +
                ", units=" + units +
                ", time=" + time +
                ", teacher=" + teacher +
                ", students=" + students +
                '}';
    }
}
