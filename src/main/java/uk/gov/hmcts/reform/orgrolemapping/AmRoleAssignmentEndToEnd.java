package uk.gov.hmcts.reform.orgrolemapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmRoleAssignmentEndToEnd {

    private AmRoleAssignmentEndToEnd() {
    }

    public static void main(final String[] args) {
        SpringApplication.run(AmRoleAssignmentEndToEnd.class);
    }
}
