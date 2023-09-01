package com.citi.ms;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//[MS1,315747a31d3a95c6,315747a31d3a95c6]
//[MS2,315747a31d3a95c6,f5b56fcbc3b9a78d]
//[MS3,315747a31d3a95c6,37c0de46f20fb7b2]
@RestController
public class RestControllerMS1 {

	@Autowired
	private RestTemplate template;
	
	@GetMapping("/ms2/{data}")
	public String microservice1(@PathVariable String data)
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return template.getForObject("http://MS3/ms3/"+data, String.class);
	}
}
