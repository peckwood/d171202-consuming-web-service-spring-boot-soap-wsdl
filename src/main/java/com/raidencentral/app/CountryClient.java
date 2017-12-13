package com.raidencentral.app;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.raidencentral.app.wsdlartifact.GetCountryRequest;
import com.raidencentral.app.wsdlartifact.GetCountryResponse;

public class CountryClient extends WebServiceGatewaySupport{
	public GetCountryResponse getCountry(String countryName){
		GetCountryRequest request = new GetCountryRequest();
		request.setName(countryName);
		GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(request);
		return response;
	}
}
