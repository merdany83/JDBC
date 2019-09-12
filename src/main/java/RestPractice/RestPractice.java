package RestPractice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class RestPractice {
  @BeforeClass
  public static void setUp(){
      RestAssured.baseURI="http://54.210.15.242";
      RestAssured.port=8000;
      RestAssured.basePath="/api";
  }
  @Test
    public void test() {

        Response result = RestAssured.get("/hello");
        System.out.println(result.statusCode());
        System.out.println(result.asString());
        System.out.println(result.getBody().asString());
        System.out.println(result.body().asString());
        System.out.println(result.getHeader("content-type"));
        System.out.println(result.prettyPrint());
    }

        @Test
        public void test1() {
            Response result = RestAssured.get("/hello");
            assertEquals(200, result.statusCode());
            assertEquals("Hello from Sparta", result.asString());
            assertEquals("text/plain;charset=UTF-8", result.header("content-type"));

        }

    @Test
    public void Hello_EndPoint_HeaderContains_Test() {

      Response response = RestAssured.get("/hello");
//      String headerValue= response.getHeader("Date");
//
//      System.out.println(headerValue);
       boolean dateHeaderExists=response.getHeaders().hasHeaderWithName("Date");
       assertTrue(dateHeaderExists);
        assertEquals("17",response.getHeader("content-length"));

       System.out.println(dateHeaderExists);



    }
}








