package com.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.ElectricModel;

@RestController
@RequestMapping("/totalbill")
public class ElectricController {
	@RequestMapping(value="/{initialReading}/{monthlyReading}", method=RequestMethod.GET)
	public String validateUser(@PathVariable double initialReading, @PathVariable double monthlyReading) {
		ElectricModel electricity = new ElectricModel(initialReading, monthlyReading);
		electricity.setTotalBill((electricity.getMonthlyReading()-electricity.getInitialReading())*ElectricModel.COST_PER_UNIT);
		return "Total Bill : "+electricity.getTotalBill();
	}
}
