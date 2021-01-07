package day05;


import io.restassured.http.ContentType;
import utility.ConfigurationReader;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;
import org.junit.jupiter.api.DisplayName;
import utility.SpartanUtil;

import java.util.Map;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class Spartan_E2E_HappyPath {

    private static Map<String,Object> payloadMap ;
    private static int newID ;


    // crud operation -- CREATE-- READ -- UPDATE -- DELETE
    @BeforeAll
    public static void setUp(){
        baseURI = ConfigurationReader.getProperty("spartan.base_url");
        basePath = "/api" ;
        payloadMap = SpartanUtil.getRandomSpartanRequestPayload() ;

    }

    @AfterAll
    public static void tearDown(){
        reset();
    }

    @DisplayName("1. Testing POST/ api/spartans Endpoint")
    @Test
    public void testAddData(){
        newID=
        given()
                .auth().basic("admin","admin")
                .contentType(ContentType.JSON)
                .body(  payloadMap  )
                .log().all().
        when()
                .post("/spartans").
        then()
                .log().all()
                .assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                // assert the response body name , gender , phone
                // is same as what faker generated
                .body("data.name" , is( payloadMap.get("name") )  )
                .body("data.gender" , is( payloadMap.get("gender") )  )
                .body("data.phone" , equalTo( payloadMap.get("phone") )  )
                .extract()
                .jsonPath()
                .getInt("data.id")
        ;
        System.out.println("newID = " + newID);



    }







}