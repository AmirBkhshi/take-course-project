package model;

public class CourseTime
{
    private ClassTime classTime;
    private Day day;

    public CourseTime (ClassTime classTime, Day day)
    {
        this.classTime = classTime;
        this.day = day;
    }

    public ClassTime getClassTime ()
    {
        return classTime;
    }

    public void setClassTime (ClassTime classTime)
    {
        this.classTime = classTime;
    }

    public Day getDay ()
    {
        return day;
    }

    public void setDay (Day day)
    {
        this.day = day;
    }

    public boolean isConflict (CourseTime courseTime)
    {
        if (this.day == courseTime.getDay())
        {
            if (this.classTime.getBegin().before(courseTime.getClassTime().getEnd()) && this.classTime.getEnd().after(courseTime.getClassTime().getBegin()))
            {
                return true;
            }
        }
        return false;
    }
}
