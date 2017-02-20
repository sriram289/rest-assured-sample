import com.sun.xml.internal.rngom.parse.host.Base;
import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getWinesTest extends BaseServiceTest{
    @Test
    public void assertListOfWinesIsRetrieved() {
        given()
                .get("/wines")
                .then()
                .assertThat()
                .body("name[0]",equalTo("CHATEAU DE SAINT COSME"))
                .body("year[0]",equalTo("2015"))
                .body("grapes[0]",equalTo("Grenache / Syrah"))
                .body("picture[0]",equalTo("saint_cosme.jpg"));
    }

    @Test
    public void assertNumberOfWinesAvailable() {
        given()
                .get("/wines")
                .then()
                .assertThat()
                .body("size()",equalTo(2));
    }

    @Test
    public void assertNumberOfValuesReturnedAsPartOfSingleWineElement() {
        given()
                .get("/wines")
                .then()
                .assertThat()
                .root("[0]")
                .body("size()",equalTo(8));
    }

}
