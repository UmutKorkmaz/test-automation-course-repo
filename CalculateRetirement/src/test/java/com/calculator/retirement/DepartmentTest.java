package test.java.com.calculator.retirement;

import main.java.com.calculator.retirement.Department;
import main.java.com.calculator.retirement.Male;
import main.java.com.calculator.retirement.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class DepartmentTest {

    private Department department;
    private Person teamLead;

    @BeforeEach
    public void setUp() {
        teamLead = new Male("TestLead", "Leader", LocalDate.of(1970, 1, 1));
        department = new Department(teamLead);
    }

    @Test
    public void whenAddPersonnel_thenPersonnelIsAdded() {
        Person newPerson = new Male("John", "Doe", LocalDate.of(1980, 1, 1));
        department.addPersonnel(newPerson);
        assertTrue(department.getPersonelList().contains(newPerson));
    }

    @Test
    public void whenRemovePersonnel_thenPersonnelIsRemoved() {
        Person person = new Male("Jane", "Doe", LocalDate.of(1990, 1, 1));
        department.addPersonnel(person);
        department.removePersonnel(person);
        assertFalse(department.getPersonelList().contains(person));
    }

    @Test
    public void whenChangeTeamLead_thenTeamLeadIsChanged() {
        Person newLead = new Male("NewLeader", "Smith", LocalDate.of(1985, 1, 1));
        department.changeTeamLead(newLead);
        assertEquals(newLead, department.getTeamLead());
    }

    @Test
    public void whenAddAssignment_thenAssignmentIsAdded() {
        String assignment = "New Project";
        department.addAssignment(assignment);
        assertTrue(department.getAssignmentList().contains(assignment));
    }

    @Test
    public void whenMarkAssignmentCompleted_thenAssignmentIsRemoved() {
        String assignment = "Complete Report";
        department.addAssignment(assignment);
        department.markAssignmentCompleted(assignment);
        assertFalse(department.getAssignmentList().contains(assignment));
    }
}
