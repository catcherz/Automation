package constants;

public class Endpoints {

    private Endpoints() {
        throw new IllegalStateException("Constants class");
    }

    public static final String GET_USER = "/users/%s";
    public static final String CREATE_USER = "/users";
    public static final String UPDATE_USER = "/users/%s";
    public static final String DELETE_USER = "/users/%s";

}
