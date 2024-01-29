public class DatabaseConnection {
    // Tek nesne örneği
    private static DatabaseConnection instance;

    // Database bağlantı detayları
    private String url;
    private String username;
    private String password;

    // Constructor özel olarak tanımlanır, böylece dışarıdan erişilemez
    private DatabaseConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // Nesne örneğine erişmek için statik metod
    public static DatabaseConnection getInstance(String url, String username, String password) {
        if (instance == null) {
            instance = new DatabaseConnection(url, username, password);
        }
        return instance;
    }

    public void connect() {
        // Database bağlantı işlemleri
        System.out.println("Bağlanılan veritabanı: " + url);
        System.out.println("Bağlanan kullanıcı: " + username);
        System.out.println("Bağlanan kullanıcı şifresi: " + password);
    }
}
