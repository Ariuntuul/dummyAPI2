package clover.tests;

import clover.testBase.ghibliTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static io.restassured.RestAssured.given;

public class testPeople extends ghibliTestBase {

    @Test
    public void test01_printAllPeople(){

        Response response = given().accept(ContentType.JSON)
                .when().get("/People");

        System.out.println("Status code: " + response.statusCode());
        if (response.statusCode() == 200){
            System.out.println("Succesfull response");
        } else {
            System.out.println("Error!!!");
        }

        Assertions.assertEquals(200, response.statusCode());

        response.prettyPrint();

    }

    @Test
    public void test02_printEachPerson(){

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", "fe93adf2-2f3a-4ec4-9f68-5422f1b87c01")
                .when().get("/People/{id}");

        //System.out.println("Status code: " + response.statusCode());
        if (response.statusCode() == 200){
            System.out.println("Succesfull response");
        } else {
            System.out.println("Error!!!");
        }

        Assertions.assertEquals(200, response.statusCode());

        response.prettyPrint();

    }

    @Test
    public void test03_printListOfPerson(){

        Response response = given().accept(ContentType.JSON)
                .when().get("/People");

        if (response.statusCode() == 200){
            System.out.println("Succesfull response");
        } else {
            System.out.println("Error!!!");
        }

        List<String> allPeople = response.path("name");
        System.out.println("Number of people: " + allPeople.size());

        for (int i = 0; i < allPeople.size(); i++){

            System.out.println(i + 1 + ". " + allPeople.get(i));

        }

        System.out.println(allPeople.contains("Thomas"));

        Assertions.assertTrue(allPeople.contains("Thomas"));

    }





}
