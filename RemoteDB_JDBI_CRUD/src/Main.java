import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.Update;

public class Main {
    public static void main(String[] args) {
        // Veritabanı bağlantısı
        Jdbi jdbi = Jdbi.create("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11678198", "sql11678198", "wVJ6TIBGWB");

        // JDBI ile işlemler
        jdbi.useHandle(handle -> {
            // Tablo Oluşturma
            handle.execute("CREATE TABLE IF NOT EXISTS ad_soyad (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), age INT)");

            // Veri Ekleme
            handle.createUpdate("INSERT INTO ad_soyad (name, age) VALUES (:name, :age)")
                    .bind("name", "Ali Veli")
                    .bind("age", 30)
                    .execute();

            handle.createUpdate("INSERT INTO ad_soyad (name, age) VALUES (:name, :age)")
                    .bind("name", "Ayşe Yılmaz")
                    .bind("age", 25)
                    .execute();

            handle.createUpdate("INSERT INTO ad_soyad (name, age) VALUES (:name, :age)")
                    .bind("name", "Mehmet Öz")
                    .bind("age", 40)
                    .execute();

            // Veri Güncelleme
            Update update = handle.createUpdate("UPDATE ad_soyad SET age = :age WHERE name = :name")
                    .bind("name", "Ali Veli")
                    .bind("age", 35);
            update.execute();

            // Veri Silme
            handle.createUpdate("DELETE FROM ad_soyad WHERE name = :name")
                    .bind("name", "Ayşe Yılmaz")
                    .execute();
        });
    }
}
