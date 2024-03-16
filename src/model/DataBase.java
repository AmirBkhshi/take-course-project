package model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBase
{
    public static final String studentUrl = "src\\data\\student\\";
    public static final String teacherUrl = "src\\data\\teacher\\";
    public static final String courseUrl = "src\\data\\courses\\";
    public static void save(Object object) throws IOException
    {
        if (object instanceof Course course)
        {
            save(courseUrl, course);
        }
        else if (object instanceof Student student)
        {
            save(studentUrl, student);
        }
        else if (object instanceof Teacher teacher)
        {
            save(teacherUrl, teacher);
        }
    }

    public static void delete(String url, int id)
    {
        Path path = Path.of(url + id + ".bin");
        if (!Files.exists(path))
        {
            return;
        }
        try
        {
            Files.delete(path);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void delete(Object object) throws IOException
    {
        if (object instanceof Course course)
        {
            delete(courseUrl, course.getId());
        }
        else if (object instanceof Student student)
        {
            delete(studentUrl, student.getId());
        }
        else if (object instanceof Teacher teacher)
        {
            delete(teacherUrl, teacher.getId());
        }
    }

    public static Student getStudent(int id) throws IOException, ClassNotFoundException
    {
        return (Student) get(studentUrl, id);
    }

    private static Object get(String url, int id)
    {
        if (!Files.exists(Path.of(url + id + ".bin")))
        {
            return null;
        }

        try
        {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(url + id + ".bin"));
            return objectInputStream.readObject();
        }
        catch (IOException | ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }

    }

    public static Teacher getTeacher(int id) throws IOException, ClassNotFoundException
    {
        return (Teacher) get(teacherUrl, id);
    }

    public static Course getCourse(int id) throws IOException, ClassNotFoundException
    {
        return (Course) get(courseUrl, id);
    }

    private static void save(String url, Object object)
    {
        try
        {
            if (object instanceof Teacher teacher)
            {
                FileOutputStream fileOutputStream = new FileOutputStream(url + teacher.getId() + ".bin");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(teacher);
                objectOutputStream.close();
                fileOutputStream.close();
            }
            else if (object instanceof Student student)
            {
                FileOutputStream fileOutputStream = new FileOutputStream(url + student.getId() + ".bin");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(student);
                objectOutputStream.close();
                fileOutputStream.close();
            }
            else if (object instanceof Course course)
            {
                FileOutputStream fileOutputStream = new FileOutputStream(url + course.getId() + ".bin");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(course);
                objectOutputStream.close();
                fileOutputStream.close();
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static int maxID(String url)
    {
        if (!Files.exists(Path.of(url)))
        {
            return 0;
        }
        File file = new File(url);
        String[] files = file.list();
        int max = 0;
        for (String s : files)
        {
            int dot = s.indexOf('.');
            int id = Integer.parseInt(s.substring(8, dot));
            if (id > max)
            {
                max = id;
            }
        }
        return max;
    }

    public static ArrayList<Teacher> getTeachers()
    {
        ArrayList<Teacher> teachers = new ArrayList<>();
        File file = new File(teacherUrl);
        String[] files = file.list();
        for (String s : files)
        {
            try
            {
                FileInputStream fileInputStream = new FileInputStream(teacherUrl + s);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Teacher teacher = (Teacher) objectInputStream.readObject();
                teachers.add(teacher);
            }
            catch (ClassNotFoundException | IOException e)
            {
                throw new RuntimeException(e);
            }
        }
        return teachers;
    }

    public static ArrayList<Student> getStudents()
    {
        ArrayList<Student> students = new ArrayList<>();
        File file = new File(studentUrl);
        String[] files = file.list();
        for (String s : files)
        {
            try
            {
                FileInputStream fileInputStream = new FileInputStream(studentUrl + s);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Student student = (Student) objectInputStream.readObject();
                students.add(student);
            }
            catch (ClassNotFoundException | IOException e)
            {
                throw new RuntimeException(e);
            }
        }
        return students;
    }

    public static ArrayList<Course> getCourses()
    {
        ArrayList<Course> courses = new ArrayList<>();
        File file = new File(courseUrl);
        String[] files = file.list();
        for (String s : files)
        {
            try
            {
                FileInputStream fileInputStream = new FileInputStream(courseUrl + s);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Course course = (Course) objectInputStream.readObject();
                courses.add(course);
            }
            catch (ClassNotFoundException | IOException e)
            {
                throw new RuntimeException(e);
            }
        }
        return courses;
    }
}
