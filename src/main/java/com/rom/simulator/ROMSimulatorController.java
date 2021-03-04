package com.rom.simulator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rom")
@CrossOrigin(origins = "*")
public class ROMSimulatorController {
	private Logger log = LogManager.getLogger(ROMSimulatorController.class);
	
	@Autowired(required = true)
	private ROMSimulatorService simulatorService;
	
	@PostMapping("/simulate/{times}")
	public void simulate(@PathVariable Long times) {
		log.debug("ROMSimulatorController.simulate() No. of orders to be simulated : " + times);
		simulatorService.simulate(times);
	}
}
