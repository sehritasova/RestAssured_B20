package day04;
import io.restassured.RestAssured;
import org.junit.jupiter.api.*;
import io.restassured.http.ContentType;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;


public class SpartanAddingTest {

    @BeforeAll
    public static void setUp(){
        baseURI = "http://54.90.101.103:8000";
        basePath = "/api" ;
    }

    @AfterAll
    public static void tearDown(){
        reset();
    }

    @DisplayName("Testing GET /api/spartans with Basic auth")
    @Test
    public void testAllSpartanWithBasicAuth(){

        given()
                .log().all()
                .auth().basic("admin","admin").
        when()
                .get("/spartans").
        then()
                .log().all()
                .statusCode( is(200) ) ;

    }
    @DisplayName("Add 1 Data with Raw Json String POST/api/spartans")
    @Test
    public void testAddOneData(){
       /*
            {
                "name": "Gulbadan",
                "gender": "Male",
                "phone": 9876543210
            }
         */

        String newSpartanStr =  "    {\n" +
                                "        \"name\": \"Gulbadan\",\n" +
                                "        \"gender\": \"Male\",\n" +
                                "        \"phone\": 9876543210\n" +
                                "    }" ;
        System.out.println(newSpartanStr);


        given()
                .log().all()
                .auth().basic("admin","admin")
                .contentType(ContentType.JSON)
                .body(newSpartanStr).
        when()
                .post("/spartans").
        then()
                .log().all()
                .statusCode(is(201))   ;
    }







}
