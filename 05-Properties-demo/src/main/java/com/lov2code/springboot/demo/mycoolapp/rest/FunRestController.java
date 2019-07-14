package com.lov2code.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	@Value("{coach.name}")
	private String coachName;
	@Value("{team.name}")
	private String teamName;
	
	@GetMapping("/teamInfo")
	public String getTeamInfo() {
		return "Coach:" +coachName+" , TeamName:"+ teamName;
	}

	@GetMapping("/")
	public String sayHello() {
		return "Hello Word Time on Server is" +LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String grtDailyWorkout() {
		return "Work Hard";
	}
}











