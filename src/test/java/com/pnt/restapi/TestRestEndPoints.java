package com.pnt.restapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class TestRestEndPoints {

    /*
#	Route	        Method  Type	                    Full route	                                Description	Details
1	/employee	    GET	    JSON	http://dummy.restapiexample.com/api/v1/employees	    Get all employee data Details
2	/employee/{id}	GET	    JSON	http://dummy.restapiexample.com/api/v1/employee/{id}	Get a single employee data Details
3	/create	        POST	JSON	http://dummy.restapiexample.com/api/v1/create	        Create new record in database Details
4	/update/{id}	PUT	    JSON	http://dummy.restapiexample.com/api/v1/update/{id}	    Update an employee record Details
5	/delete/{id}	DELETE	JSON	http://dummy.restapiexample.com/api/v1/delete/{id}	    Delete an employee record Details
*/

    private final String baseURI = RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";

    private final String employeesEndpoint = "employees";
    private final String employeeEndpoint = "employee/4";
    private final String createEmployee = "create";
    private final String updateEmployee = "update/5";
    private final String deleteEmployee = "delete/6";

    @Test
    public void deleteAnEmployee() {
        Response response = RestAssured.given().when().delete(deleteEmployee)
                .then().assertThat().statusCode(200).extract().response();

        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
    }

    @Test
    public void updateAnEmployee() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("salary", "120000");
        jsonObject.put("name", "Test User001");


        System.out.println(jsonObject);
        Response response = RestAssured.given().contentType(ContentType.JSON).body(jsonObject.toString())
                .when().put(updateEmployee)
                .then().assertThat().statusCode(200).extract().response();

        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
    }


    @Test
    public void createAnEmployee() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "pnt new id ");
        jsonObject.put("salary", "100000");
        jsonObject.put("age", "27");


        System.out.println(jsonObject);
        Response response = RestAssured.given().contentType(ContentType.JSON).body(jsonObject)
                .when().post(createEmployee)
                .then().assertThat().statusCode(200).extract().response();

        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
    }


    @Test
    public void getAllEmployees() {
        Response response = RestAssured.given().when().get(employeesEndpoint)
                .then().assertThat().statusCode(200).extract().response();

        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
    }


    @Test
    public void getIndividualEmployee() {
        Response response = RestAssured.given().when().get(employeeEndpoint)
                .then().assertThat().statusCode(200).extract().response();

        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
    }


}
