package org.launchcode.techjobs.oo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import static org.junit.Assert.*;
//import org.junit.Assert;
import org.junit.Test;

import javax.xml.namespace.QName;


public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        String msg = "verifies that the ID's of two objects are distinct.";
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        String msg = "Constructor correctly assigns both the class and value of each field. ";
        Job aJob = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertEquals("Product Tester", aJob.getName());
        assertEquals("ACME", aJob.getEmployer().getValue());
        assertEquals("Desert", aJob.getLocation().getValue());
        assertEquals("Quality Control", aJob.getPositionType().getValue());
        assertEquals("Persistence", aJob.getCoreCompetency().getValue());

        assertTrue(aJob.getName() instanceof String);
        assertTrue(aJob.getEmployer() instanceof Employer);
        assertTrue(aJob.getLocation() instanceof Location);
        assertTrue(aJob.getPositionType() instanceof PositionType);
        assertTrue(aJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.getId() == (job2.getId()));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        // Create a Job object with some data
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        // Define the expected string format
        String expectedString = System.lineSeparator() +
                "ID: " + job.getId() + System.lineSeparator() +
                "Name: " + job.getName() + System.lineSeparator() +
                "Employer: " + job.getEmployer() + System.lineSeparator() +
                "Location: " + job.getLocation() + System.lineSeparator() +
                "Position Type: " + job.getPositionType() + System.lineSeparator() +
                "Core Competency: " + job.getCoreCompetency() + System.lineSeparator();

        // Test that the toString method produces the expected format
        assertEquals(expectedString, job.toString());
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        // Create a Job object with some data
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        // Get the string representation using toString()
        String jobString = job.toString();

        // Test that the string contains correct labels and data
        assertTrue(jobString.contains(System.lineSeparator() + "ID: " + job.getId() + System.lineSeparator()));
        assertTrue(jobString.contains(System.lineSeparator() + "Name: " + job.getName() + System.lineSeparator()));
        assertTrue(jobString.contains(System.lineSeparator() + "Employer: " + job.getEmployer() + System.lineSeparator()));
        assertTrue(jobString.contains(System.lineSeparator() + "Location: " + job.getLocation() + System.lineSeparator()));
        assertTrue(jobString.contains(System.lineSeparator() + "Position Type: " + job.getPositionType() + System.lineSeparator()));
        assertTrue(jobString.contains(System.lineSeparator() + "Core Competency: " + job.getCoreCompetency() + System.lineSeparator()));
    }

    @Test
    public void testToStringHandlesEmptyField() {

        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

        String expectedString = System.lineSeparator() +
                "ID: " + job.getId() + System.lineSeparator() +
                "Name: " + (job.getName().isEmpty() ? "Data not available" : job.getName()) + System.lineSeparator() +
                "Employer: " + (job.getEmployer().getValue().isEmpty() ? "Data not available" : job.getEmployer()) + System.lineSeparator() +
                "Location: " + (job.getLocation().getValue().isEmpty() ? "Data not available" : job.getLocation()) + System.lineSeparator() +
                "Position Type: " + (job.getPositionType().getValue().isEmpty() ? "Data not available" : job.getPositionType()) + System.lineSeparator() +
                "Core Competency: " + (job.getCoreCompetency().getValue().isEmpty() ? "Data not available" : job.getCoreCompetency()) + System.lineSeparator();

        assertEquals(expectedString, job.toString());
    }

}
