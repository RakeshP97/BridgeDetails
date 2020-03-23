package com.bridge.service;

import java.util.ArrayList;

import com.bridge.model.Bridge;

public interface BridgeService {
	
	/***
	 * This method used to get the bridge details 
	 * @return Bridge
	 */
	
	public ArrayList<Bridge> getBridgeDetails();
	
	/**
	 * This method used add the new bridge to Mango DB collections
	 * @param b
	 */
	public void addNewBridge(Bridge b);

}
