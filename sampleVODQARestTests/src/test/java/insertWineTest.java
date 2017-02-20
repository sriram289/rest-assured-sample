import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class insertWineTest extends BaseServiceTest {


    @Test
    public void assertInsertionOfWine() {
        given()
                .spec(requestSpecification)
                .body("{\"name\":\"CHATEAU DE SAINT COSME 1\",\"year\":\"2015\",\"grapes\":\"Grenache / Syrah\",\"country\":\"India\",\"region\":\"Asia\",\"description\":\"The aromas of fruit and spice...\",\"picture\":\"saint_cosme.jpg\"}")
                .when()
                .post("/wines")
                .then()
                .assertThat()
                .statusCode(200);
        given()
                .pathParam("name", "CHATEAU DE SAINT COSME 1")
                .when()
                .get("/wines/{name}")
                .then()
                .assertThat()
                .body("name", equalTo("CHATEAU DE SAINT COSME 1"));
    }
}
