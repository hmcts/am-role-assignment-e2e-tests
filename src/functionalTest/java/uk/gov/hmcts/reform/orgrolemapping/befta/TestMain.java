package uk.gov.hmcts.reform.orgrolemapping.befta;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import java.io.File;

public class TestMain {

    public static void main(String[] args) {
        should_create_role_assignments();
    }

    public static void should_create_role_assignments() {

         String uri = "http://localhost:8095/refdata/case-worker/upload-file";
         String SERVICE_AUTHORIZATION = "ServiceAuthorization";
         String AUTHORIZATION = "Authorization";
         String BEARER = "Bearer ";

        String serviceAuth = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbV9vcmdfcm9sZV9tYXBwaW5nX3NlcnZpY2UiLCJleHAiOjE2MTMxMzQxNzl9.Td1e8p2cvTIr6TA2bRXdMB-ogGq3yZqgQjhrvtCxKOOR41yb2mluf5IzY3GT_luQ4jBHiQVjZ9q9rPnSQDBsgQ";
        String accessToken = "eyJ0eXAiOiJKV1QiLCJ6aXAiOiJOT05FIiwia2lkIjoiYi9PNk92VnYxK3krV2dySDVVaTlXVGlvTHQwPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJURVNUX0FNX09STV9CRUZUQUB0ZXN0LmxvY2FsIiwiYXV0aF9sZXZlbCI6MCwiYXVkaXRUcmFja2luZ0lkIjoiNjliNjFjNTgtNmE1Yi00YzJmLTk2YTYtOWMyYzM2MjljYjRjIiwiaXNzIjoiaHR0cDovL2ZyLWFtOjgwODAvb3BlbmFtL29hdXRoMi9obWN0cyIsInRva2VuTmFtZSI6ImFjY2Vzc190b2tlbiIsInRva2VuX3R5cGUiOiJCZWFyZXIiLCJhdXRoR3JhbnRJZCI6ImRkNTYzNjRmLWMyM2MtNDUwZC1hNzI4LWJmOTIxZmY1YTk5MiIsImF1ZCI6ImFtX2RvY2tlciIsIm5iZiI6MTYxMzExOTgyNCwiZ3JhbnRfdHlwZSI6InBhc3N3b3JkIiwic2NvcGUiOlsib3BlbmlkIiwicHJvZmlsZSIsInJvbGVzIiwiY3JlYXRlLXVzZXIiLCJtYW5hZ2UtdXNlciIsInNlYXJjaC11c2VyIiwiYXV0aG9yaXRpZXMiXSwiYXV0aF90aW1lIjoxNjEzMTE5ODI0LCJyZWFsbSI6Ii9obWN0cyIsImV4cCI6MTYxMzE0ODYyNCwiaWF0IjoxNjEzMTE5ODI0LCJleHBpcmVzX2luIjoyODgwMCwianRpIjoiOWM4OGM3MWEtMDE2YS00ZjczLThmNTQtMDEzMjAxYTNlYTI5In0.RGV1m-mNQRIs937EGry4XsyB0GysnOpb9_RzzR3FnIAPYm8iFN61SYrxeek36oE5k5jLSLOAdClWVsENSnQvhOcP9TJYO3WuxPb8Lg8aEo734pByTlLfUlSu5R93p_dLjsV7lD_7k2_-CkgryYqsbJwhNdI7CcPHXlAz5fyi1B9CrKfjGDpr95PHxYv7xD_coB1gK-94Ed6Vx2cvEKxq5eF4l1HM2A-2HNX5DC33ivmKwZ3JCqS1vaOF0Uum_8FxKNrJuuTr3kAfzkgdUeNMLFGHyZu627xluwuyr-IpTaJ7ZyZdetVVJrAGpIVxBeU5XUINPdjY9cbTQ2zb_x6OCQ";

        File file = new File("/Users/sivakanukollu/github/MOJ/am-role-assignment-e2e-tests/src/functionalTest/resources/Staff Data Upload_S-001.xlsx");


        RestAssured.useRelaxedHTTPSValidation();
        Response response = SerenityRest
            .given()
            .relaxedHTTPSValidation()
            .header(SERVICE_AUTHORIZATION, BEARER + serviceAuth)
            .header(AUTHORIZATION, BEARER + accessToken)
            .multiPart("file",file, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" )
            .when()
            .post(uri)
            .andReturn();
        response.then().assertThat().statusCode(HttpStatus.OK.value());

        System.out.println("response: " + response.prettyPrint());

    }
}
