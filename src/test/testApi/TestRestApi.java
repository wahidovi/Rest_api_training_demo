import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestRestApi {

    @Test
    public void getCat(){
        String endpoint = "http://localhost:80/api_testing/product/read.php";

          var response = given().when().get(endpoint).then();
          response.log().body();
    }

    @Test
    public void getProduct(){
        String endpoint = "http://localhost:80/api_testing/product/read_one.php";

        var response =
                given().queryParam("id", 2).
                        when().get(endpoint).then();

        response.log().body();
    }

    @Test
    public void createProduct(){
        String endpoint = "http://localhost:80/api_testing/product/create.php";
        String payloadBody = """
                    {
                    "name": "Selenium WebDriver",
                    "description": "The most advanced Selenium Book",
                    "price": "39.00",
                    "category_id": "3",
                    "category_name": "Books"

                    }

                    """;

        var response =
                given().body(payloadBody).
                when().post(endpoint).
                then();
        response.log().body();
    }

    @Test
    public void updateProduct(){
        String endpoint = "http://localhost:80/api_testing/product/update.php";
        String updateBody = """
                {
                
                    "id": 1000,
                    "name": "Selenium WebDriver",
                    "description": "Selenium Book",
                    "price": 405,
                    "category_id": 3
                }
                
                """;
        var response = given().body(updateBody).when().put(endpoint).then();
        response.log().body();
    }

    @Test
    public void deleteProduct(){
        String endpoint = "http://localhost:80/api_testing/product/delete.php";
        String deleteBody = """
                {
                    "id": 18
                }
                """;
        var response = given().body(deleteBody).when().delete(endpoint).then();
        response.log().body();
    }

}
