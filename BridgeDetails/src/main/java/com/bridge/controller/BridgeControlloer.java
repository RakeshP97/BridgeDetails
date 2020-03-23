package com.bridge.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bridge.model.Bridge;
import com.bridge.service.BridgeService;

@Controller
@RequestMapping("/bridge-module/addNew")
@SessionAttributes("formData")
public class BridgeControlloer {

	@Autowired
	BridgeService bservice;

	@ModelAttribute("formData")
	public Bridge populateForm() {
	    return new Bridge();
	}
	@RequestMapping(method = RequestMethod.GET)
	public String addCommentForm(ModelMap model) {
		System.out.println("Form setup");

		model.addAttribute("formData", new Bridge());
		return "bridgeView";
	}

	@RequestMapping(value = "/bridge")
	@ResponseBody
	public ArrayList<Bridge> getMessage1(Model model) {
		return bservice.getBridgeDetails();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("formData") Bridge bridge, BindingResult result, Model model, SessionStatus status) {
		status.setComplete();
		System.out.println(bridge.toString());
		bservice.addNewBridge(bridge);
		model.addAttribute("formData", new Bridge());
		return "bridgeView";
	}
}
