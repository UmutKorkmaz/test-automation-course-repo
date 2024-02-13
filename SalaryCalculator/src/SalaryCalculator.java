

public class SalaryCalculator {

    // Sabit günlük maaş miktarı, örneğin 200 TL
    private static final int DAILY_WAGE = 200;
    // Ekstra prim miktarı, her fazla gün için 1000 TL
    private static final int BONUS_PER_EXTRA_DAY = 1000;
    // Ay içinde ekstra prim kazanmak için gereken minimum gün sayısı
    private static final int MIN_DAYS_FOR_BONUS = 25;

    /**
     * Çalışanın maaşını hesaplar.
     *
     * @param workingDays Bu ay içinde çalışılan gün sayısı.
     * @return Toplam maaş miktarı.
     */
    public static int calculateSalary(int workingDays) {
        int salary = workingDays * DAILY_WAGE;
        int extraDays = workingDays - MIN_DAYS_FOR_BONUS;

        if (extraDays > 0) {
            salary += extraDays * BONUS_PER_EXTRA_DAY;
        }

        return salary;
    }

    public static void main(String[] args) {
        // Test
        int workingDays = 27; // Örnek çalışma günü sayısı
        int salary = calculateSalary(workingDays);
        System.out.println("Toplam Maaş: " + salary + " TL");
    }
}
