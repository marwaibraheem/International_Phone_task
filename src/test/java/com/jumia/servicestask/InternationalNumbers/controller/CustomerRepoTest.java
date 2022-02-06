package com.jumia.servicestask.InternationalNumbers.controller;



import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CustomerRepoTest {
	
	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	void reteriveAllByCountry() throws JSONException {
		String response=this.restTemplate.getForObject("/jpa/customers/country/Morocco", String.class);
		JSONAssert.assertEquals(
		  "[\r\n" + 
		  "    {\r\n" + 
		  "        \"id\": 0,\r\n" + 
		  "        \"name\": \"Walid Hammadi\",\r\n" + 
		  "        \"phoneNumber\": \"(212) 6007989253\",\r\n" + 
		  "        \"country\": \"Morocco\",\r\n" + 
		  "        \"state\": null\r\n" + 
		  "    },\r\n" + 
		  "    {\r\n" + 
		  "        \"id\": 1,\r\n" + 
		  "        \"name\": \"Yosaf Karrouch\",\r\n" + 
		  "        \"phoneNumber\": \"(212) 698054317\",\r\n" + 
		  "        \"country\": \"Morocco\",\r\n" + 
		  "        \"state\": null\r\n" + 
		  "    },\r\n" + 
		  "    {\r\n" + 
		  "        \"id\": 2,\r\n" + 
		  "        \"name\": \"Younes Boutikyad\",\r\n" + 
		  "        \"phoneNumber\": \"(212) 6546545369\",\r\n" + 
		  "        \"country\": \"Morocco\",\r\n" + 
		  "        \"state\": null\r\n" + 
		  "    },\r\n" + 
		  "    {\r\n" + 
		  "        \"id\": 3,\r\n" + 
		  "        \"name\": \"Houda Houda\",\r\n" + 
		  "        \"phoneNumber\": \"(212) 6617344445\",\r\n" + 
		  "        \"country\": \"Morocco\",\r\n" + 
		  "        \"state\": null\r\n" + 
		  "    },\r\n" + 
		  "    {\r\n" + 
		  "        \"id\": 4,\r\n" + 
		  "        \"name\": \"Chouf Malo\",\r\n" + 
		  "        \"phoneNumber\": \"(212) 691933626\",\r\n" + 
		  "        \"country\": \"Morocco\",\r\n" + 
		  "        \"state\": null\r\n" + 
		  "    },\r\n" + 
		  "    {\r\n" + 
		  "        \"id\": 5,\r\n" + 
		  "        \"name\": \"soufiane fritisse \",\r\n" + 
		  "        \"phoneNumber\": \"(212) 633963130\",\r\n" + 
		  "        \"country\": \"Morocco\",\r\n" + 
		  "        \"state\": null\r\n" + 
		  "    },\r\n" + 
		  "    {\r\n" + 
		  "        \"id\": 6,\r\n" + 
		  "        \"name\": \"Nada Sofie\",\r\n" + 
		  "        \"phoneNumber\": \"(212) 654642448\",\r\n" + 
		  "        \"country\": \"Morocco\",\r\n" + 
		  "        \"state\": null\r\n" + 
		  "    }\r\n" + 
		  "]", response, false);
		}
	

	@Test
	void reteriveAllByPhone() throws JSONException {
		
		String response=this.restTemplate.getForObject("/jpa/customers/phone/(212) 6007989253", String.class);
		JSONAssert.assertEquals(
				  "{\r\n" + 
				  "    \"id\": 0,\r\n" + 
				  "    \"name\": \"Walid Hammadi\",\r\n" + 
				  "    \"phoneNumber\": \"(212) 6007989253\",\r\n" + 
				  "    \"country\": \"Morocco\",\r\n" + 
				  "    \"state\": null\r\n" + 
				  "}", response, false);
				
		
	}


	@Test
	void reteriveByCountryAndState() throws JSONException {
		
		String response=this.restTemplate.getForObject("http://localhost:8092/jpa/customers/find/Mor/valid", String.class);
		JSONAssert.assertEquals(
				  "[\r\n" + 
				  "    {\r\n" + 
				  "        \"id\": 1,\r\n" + 
				  "        \"name\": \"Yosaf Karrouch\",\r\n" + 
				  "        \"phoneNumber\": \"(212) 698054317\",\r\n" + 
				  "        \"country\": \"Morocco\",\r\n" + 
				  "        \"state\": \"valid\"\r\n" + 
				  "    },\r\n" + 
				  "    {\r\n" + 
				  "        \"id\": 4,\r\n" + 
				  "        \"name\": \"Chouf Malo\",\r\n" + 
				  "        \"phoneNumber\": \"(212) 691933626\",\r\n" + 
				  "        \"country\": \"Morocco\",\r\n" + 
				  "        \"state\": \"valid\"\r\n" + 
				  "    },\r\n" + 
				  "    {\r\n" + 
				  "        \"id\": 5,\r\n" + 
				  "        \"name\": \"soufiane fritisse \",\r\n" + 
				  "        \"phoneNumber\": \"(212) 633963130\",\r\n" + 
				  "        \"country\": \"Morocco\",\r\n" + 
				  "        \"state\": \"valid\"\r\n" + 
				  "    },\r\n" + 
				  "    {\r\n" + 
				  "        \"id\": 6,\r\n" + 
				  "        \"name\": \"Nada Sofie\",\r\n" + 
				  "        \"phoneNumber\": \"(212) 654642448\",\r\n" + 
				  "        \"country\": \"Morocco\",\r\n" + 
				  "        \"state\": \"valid\"\r\n" + 
				  "    }\r\n" + 
				  "]", response, false);
				
		
	}


}
