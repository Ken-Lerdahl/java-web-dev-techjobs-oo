package org.launchcode.techjobs_oo;

import java.util.Objects;

public abstract class JobField {
    private int id;
    private static int nextId = 1;
    private String value;

    public JobField() {
        this.id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

//    @Override
//    public boolean equals(Object o) {
//        Class thisClass = this.getClass();
//        if (this == o) return true;
//        if (!(o.getClass() == thisClass)) return false;
//        PositionType positionType = (PositionType) o;
//        return getId() == positionType.getId();
//    }

//    @Override
//    public boolean equals(Object o) {
//        Class<?> thisClass = this.getClass();
//        Class<?> thatClass = o.getClass();
//        if (this == o) return true;
//        if (!(thisClass.isInstance(o) )) return false;
//        if (!thatClass.isInstance(Employer)) {
//        }
//        Employer employer = (Employer) o;
//        return getId() == employer.getId();
//    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
