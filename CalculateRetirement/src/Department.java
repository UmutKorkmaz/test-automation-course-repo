import java.util.ArrayList;
import java.util.List;

public class Department {
    private Person teamLead;
    private final List<Person> personelList;
    private final List<String> assignmentList;

    public Department(Person teamLead) {
        if (teamLead == null) {
            throw new IllegalArgumentException("Takım lideri zorunludur!");
        }
        this.teamLead = teamLead;
        this.personelList = new ArrayList<>();
        this.assignmentList = new ArrayList<>();
    }

    public void changeTeamLead(Person newLead) {
        if (newLead == null) {
            throw new IllegalArgumentException("Yeni takım lideri null olamaz");
        }
        this.teamLead = newLead;
    }

    public void addPersonnel(Person person) {
        personelList.add(person);
    }

    public void removePersonnel(Person person) {
        personelList.remove(person);
    }

    public void addAssignment(String assignment) {
        assignmentList.add(assignment);
    }

    public void markAssignmentCompleted(String assignment) {
        assignmentList.remove(assignment);
    }

    public Person getTeamLead() {
        return teamLead;
    }

    public List<Person> getPersonelList() {
        return new ArrayList<>(personelList);
    }

    public List<String> getAssignmentList() {
        return new ArrayList<>(assignmentList);
    }
}
