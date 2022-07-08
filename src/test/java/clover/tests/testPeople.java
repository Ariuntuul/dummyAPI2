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

    @DisplayName("GET request to https://ghibliapi.herokuapp.com/people")
    @Test
    public void test01_printAllPeople(){

        Response response = given().accept(ContentType.JSON)
                .when().get("/people");

        System.out.println("Status code: " + response.statusCode());
        if (response.statusCode() == 200){
            System.out.println("Successful response");
        } else {
            System.out.println("Error!!!");
        }

        Assertions.assertEquals(200, response.statusCode());

        response.prettyPrint();

    }

    @DisplayName("GET request to https://ghibliapi.herokuapp.com/people/{id} with Path Params")
    @Test
    public void test02_printEachPerson(){

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", "fe93adf2-2f3a-4ec4-9f68-5422f1b87c01")
                .when().get("/people/{id}");

        //System.out.println("Status code: " + response.statusCode());

        if (response.statusCode() == 200){
            System.out.println("Successful response");
        } else {
            System.out.println("Error!!!");
        }

        Assertions.assertEquals(200, response.statusCode());

        response.prettyPrint();

    }

    @DisplayName("Total number of People by Name")
    @Test
    public void test03_printListOfPerson(){

        Response response = given().accept(ContentType.JSON)
                .when().get("/people");

        if (response.statusCode() == 200){
            System.out.println("Successful response");
        } else {
            System.out.println("Error!!!");
        }

        //All data are inside the Array, therefore I created a list, then
        List<String> allPeople = response.path("name");
        System.out.println("Total number of people: " + allPeople.size());

        for (int i = 0; i < allPeople.size(); i++){

            System.out.println(i + 1 + ". " + allPeople.get(i));

        }

        //System.out.println(allPeople.contains("Thomas"));

        Assertions.assertTrue(allPeople.contains("Thomas"));

    }







}
