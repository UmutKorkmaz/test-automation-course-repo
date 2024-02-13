package main.java.com.calculator.retirement;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Takım Lideri ve Personel Oluşturma
        Male teamLead = new Male("Ahmet", "Yılmaz", LocalDate.of(1980, 1, 1));
        Female personel1 = new Female("Ayşe", "Kara", LocalDate.of(1990, 5, 15));
        Male personel2 = new Male("Mehmet", "Can", LocalDate.of(1985, 8, 20));

        // Departman Oluşturma ve Personel Ekleme
        Department department = new Department(teamLead);
        department.addPersonnel(personel1);
        department.addPersonnel(personel2);

        // Görevler Ekleme
        department.addAssignment("Proje Raporu Hazırlama");
        department.addAssignment("Müşteri Sunumu");

        // Görevleri ve Takımı Yazdırma
        System.out.println("Takım Lideri: " + department.getTeamLead().getName());
        System.out.println("Personel Listesi: ");
        for (Person personel : department.getPersonelList()) {
            System.out.println(personel.getName() + " " + personel.getSurname());
        }
        System.out.println("Atanmış Görevler: " + Arrays.toString(department.getAssignmentList().toArray()));

        // Emeklilik Yaşı Hesaplama
        System.out.println(teamLead.getName() + " çalışanının emeklilik için kalan yılı: " + teamLead.calculateRetirementYears());
        System.out.println(personel1.getName() + " çalışanının emeklilik için kalan yılı: " + personel1.calculateRetirementYears());
    }
}
