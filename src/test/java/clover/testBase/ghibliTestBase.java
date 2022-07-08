package clover.testBase;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class ghibliTestBase {

    @BeforeAll
    public static void setUp(){

        RestAssured.baseURI = "https://ghibliapi.herokuapp.com";
    }


}
