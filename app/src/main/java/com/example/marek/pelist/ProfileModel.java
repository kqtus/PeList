package com.example.marek.pelist;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;

/**
 * Created by Marek on 18.03.2018.
 */

public class ProfileModel implements Serializable {
    private String firstName;
    private String secondName;
    private Date birthDate;

    public ProfileModel(String firstName, String secondName, Date birthDate) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getFullName() {
        return firstName + " " + secondName;
    }

    public Integer getAge() {
        Calendar calendar =  Calendar.getInstance();
        return calendar.get(Calendar.YEAR) - birthDate.getYear() + 1;
    }
}
