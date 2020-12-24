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

    }
}
