package day04;
import org.junit.jupiter.api.*;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;

public class LibraryAppTest {

    @BeforeAll
    public static void setUp(){
        baseURI = "http://library1.cybertekschool.com";
        basePath = "/rest/v1" ;
    }

    @AfterAll
    public static void tearDown(){
        reset();
    }

    @DisplayName("Testing POST /login Endpoint")
    @Test
    public void testLogin() {
        /*
        Librarian1  email	librarian69@library
        Librarian1  password		KNPXrm3S
         */

       String myToken =
                given()
                        .log().all()
                        .contentType( ContentType.URLENC  )
                        .formParam("email", "librarian69@library")
                        .formParam("password","KNPXrm3S").
                when()
                        .post("/login").
                then()
                        .log().all()
                        .assertThat()
                        .statusCode( is(200))
                        .contentType(ContentType.JSON)
                        .body("token", is( not( emptyString() ) )  )
                    .extract()
                        .jsonPath()
                        .getString("token")
        ;
        System.out.println("myToken = \n" + myToken);
        // How to extract some data out of response object
        // after doing validation in then section
        // without breaking the chain -->> use extract() method that return
    }



}
