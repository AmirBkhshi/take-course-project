package model;

public enum Day
{
    Saturday(1), Sunday(2), Monday(3), Tuesday(4), Wednesday(5), Thursday(6), Friday(7);
    private final int id;

    Day (int id)
    {
        this.id = id;
    }

    public int getId ()
    {
        return id;
    }

    public static Day getDay (int id)
    {
        for (Day day : Day.values())
        {
            if (day.getId() == id)
            {
                return day;
            }
        }
        return null;
    }
}
