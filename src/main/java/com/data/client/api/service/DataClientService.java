package com.data.client.api.service;

import com.data.client.api.model.DataEnvelope;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface DataClientService {
    Boolean pushDataEnvelope(DataEnvelope dataEnvelope) throws JsonProcessingException;
    List<DataEnvelope> getData(String blockType) throws Exception;
    Boolean updateData(String blockName, String newBlockType) throws Exception;
}
