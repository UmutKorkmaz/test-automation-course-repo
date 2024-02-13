package test.java.com.calculator.retirement;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfig {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = TestConfig.class.getClassLoader().getResourceAsStream("test.properties")) {
            if (input == null) {
                throw new IllegalStateException("test.properties file not found in classpath");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Could not load test properties", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
