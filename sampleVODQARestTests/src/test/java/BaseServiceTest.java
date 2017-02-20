import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseServiceTest {
    RequestSpecification requestSpecification;
    @Before
    public void basicSetUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8081;
        requestSpecification = new RequestSpecBuilder()
                .addHeader("Content-Type","application/json")
                .build();
    }
}
