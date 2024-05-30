package Practice.TestNG;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestNG005 {

    String token;
    Integer bookingid;
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @BeforeTest
    public void Gettoken(){
        System.out.println("---Get Token---");
        requestSpecification= RestAssured.given();

        String payload="\n" +
                "  {\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"}";
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        Response response=requestSpecification.when().post();

        validatableResponse= response.then();
        //RestAssured assertions
        validatableResponse.body("token", Matchers.notNullValue());
        token=response.then().log().all().extract().path("token");
        //TestNGassertions
        Assert.assertNotNull(token);
        //Assertj assertions
        assertThat(token).isNotNull().isNotBlank().isNotEmpty();

    }
    @BeforeTest
    public void GetBookingId(){
        System.out.println("---Get BookingID---");
        String payload="{\n" +
                "    \"firstname\" : \"Amit\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payload).log().all();

        response=requestSpecification.when().post();
        validatableResponse=response.then().statusCode(200);
        bookingid=response.then().log().all().extract().path("bookingid");

    }
    @Test
    public void PutReq(){
        String payload="{\n" +
                "    \"firstname\" : \"Rahul\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("booking/"+bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payload).log().all();

        response=requestSpecification.when().put();
        validatableResponse=response.then().log().all().statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Rahul"));


    }

    @Test
    public void PutReqPositivecase(){
        String payload="{\n" +
                "    \"firstname\" : \"Rahul\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("booking/"+bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payload).log().all();

        response=requestSpecification.when().put();
        validatableResponse=response.then().statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Rahul"));
          String firstname =response.then().log().all().extract().path("firstname");
        assertThat(firstname).isNotNull().isNotEmpty().isNotBlank();

    }
}
