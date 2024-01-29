public class Main {
    public static void main(String[] args) {
        // Kullanım örneği:
        DatabaseConnection.getInstance("jdbc:mysql://localhost:3306/myDb", "user", "pass").connect();
    }
}
