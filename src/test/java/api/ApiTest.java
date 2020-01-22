package api;

import api.model.UserData;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class ApiTest {
    private Api api;

    @BeforeClass(groups = "Api")
    public void connect() {
        api = new Api();
    }

    @Test(groups = {"Api", "positive"})
    public void getUserTest() {

        api.getUser("2").then().statusCode(HttpStatus.SC_OK).rootPath("data").
                body("email", is("janet.weaver@reqres.in"),
                        "first_name", is("Janet"),
                        "last_name", is("Weaver"),
                        "avatar", is(notNullValue()));
    }

    @Test(groups = {"Api", "positive"}, dataProvider = "userData")
    public void addUserTest(UserData userData) {

        Response response = api.createUser(userData);
        response.then().statusCode(HttpStatus.SC_CREATED).
                body("name", is(userData.getName()),
                        "job", is(userData.getJob()));

        String id = response.then().extract().path("531");

        api.deleteUser(id).then().statusCode(HttpStatus.SC_NO_CONTENT);
    }

    @DataProvider
    public Object[][] userData() {
        return new Object[][]{

                {UserData.builder().name("User").job("Job").build()},
                {UserData.builder().name("Anna").job("Test").build()}
        };
    }

    @Test(groups = {"Api", "positive"})
    public void changeUserTest() {

        UserData userData = UserData.builder().name("Ivan").job("Tst").build();

        Response response = api.updateUser(userData, "200");
        response.then().statusCode(HttpStatus.SC_OK);
    }

}
