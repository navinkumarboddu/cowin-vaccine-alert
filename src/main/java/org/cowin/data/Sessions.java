package org.cowin.data;
public class Sessions
{
    private String date;

    private String vaccine;

    private String[] slots;

    private String min_age_limit;

    private String session_id;

    private String available_capacity;

    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }

    public String getVaccine ()
    {
        return vaccine;
    }

    public void setVaccine (String vaccine)
    {
        this.vaccine = vaccine;
    }

    public String[] getSlots ()
    {
        return slots;
    }

    public void setSlots (String[] slots)
    {
        this.slots = slots;
    }

    public String getMin_age_limit ()
    {
        return min_age_limit;
    }

    public void setMin_age_limit (String min_age_limit)
    {
        this.min_age_limit = min_age_limit;
    }

    public String getSession_id ()
    {
        return session_id;
    }

    public void setSession_id (String session_id)
    {
        this.session_id = session_id;
    }

    public String getAvailable_capacity ()
    {
        return available_capacity;
    }

    public void setAvailable_capacity (String available_capacity)
    {
        this.available_capacity = available_capacity;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [date = "+date+", vaccine = "+vaccine+", slots = "+slots+", min_age_limit = "+min_age_limit+", session_id = "+session_id+", available_capacity = "+available_capacity+"]";
    }
}