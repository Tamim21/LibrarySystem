package com.mycompany.assign3;
import java.util.ArrayList;
import java.util.Date;

public abstract class User
{
    private String ID = null;
    private String Name = null;

    public String getID()
    {
        return ID;
    }
    
    public void setID(String ID)
    {
        this.ID = ID;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public abstract String lineRepresentation();
    public abstract String getSearchKey();
}
