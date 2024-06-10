package org.example.user;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.qameta.allure.Step;
public class User {
    private static final String baseUri = "https://stellarburgers.nomoreparties.site";

    public String mail;
    public String pass;
    public String name;
    public String accessToken;

    public User(String mail, String pass, String name) {
        this.mail = mail;
        this.pass = pass;
        this.name = name;
    }
    public User() {
    }

    @Step("Send post request to /api/auth/register")
    public void createUser() {
        UserSerialized json = new UserSerialized(
                mail,pass,name
        );
        Response response = given()
                .baseUri(baseUri)
                .header("Content-type", "application/json") // заполни header
                .and()
                .body(json)
                .when()
                .post("/api/auth/register");
        if (response.getStatusCode() == 200) {
            this.accessToken = response.jsonPath().getString("accessToken");
        }
    }
    @Step("Send post request to /api/auth/login")
    public void loginUser(UserSerialized json) {
        Response response = given()
                .baseUri(baseUri)
                .header("Content-type", "application/json") // заполни header
                .header("Authorization", accessToken)
                .when()
                .post("/api/auth/login");
    }
    @Step("deleting user")
    public void deleteUser(String accessToken) {
        given()
                .baseUri(baseUri)
                .header("Authorization", accessToken) //
                .when()
                .delete("/api/auth/user/")
                .then()
                .statusCode(202)
                .body("message", equalTo("User successfully removed"));
    }
}
