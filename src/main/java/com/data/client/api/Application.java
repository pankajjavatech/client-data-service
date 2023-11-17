package com.data.client.api;

import com.data.client.api.service.DataClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.retry.annotation.EnableRetry;

import java.io.UnsupportedEncodingException;
import java.util.List;

import static com.data.client.api.Constant.DUMMY_DATA;

@SpringBootApplication
@EnableRetry
public class Application {

	public static final String HEADER_NAME = "TSLA-USDGBP-10Y";
	public static final String MD5_CHECKSUM = "cecfd3953783df706878aaec2c22aa70";

	@Autowired
	private DataClientService client;



	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	/*@EventListener(ApplicationReadyEvent.class)
	public void initiatePushDataFlow() throws JsonProcessingException, UnsupportedEncodingException {
		pushData();

		queryData();

		updateData();
	}

	private void updateData() throws UnsupportedEncodingException {
		boolean success = client.updateData(HEADER_NAME, BlockTypeEnum.BLOCKTYPEB.name());
	}

	private void queryData() {

		List<DataEnvelope> data = client.getData(BlockTypeEnum.BLOCKTYPEA.name());
	}

	private void pushData() throws JsonProcessingException {

		DataBody dataBody = new DataBody(DUMMY_DATA);

		DataHeader dataHeader = new DataHeader(HEADER_NAME, BlockTypeEnum.BLOCKTYPEA);

		DataEnvelope dataEnvelope = new DataEnvelope(dataHeader, dataBody);

		client.pushData(dataEnvelope);
	}
*/



}
