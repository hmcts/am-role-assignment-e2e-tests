package uk.gov.hmcts.reform.orgrolemapping;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.junit.spring.integration.SpringIntegrationSerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RunWith(SpringIntegrationSerenityRunner.class)
@WithTags({@WithTag("testType:Smoke")})
public class SmokeTest {

    // use this when testing locally - replace the below content with this line
    private final String targetInstance =
            StringUtils.defaultIfBlank(
                    System.getenv("TEST_URL"),
                    "http://localhost:5010"
            );

    @Test
    public void test_should_prove_app_is_running_and_healthy() {

        RestAssured.baseURI = targetInstance;
        RestAssured.useRelaxedHTTPSValidation();

        Response response = SerenityRest
                .given()
                .relaxedHTTPSValidation()
                .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .get("/")
                .andReturn();
        Assert.assertEquals(response.statusCode(), 200);
    }
}