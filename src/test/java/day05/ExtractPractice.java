package day05;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.*;
import java.util.List;

import static io.restassured.RestAssured.* ;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.* ;
public class ExtractPractice {

    /*
     extract() method of RestAssured
     enable you to extract data after validation
     in then section of the method chaining
     */
    @BeforeAll
    public static void setUp(){
        baseURI = "http://54.90.101.103:8000";
        basePath = "/api" ;
    }

    @AfterAll
    public static void tearDown(){
        reset();
    }

    @DisplayName("Testing GET /api/spartans/search with Basic auth")
    @Test
    public void testSearchAndExtractData(){





    }
}