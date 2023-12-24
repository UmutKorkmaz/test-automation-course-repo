
public class Main {
    public static void main(String[] args) {
        Department itDepartment = new Department("IT");

        itDepartment.addEmployee(new Employee("Ahmet", "Software Engineer"));
        itDepartment.addEmployee(new Employee("Mehmet", "System Administrator"));

        System.out.println("Çalışanlar Listesi: " + itDepartment.getName() + " Departmanı");
        for (Employee emp : itDepartment.getEmployees()) {
            System.out.println(emp);
        }
    }
}