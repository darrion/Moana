package moanainc.com.moana.model;

import moanainc.com.moana.model.user.User;

/**
 * Created by darrion on 2/28/17.
 */

public interface Report {

    public String getName();
    public String getDate();
    public User getCreator();
    public Report createReport();
    public double getLat();
    public double getLng();
}