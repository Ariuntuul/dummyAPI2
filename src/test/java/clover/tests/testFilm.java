package clover.tests;

import clover.testBase.ghibliTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static io.restassured.RestAssured.given;

public class testFilm extends ghibliTestBase {

    //String baseUrl = "https://ghibliapi.herokuapp.com/";

    @Test
    public void test01_printAllFilms(){

        Response response = given().accept(ContentType.JSON)
                .when().get("/films");

        System.out.println("Status code: " + response.statusCode());
        if (response.statusCode() == 200){
            System.out.println("Successful response");
        } else {
            System.out.println("Error!!!");
        }

        Assertions.assertEquals(200, response.statusCode());

        response.prettyPrint();

    }
    @Test
    public void test02_printOneFilm(){

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
    @DisplayName("Number of Movies")
    @Test
    public void test03_printNumberOfMovie(){

        Response response = given().accept(ContentType.JSON)
                .when().get("/films");

        if (response.statusCode() == 200){
            System.out.println("Successful response");
        } else {
            System.out.println("Error!!!");
        }

        //Store all film name into the list:
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
