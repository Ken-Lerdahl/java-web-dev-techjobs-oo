package org.launchcode.techjobs_oo;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {

        String blankLine = System.lineSeparator();
        StringBuilder formattedProperly = new StringBuilder(blankLine);
        HashMap<String, String> jobParser = new LinkedHashMap<>();
        int emptyFieldCounter = 0;
        String emptyFieldString = "Data not available";
        String jobDoesNotExist = blankLine + "OOPS! This job does not seem to exist.";

        try {
            jobParser.put("ID: ", String.valueOf(this.getId()));
        }
        catch (NullPointerException e) {
            return formattedProperly + jobDoesNotExist;
        }
        try {
                jobParser.put("Name: ", this.getName());
        }
        catch (NullPointerException e) {
            jobParser.put("Name: ", emptyFieldString);
            emptyFieldCounter++;
        }
        try {
            jobParser.put("Employer: ", this.getEmployer().getValue());
        }
        catch (NullPointerException e) {
            jobParser.put("Employer: ", emptyFieldString);
            emptyFieldCounter++;
        }
        try {
            jobParser.put("Location: ", this.getLocation().getValue());
        }
        catch (NullPointerException e) {
            jobParser.put("Location: ", emptyFieldString);
            emptyFieldCounter++;
        }
        try {
            if (this.getPositionType().getValue().equals("")) {
                jobParser.put("Position Type: ", emptyFieldString);
                emptyFieldCounter++;
            } else {
                jobParser.put("Position Type: ", this.getPositionType().getValue());
            }
        }
        catch (NullPointerException e) {
            jobParser.put("Position Type: ", emptyFieldString);
            emptyFieldCounter++;
        }
        try {
            jobParser.put("Core Competency: ", this.getCoreCompetency().getValue());
        }
        catch (NullPointerException e) {
            jobParser.put("Core Competency: ", emptyFieldString);
            emptyFieldCounter++;
        }
        finally {
            if (emptyFieldCounter == (jobParser.size() - 1)) {
                return jobDoesNotExist;
            }
        }

        for (Map.Entry<String, String> job : jobParser.entrySet()) {
            if (job.getValue() == null  || job.getValue().equals("")) {
                formattedProperly.append(job.getKey()).append(emptyFieldString).append(blankLine);
                emptyFieldCounter++;
            } else {
                formattedProperly.append(job.getKey()).append(job.getValue()).append(blankLine);
            }
        }
        if (emptyFieldCounter == (jobParser.size() - 1)) {
            return jobDoesNotExist;
        } else {
            return formattedProperly.toString();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }
}
