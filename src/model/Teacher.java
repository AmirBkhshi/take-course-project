package model;

import java.io.File;
import java.io.Serializable;
import java.util.Objects;

public class Teacher extends Person implements Serializable
{
    private static int idGenerator = 1 + DataBase.maxID("src\\data\\teachers.bin");

    public Teacher (String firstName, String lastName, char sex)
    {
        super(firstName, lastName, sex);
        id = idGenerator;
        idGenerator++;
    }

    public static int getIdGenerator()
    {
        return idGenerator;
    }

    public void addCourse (Course course)
    {
        courses.add(course);
    }

    public boolean setGrade(int studentId, int courseId, double grade)
    {
        for (Course course : courses)
        {
            if (course.getId() == courseId)
            {
                return course.setGrade(studentId, grade);
            }
        }
        return false;
    }

    public String getFullName()
    {
        return firstName + " " + lastName;
    }

    public boolean deleteCourse(Course course)
    {
        for (Course cou : courses)
        {
            if (cou.getId() == course.getId())
            {
                courses.remove(cou);
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString()
    {
        return "Teacher{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex +
                ", id=" + id +
                ", units=" + units +
                '}';
    }
}
