package com.data.client.api.controller;

import com.data.client.api.model.DataEnvelope;
import com.data.client.api.model.ResponseMessage;
import com.data.client.api.service.DataClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dataclient")
public class DataClientController {

    @Autowired
    private DataClientService dataClientService;

    @PostMapping("/pushData")
    public ResponseEntity<Object> pushData(@RequestBody DataEnvelope dataEnvelope) throws Exception {
        log.info("Pushing data {}", dataEnvelope.getDataHeader().getName());

        try {
            Boolean pushDataFlag = dataClientService.pushDataEnvelope(dataEnvelope);
            final String responseMsg = pushDataFlag ? ResponseMessage.SUCCESS.getDescription() : ResponseMessage.FAILURE.getDescription();

            return new ResponseEntity<>(responseMsg, HttpStatus.OK);

        } catch (Exception ex) {
            throw new Exception(ResponseMessage.UNIQUE.getDescription());
        }
    }


    @GetMapping("/getData/{blockType}")
    public ResponseEntity<Object> getDataByBlockType(@PathVariable String blockType) throws Exception {
        log.info("Query for data with header block type {}", blockType);
        try {
            List<DataEnvelope> DataEnvelopList = dataClientService.getData(blockType);
            if (!CollectionUtils.isEmpty(DataEnvelopList)) {
                return new ResponseEntity<>(DataEnvelopList, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());

        }
    }

    @PutMapping("/updateData/{blockName}/{newBlockType}")
    public ResponseEntity<Object> updateDataBy(@PathVariable String blockName, @PathVariable String newBlockType) throws Exception {
        log.info("Updating blocktype to {} for block with name {}", newBlockType, blockName);
        try {
            return new ResponseEntity<>(dataClientService.updateData(blockName, newBlockType), HttpStatus.OK);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
