package org.cowin.data;
public class SelCalenderByPinSessions
{
    private String date;

    private String vaccine;

    private String[] slots;

    private String min_age_limit;

    private String session_id;

    private String available_capacity;

    private String available_capacity_dose2;

    private String available_capacity_dose1;
    
    private boolean allow_all_age;

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

    public String getAvailable_capacity_dose2 ()
    {
        return available_capacity_dose2;
    }

    public void setAvailable_capacity_dose2 (String available_capacity_dose2)
    {
        this.available_capacity_dose2 = available_capacity_dose2;
    }

    public String getAvailable_capacity_dose1 ()
    {
        return available_capacity_dose1;
    }

    public void setAvailable_capacity_dose1 (String available_capacity_dose1)
    {
        this.available_capacity_dose1 = available_capacity_dose1;
    }

    public boolean isAllow_all_age() {
		return allow_all_age;
	}

	public void setAllow_all_age(boolean allow_all_age) {
		this.allow_all_age = allow_all_age;
	}

	@Override
    public String toString()
    {
        return "ClassPojo [date = "+date+", vaccine = "+vaccine+", slots = "+slots+", min_age_limit = "+min_age_limit+", session_id = "+session_id+", available_capacity = "+available_capacity+", available_capacity_dose2 = "+available_capacity_dose2+", available_capacity_dose1 = "+available_capacity_dose1+"]";
    }
}