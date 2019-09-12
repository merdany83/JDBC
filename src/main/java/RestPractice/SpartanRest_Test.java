package RestPractice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class SpartanRest_Test {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://54.210.15.242";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
    }
//    Given no headers are provided
//    When User send request to /Spartans
//    Then Reponse status code should be 200
//    and  header should have content Type / json
//    and  header should contains Date

    @Test
    public void Spartan_All_Test() {

        Response response = get("/spartans/");
        assertEquals(200, response.statusCode());
        assertEquals("application/json;charset=UTF-8", response.contentType());
        assertEquals("application/json;charset=UTF-8", response.getHeader("content-type"));
        assertEquals("application/json;charset=UTF-8", response.getContentType());

        boolean hasDateHeader = response.getHeaders().hasHeaderWithName("Date");
        assertTrue(hasDateHeader);


    }

    @Test
    public void SingleSpartanData_Test() {

        //Response response = get("/spartans/2");
        Response response = given().pathParam("id", 2).get("/spartans/{id}");

        System.out.println(response.asString());
        System.out.println(response.body().asString());
        response.prettyPrint();
        assertEquals(200, response.statusCode());
        assertEquals("application/json;charset=UTF-8", response.contentType());
        assertTrue(response.asString().contains("Nels"));

    }

    @Test
    public void InvalidSpartan_ID_Test() {
//    Given no header is provided
//    When User send request to /api/spartans/20000
//    Then Reponse status code should be 404
//    and header should have content Type / JSON
//    and response payload should contains “Spartan Not Found”
        Response response = given().pathParam("my_id", 20000).get("/spartans/{my_id}");
        // response.prettyPrint();
        assertEquals(404, response.statusCode());
    }

    @Test
    public void WithHeaderSingleSpartanData_Test() {

        //Response response = get("/spartans/2");
        Response response = given().header("accept","application/json").when().get("/spartans/");
        assertEquals("application/json;charset=UTF-8", response.contentType());


    }
    @Test
    public void Search_By_Query_Parameter() {

        //Response response = get("/spartans/2");
        Response response = given().
                accept(ContentType.JSON).
                queryParam("gender","Male").when().
                get("/spartans/search");

        assertEquals(200, response.statusCode());
       assertFalse(response.asString().contains("Female"));
      // response.prettyPrint();
        System.out.println(response.path("pageable.sort.unsorted").toString());

    }
}