package api;
import api.model.UserData;
import constants.Endpoints;
import io.restassured.response.Response;

public class Api extends RestHelper {

    public Api() {
        setUrl("https://reqres.in/api");

    }

    public Response createUser(UserData userData) {
        return post(Endpoints.CREATE_USER, userData);
    }

    public Response updateUser(UserData userData, String userId) {
        return put(String.format(Endpoints.UPDATE_USER, userId), userData);
    }

    public Response getUser(String userId) {
        return get(String.format(Endpoints.GET_USER, userId));
    }

    public Response deleteUser(String userId) {
        return delete(String.format(Endpoints.DELETE_USER, userId));
    }

}
