package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job job1;
    Job job2;

    @Before
    public void createJobObjects() {
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job2 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));

    }

    @Test
    public void testSettingJobId() {
//        assertNotSame(job1.getId(), job2.getId());
        assertEquals(job1.getId() + 1, job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertNotNull(String.valueOf(job1.getId()));
        assertEquals("Product tester", job1.getName());
        assertEquals("ACME", job1.getEmployer().getValue());
        assertEquals("Desert", job1.getLocation().getValue());
        assertEquals("Quality control", job1.getPositionType().getValue());
        assertEquals("Persistence", job1.getCoreCompetency().getValue());
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test
    public void testJobsForEquality() {
        Job jobA = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobBIdenticalToJobA = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(jobA.equals(jobBIdenticalToJobA));
    }

    //TODO: Test toString on job, creates blank line before and after job info
    @Test
    public void testToStringForBlankLines() {
        String blankLine = "\n";
        Job newJobToTestBlankLines = new Job();
        assertEquals(blankLine.toCharArray()[0], newJobToTestBlankLines.toString().toCharArray()[0]);
    }

    //TODO: Test toString on job, contains label for each job, followed by the data stored
    @Test
    public void testForLabelsAndData() {
        Job jobToTestLabelsAndData = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence")) ;
        assertTrue(jobToTestLabelsAndData.toString().contains("Name: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n"));
    }

    //TODO: Test toString on job, if field is empty, prints "Data not available" after label;
    @Test
    public void testLabelLeftBlankInInitialization() {
        Job jobToTestBlankLabel = new Job("Paper Salesman", new Employer("Dunder Mifflin"), new Location("Scranton"), new PositionType(), new CoreCompetency("Jello Molds"));
        assertTrue(jobToTestBlankLabel.toString().contains("Position Type: Data not available"));
    }

    //TODO: Test toString on job, if Job only contains ID, returns "OOPS! This job does not seem to exist."
    @Test
    public void testJobWithZeroArgs() {
        Job blankJobNoArgs = new Job();
        assertEquals("\nOOPS! This job does not seem to exist.", blankJobNoArgs.toString());
    }
}
