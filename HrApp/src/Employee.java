
public class Employee {
    private String name;
    private String jobTitle;

    public Employee(String name, String jobTitle) {
        this.name = name;
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", jobTitle=" + jobTitle + '}';
    }
}
