import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.samePropertyValuesAs;


public class Deserialize {

    @Test
    public void getDeserializedProduct(){
        String endpoint = "http://localhost:80/api_testing/product/read_one.php";

        Product expectedProduct = new Product(
                2,
                "Cross-Back Training Tank",
                "The most awesome phone of 2013!",
                299.00,
                2,
                "Active Wear - Women"
        );



      Product actualProduct =  given().queryParam("id", 2)
                .when()
                .get(endpoint)
                .as(Product.class);

            assertThat(actualProduct, samePropertyValuesAs(expectedProduct));


    }
}
