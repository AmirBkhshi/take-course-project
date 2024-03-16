package model;

import java.sql.Time;

public class ClassTime
{
    private Time begin;
    private Time end;

    public ClassTime (int beginHour, int beginMinute, int endHour, int endMinute)
    {
        this.begin = new Time(beginHour, beginMinute, 0);
        this.end = new Time(endHour, endMinute, 0);
    }

    public Time getBegin ()
    {
        return begin;
    }

    public void setBegin (Time begin)
    {
        this.begin = begin;
    }

    public Time getEnd ()
    {
        return end;
    }

    public void setEnd (Time end)
    {
        this.end = end;
    }
}
