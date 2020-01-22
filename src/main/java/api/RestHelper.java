//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.Map;

public class RestHelper {
    protected String url;
    protected Map<String, String> cookies;
    protected Map<String, String> headers;
    protected Response response;
    protected ContentDefaultEnum contentDefaultEnum;

    public RestHelper() {
        this.contentDefaultEnum = ContentDefaultEnum.JSON;
    }

    public Response get(String path) {
        this.response = (Response) this.buildRequestSpecification().when().get(path, new Object[0]);
        return this.response;
    }

    public Response get(String path, Map<String, ?> params) {
        this.response = (Response) this.buildRequestSpecification().queryParams(params).when().get(path, new Object[0]);
        return this.response;
    }

    public Response post(String path) {
        this.response = (Response) this.buildRequestSpecification().when().post(path, new Object[0]);
        return this.response;
    }

    public Response post(String path, Map<String, ?> params) {
        this.response = (Response) this.buildRequestSpecification().queryParams(params).when().post(path, new Object[0]);
        return this.response;
    }

    public Response post(String path, Object body) {
        this.response = (Response) this.buildRequestSpecification().body(body).when().post(path, new Object[0]);
        return this.response;
    }

    public Response post(String path, Map<String, ?> params, Object body) {
        this.response = (Response) this.buildRequestSpecification().queryParams(params).body(body).when().post(path, new Object[0]);
        return this.response;
    }

    public Response postMultipart(String path, String filePath) {
        this.response = (Response) this.buildRequestSpecification().multiPart(new File(filePath)).when().post(path, new Object[0]);
        return this.response;
    }

    public Response postMultipart(String path, Map<String, String> formParams, String filePath) {
        this.response = (Response) this.buildRequestSpecification().formParams(formParams).multiPart(new File(filePath)).when().post(path, new Object[0]);
        return this.response;
    }

    public Response put(String path) {
        this.response = (Response) this.buildRequestSpecification().when().put(path, new Object[0]);
        return this.response;
    }

    public Response put(String path, Map<String, ?> params) {
        this.response = (Response) this.buildRequestSpecification().queryParams(params).when().put(path, new Object[0]);
        return this.response;
    }

    public Response put(String path, Object body) {
        this.response = (Response) this.buildRequestSpecification().body(body).when().put(path, new Object[0]);
        return this.response;
    }

    public Response delete(String path) {
        this.response = (Response) this.buildRequestSpecification().when().delete(path, new Object[0]);
        return this.response;
    }

    public Response delete(String path, Map<String, ?> params) {
        this.response = (Response) this.buildRequestSpecification().queryParams(params).when().delete(path, new Object[0]);
        return this.response;
    }

    public Response delete(String path, Object body) {
        this.response = (Response) this.buildRequestSpecification().body(body).when().delete(path, new Object[0]);
        return this.response;
    }

    private RequestSpecification buildRequestSpecification() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setAccept(ContentType.JSON).setContentType(ContentType.JSON);
        if (this.cookies != null) {
            requestSpecBuilder.addCookies(this.cookies);
        }

        if (this.headers != null) {
            requestSpecBuilder.addHeaders(this.headers);
        }

        if (this.contentDefaultEnum.equals(ContentDefaultEnum.XML)) {
            requestSpecBuilder.setAccept(ContentType.XML).setContentType(ContentType.XML);
        }

        if (this.contentDefaultEnum.equals(ContentDefaultEnum.MULTIPART)) {
            requestSpecBuilder.setAccept(ContentType.JSON).setContentType("multipart/form-data");
        }

        return this.buildRequestSpecification(requestSpecBuilder);
    }

    protected RequestSpecification buildRequestSpecification(RequestSpecBuilder requestSpecBuilder) {
        return RestAssured.given(requestSpecBuilder.setBaseUri(this.url).log(LogDetail.ALL).
                addFilter(new ResponseLoggingFilter()).build());
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setContentDefaultEnum(ContentDefaultEnum contentDefaultEnum) {
        this.contentDefaultEnum = contentDefaultEnum;
    }
}
