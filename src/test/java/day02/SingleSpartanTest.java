package day02;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.* ;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.* ;

public class SingleSpartanTest {

    @BeforeAll
    public static void setUp() {
        baseURI = "http://52.201.187.226:8000";
        basePath = "/api";
    }

    @AfterAll
    public static void tearDown() {
        reset();
    }

    @DisplayName("Testing GET spartans/ {id} endpoint")
    @Test
    public void test1Spartan() {
        // I want to get Json result out
        // When I send Get request to /spartans/{id} endpoint
        // and expecting 200 status code
        given()
                .accept(ContentType.JSON).
                when()
                .get("/spartans/100").
                then()
                .statusCode(is(200))
                .contentType(ContentType.JSON)
        ;

        // I want to make it obvious for
        // the value 100 is path variable|params
        // to uniquely identify the resource


        given()
                .accept(ContentType.JSON)
                .pathParam("id", 105).
                when()
                .get("/spartans/{id}").
                then()

                .statusCode(is(200))
                .contentType(ContentType.JSON)

        ;


        // this is the easiest one, same result
        given()
                .accept(ContentType.JSON).
                when()
                .get("/spartans/{id}", 100).

                then()
                .statusCode(is(200))
                .contentType(ContentType.JSON)
        ;


    }

    @DisplayName("Testing GET spartans/ {id} endpoint Payload")
    @Test
    public void test1SpartanPayload() {
        /**
         * {
         *   "id": 100,
         *   "name": "SpartanX",
         *   "gender": "Female",
         *   "phone": 9999999999
         * }
         */


        given()
                .accept(ContentType.JSON).
        when()
                .get("/spartans/{id}", 100).
        then()
                .statusCode(is(200))
                .contentType(ContentType.JSON)
                .body("id", is(105))
                .body("name", equalTo("SpartanX"))
                .body("gender", is(equalTo("Female")) )
                .body("phone", equalTo(9999999999L))
        ;
    }
}
