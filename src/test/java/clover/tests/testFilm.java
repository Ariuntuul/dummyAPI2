package clover.tests;

import clover.testBase.ghibliTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static io.restassured.RestAssured.given;

public class testFilm extends ghibliTestBase {

    //String baseUrl = "https://ghibliapi.herokuapp.com/";

   @DisplayName("GET request to https://ghibliapi.herokuapp.com/films")
    @Test
    public void test01_printAllFilms(){

        // send a get request and save response inside the Response object
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/films");

        //print status code
        System.out.println("Status code: " + response.statusCode());
        if (response.statusCode() == 200){
            System.out.println("Successful response");
        } else {
            System.out.println("Error!!!");
        }

        //verify status code is 200
        Assertions.assertEquals(200, response.statusCode());

        //verify response body
        response.prettyPrint();

    }
    @DisplayName("GET request to https://ghibliapi.herokuapp.com/films/{id} with Path Params")
    @Test
    public void test02_printOneFilm(){

        // send a get request with pathParam and save response inside the Response object
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", "cd3d059c-09f4-4ff3-8d63-bc765a5184fa")
                .when().get("/films/{id}");

        System.out.println(response.statusCode());
        if (response.statusCode() == 200){
            System.out.println("Successful response");
        } else {
            System.out.println("Error!!!");
        }

        Assertions.assertEquals(200, response.statusCode());

        response.prettyPrint();

    }
    @DisplayName("Number of Movies by Title")
    @Test
    public void test03_printNumberOfMovie(){


        Response response = given().accept(ContentType.JSON)
                .when().get("/films");

        if (response.statusCode() == 200){
            System.out.println("Successful response");
        } else {
            System.out.println("Error!!!");
        }

        //Store all film name into the list and
        List<String> allFilmNames = response.path("title");
        System.out.println("Number of movies: " + allFilmNames.size());

//        for (String eachFilm : allFilmNames){
//            System.out.println(eachFilm);
//        }

        for (int i = 0; i < allFilmNames.size(); i++){
            System.out.println(i + 1 + ". " + allFilmNames.get(i));
        }

        System.out.println(allFilmNames.contains("Ponyo"));

    }
}
