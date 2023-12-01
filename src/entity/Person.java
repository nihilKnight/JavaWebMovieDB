package entity;

import util.GenderException;

public class Person {
    public Integer id;
    public String name;
    public int gender;

    public Integer getId() { return this.id; }

    public String getName() { return this.name; }

    public int getGender() { return this.gender; }

    public void setId(Integer id) { this.id = id; }

    public void setName(String name) { this.name=name; }

    public void setGender(int gender) {
        try {
            if (! (gender == 0 || gender == 1 || gender == 2) )
                throw new GenderException("The given gender is invalid; ensure its value lies in {0, 1, 2}.");
        } catch (GenderException ge) {
            ge.printStackTrace();
        }
        this.gender = gender;
    }
}
