package model;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class Student extends Person implements Serializable
{
    private HashMap<Integer, Double> grades;
    private static int idGenerator = 1 + DataBase.maxID("src\\data\\student.bin");
    public Student (String firstName, String lastName, char sex)
    {
        super(firstName, lastName, sex);
        id = idGenerator;
        idGenerator++;
        grades = new HashMap<>();
    }

    public static int getIdGenerator()
    {
        return idGenerator;
    }

    public boolean setGrade(int courseId, double grade)
    {
        if (grade >= 0 && grade <= 20)
        {
            grades.put(courseId, grade);
            return true;
        }
        return false;
    }

    public double getGrade(int courseId)
    {
        return grades.get(courseId);
    }

    public HashMap<Integer, Double> getGrades()
    {
        return grades;
    }

    public void setGrades(HashMap<Integer, Double> grades)
    {
        this.grades = grades;
    }

    public double getAverage()
    {
        double sum = 0;
        for (Double grade : grades.values())
        {
            sum += grade;
        }
        return sum / grades.size();
    }

    public String getFullName()
    {
        return firstName + " " + lastName;
    }

    public boolean addCourse(Course course)
    {
        for (Course c : courses)
        {
            if (c.isConflict(course))
            {
                return false;
            }
        }

        courses.add(course);
        this.units += course.getUnits();
        return true;
    }

    public boolean deleteCourse(int parseInt)
    {
        for (Course c : courses)
        {
            if (c.getId() == parseInt)
            {
                courses.remove(c);
                this.units -= c.getUnits();
                return true;
            }
        }
        return false;
    }

    public void addGrade(Course course, double grade)
    {
        grades.put(course.getId(), grade);
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex +
                ", id=" + id +
                ", units=" + units +
                '}';
    }
}

