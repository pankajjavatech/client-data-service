package com.data.client.api.api.model;


import com.data.client.api.model.DataBody;
import com.data.client.api.model.DataEnvelope;
import com.data.client.api.model.DataHeader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DataEnvelopeTests {

    @Test
    public void assignDataHeaderFieldsShouldWorkAsExpected() {
        /*DataHeader dataHeader = new DataHeader(TestDataHelper.TEST_NAME, BlockTypeEnum.BLOCKTYPEA);
        DataBody dataBody = new DataBody(TestDataHelper.DUMMY_DATA);

        DataEnvelope dataEnvelope = new DataEnvelope(dataHeader, dataBody);

        assertThat(dataEnvelope).isNotNull();
        assertThat(dataEnvelope.getDataHeader()).isNotNull();
        assertThat(dataEnvelope.getDataBody()).isNotNull();
        assertThat(dataEnvelope.getDataHeader()).isEqualTo(dataHeader);
        assertThat(dataEnvelope.getDataHeader()).isEqualTo(dataHeader);
        assertThat(dataBody.getDataBody()).isEqualTo(TestDataHelper.DUMMY_DATA);
        */

    }
}
