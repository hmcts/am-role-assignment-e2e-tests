package uk.gov.hmcts.reform.orgrolemapping.domain.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class SampleTest {

    @Test
    public void dummyTest() {
        Date d1 = new Date();
        Date d2 = new Date();
        Assert.assertNotEquals(d1.getTime(), d2.getTime());
    }
}
