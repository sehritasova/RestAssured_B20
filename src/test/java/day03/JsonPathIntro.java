package day03;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;

public class JsonPathIntro {

    @BeforeAll
    public static void setUp() {
        baseURI = "http://100.26.101.158:8000";
        basePath = "/api";
    }

    @AfterAll
    public static void tearDown() {
        reset();
    }

    @DisplayName("Extracting data out of Spartan Json Object")
    @Test
    public void test1SpartanPayload(){

        // send a request to get 1 spartan
        // by providing path params with valid id
        // save it into Response object
        // NEW: create an object with type JsonPath
        // by calling the method jsonPath() on response object
        // extract id, name, gender, phone
        // and save it into variable of correct type

        Response response = given()
                                    .pathParam("id",55).
                            when()
                                    .get("/spartans/{id}")
                                    .prettyPeek() ;


        //response.prettyPrint();

        // JsonPath is used to navigate through the json payload
        // and extract the value according to the valid " jsonpath " provided
        JsonPath jp = response.jsonPath();
        int myId = jp.getInt("id");
        String myName = jp.getString("name");
        String myGender = jp.getString("gender");
        long myPhone = jp.getLong("phone");

        System.out.println("myId ="+ myId);
        System.out.println("myName = " + myName);
        System.out.println("myGender = " + myGender);
        System.out.println("myPhone = " + myPhone);


    }











}