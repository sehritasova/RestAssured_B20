import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Day 1 Hello Test")
public class HelloTest{

    // Junit5 Annotations
    // @BeforeAll  @AfterAll  @BeforeEach  @AfterEach
    // @DisplayName  @Disabled

    @BeforeAll
    public static void setUp(){
        System.out.println("@BeforeAll is running");
    }

    @AfterAll
    public static void tearDown(){
        System.out.println("@AfterAll is running");
    }

    @BeforeEach
    public void setUpTest(){
        System.out.println("@BeforeEach is running");
    }

    @AfterEach
    public void tearDownTest(){
        System.out.println("@AfterEach is running");
    }

    @DisplayName("Test 1")
    @Test
    public void test (){
        System.out.println("Test 1 is running");
        Assertions.assertEquals(4, 1+3);
    }
    @DisplayName("Test 2")
    @Test
    public void test2(){

        System.out.println("Test 2 is running");
        // assert 4 time 3 is 12
        assertEquals(12,4*3);

    }







    }




