package uk.gov.hmcts.reform.orgrolemapping.befta;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;

public class CustomFileUpload {

    private CustomFileUpload() {
    }

    private static final Logger logger = LoggerFactory.getLogger(CustomFileUpload.class);

    public static final String SERVICE_AUTHORIZATION = "ServiceAuthorization";
    public static final String AUTHORIZATION = "Authorization";

    public static void uploadFile(String uri, String serviceAuthToken, String userAuthToken, String fileName,
                                  String mimeType) {
        File file = null;
        try {
            URL url = CustomFileUpload.class.getClassLoader().getResource(/*"../resources/" +*/ fileName);
            assert url != null;
            file = Paths.get(url.toURI()).toFile();
        } catch (Exception e) {
            logger.error("Exception while reading the file: {}", e.getMessage());
        }

        RestAssured.useRelaxedHTTPSValidation();
        Response response = SerenityRest
                .given()
                .relaxedHTTPSValidation()
                .header(SERVICE_AUTHORIZATION, serviceAuthToken)
                .header(AUTHORIZATION, userAuthToken)
                .multiPart("file", file, mimeType)
                .when()
                .post(uri)
                .andReturn();
        response.then().assertThat().statusCode(HttpStatus.OK.value());

        logger.info("response: {}", response.prettyPrint());

    }
}
