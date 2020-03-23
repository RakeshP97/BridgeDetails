package com.bridge.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridge.dao.BridgeDAO;
import com.bridge.model.Bridge;

@Service
public class BridgeServiceImpl implements BridgeService{
	
	@Autowired
	BridgeDAO dao;
	
	/***
	 * This method used to get the bridge details 
	 * @return Bridge
	 */
	public ArrayList<Bridge> getBridgeDetails(){
		return dao.getBridgeDetails();
	}
	
	/**
	 * This method used add the new bridge to Mango DB collections
	 * @param b
	 */
	public void addNewBridge(Bridge b) {
		dao.addNewBridge(b);
	}

}
