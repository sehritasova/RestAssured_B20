package day04;

import io.restassured.RestAssured;
import org.junit.jupiter.api.*;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;


public class OpenMovieDB_Test{

    // http://www.omdbapi.com/?t=The Orville&api=5b5d0fe8

    @BeforeAll
    public static void setUp(){
        baseURI = "http://www.omdbapi.com";

    }
    @AfterAll
    public static void tearDown(){
        reset();
    }
    @DisplayName("Test Search Movie or OpenMovieDB Test")
    @Test
    public void testMovie(){

    }









}
