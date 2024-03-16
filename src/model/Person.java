package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Person implements Serializable
{
    protected String firstName;
    protected String lastName;
    protected char sex;
    protected List<Course> courses;
    protected int id;
    protected int units;

    public Person (String firstName, String lastName, char sex)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.courses = new ArrayList<>();
        this.units = 0;
    }

    public String getFirstName ()
    {
        return firstName;
    }

    public void setFirstName (String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName ()
    {
        return lastName;
    }

    public void setLastName (String lastName)
    {
        this.lastName = lastName;
    }

    public char getSex ()
    {
        return sex;
    }

    public void setSex (char sex)
    {
        this.sex = sex;
    }

    public List<Course> getCourses ()
    {
        return courses;
    }

    public void setCourses (List<Course> courses)
    {
        this.courses = courses;
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
}
