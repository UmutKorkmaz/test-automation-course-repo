import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Epic("Kullanıcı Yönetimi")
@Feature("Kullanıcı Oluşturma")
public class CreateUserTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://demoqa.com";
    }

    @Test
    @Story("Geçerli kullanıcı bilgileri ile yeni bir kullanıcı oluşturma")
    @Description("Bu test, geçerli kullanıcı bilgileri kullanarak yeni bir kullanıcı oluşturur ve oluşturulan kullanıcının detaylarını doğrular.")
    public void testCreateUser() {
        String requestBody = "{\n" +
                "  \"userName\": \"testUser_" + System.currentTimeMillis() + "\",\n" + // Benzersiz bir kullanıcı adı sağlamak için
                "  \"password\": \"Test@123\"\n" +
                "}";

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(requestBody).
                when().
                post("/Account/v1/User").
                then().
                statusCode(201).
                body("username", startsWith("testUser_")).
                body("books", is(empty()));
    }
}
