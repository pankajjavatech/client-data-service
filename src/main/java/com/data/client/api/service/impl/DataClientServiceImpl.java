package com.data.client.api.service.impl;

import com.data.client.api.model.BlockTypeEnum;
import com.data.client.api.model.DataBody;
import com.data.client.api.model.DataEnvelope;
import com.data.client.api.model.DataHeader;
import com.data.client.api.service.DataClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Client code does not require any test coverage
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class DataClientServiceImpl implements DataClientService {

    @Value("${client.push.data.url}")
    private String CLIENT_PUSH_DATA_URL;

    @Value("${client.get.data.url}")
    private String CLIENT_GET_DATA_URL;

    @Value("${client.update.data.url}")
    private String CLIENT_UPDATE_DATA_URL;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Boolean pushDataEnvelope(DataEnvelope dataEnvelope) {
        log.info("Pushing data {} to {}", dataEnvelope.getDataHeader().getName(), CLIENT_PUSH_DATA_URL);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<DataEnvelope> entity = new HttpEntity<DataEnvelope>(dataEnvelope,headers);
        ResponseEntity<Boolean> response  = restTemplate.exchange(CLIENT_PUSH_DATA_URL, HttpMethod.POST, entity, Boolean.class);
        log.info("Response Status {}", response.getBody());
        return response.getBody();

    }

    @Override
    public List<DataEnvelope> getData(String blockType) throws Exception {
        log.info("Query for data with header block type {}", blockType);

        try {
            ResponseEntity<List<DataEnvelope>> response = restTemplate.exchange(
                    CLIENT_GET_DATA_URL + "/" + blockType,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<DataEnvelope>>() {
                    });
            log.info("getData response data {}", response.getBody());
            return response.getBody();
        }catch (Exception ex) {
            log.info("Error getting Data Envelope {}", ex);
            throw new Exception(ex.getMessage());
        }

    }

    @Override
    public Boolean updateData(String blockName, String newBlockType) throws Exception {
        log.info("Updating blocktype to {} for block with name {}", newBlockType, blockName);

        log.info("Updating data {} to {}", blockName, newBlockType);
        try {
        ResponseEntity<Boolean> response = restTemplate.exchange(CLIENT_UPDATE_DATA_URL + "/" + blockName + "/" + newBlockType, HttpMethod.PUT, null, Boolean.class);
        log.info("Response Status {}", response.getBody());

        return response.getBody();
        }catch (Exception ex) {
            log.info("Error getting Data Envelope {}", ex);
            throw new Exception(ex.getMessage());
        }

    }


}
