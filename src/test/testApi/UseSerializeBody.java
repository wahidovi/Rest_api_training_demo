import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UseSerializeBody {

    @Test
    public void crateSerializedProduct(){
        String endpoint = "http://localhost:80/api_testing/product/create.php";
        Product product = new Product(

                "Atomic Habit",
                "Self Improvement",
                17.99,
                3
        );

        var response = given().body(product).when().post(endpoint).then();
        response.log().body();
    }

    @Test
    public void createProduct(){
        String endpoint = "http://localhost:80/api_testing/product/create.php";
        Product product = new Product(
                "Badass money making",
                "By Jen Sincero - ",
                12.99,
                3
        );

        var response = given().body(product).when().post(endpoint).then();
        response.log().body();
    }

    @Test
    public void updateProduct(){
        String endpoint = "http://localhost:80/api_testing/product/update.php";
        Product product = new Product(
                1002,
                "Badass money making",
                "By Jen Sincero - ",
                14.99,
                3,
                "category name"
        );

        var response = given().body(product).when().put(endpoint).then();
        response.log().body();
    }

    @Test
    public void getProduct(){
        String endpoint = "http://localhost:80/api_testing/product/read_one.php";

        var response =
                given()
                .queryParam("id", 1001)
                        .when()
                        .get(endpoint)
                        .then();

        response.log().body();
    }


    @Test
    public void AssertGetProduct(){
        String endpoint = "http://localhost:80/api_testing/product/read_one.php";


                given()
                        .queryParam("id", 1001)
                        .when()
                        .get(endpoint)
                        .then()
                        .assertThat().statusCode(200);


    }
    @Test
    public void AssertBodyGetProduct(){
        String endpoint = "http://localhost:80/api_testing/product/read_one.php";


        given()
                .queryParam("id", 1001)
                .when()
                .get(endpoint)
                .then()
                .assertThat().statusCode(200)
                .body("id", equalTo("1001"))
                .body("name", equalTo("Atomic Habit"));


    }

    @Test
    public void AssertAllBodyGetProduct(){
        String endpoint = "http://localhost:80/api_testing/product/read.php";


                given()
                .when()
                .get(endpoint)
                .then()
                        .log()
                        .body()
                        .assertThat().statusCode(200)
                        .body("records.size()", equalTo(19))
                        .body("records.id[0]", equalTo("1001"));

    }


    @Test
    public void deleteProduct(){
        String endpoint = "http://localhost:80/api_testing/product/delete.php";
        Product product = new Product(1002);

        var response =
                given().body(product)
                        .when()
                        .delete(endpoint)
                        .then();

        response.log().body();
    }
}
