package com.bridge.dao;

import java.util.ArrayList;

import com.bridge.model.Bridge;

public interface BridgeDAO {
	
	/**
	 * This method used to get the bridge details from mango database
	 * @return Bridge
	 */

	public ArrayList<Bridge> getBridgeDetails();
	
	/**
	 * This method used to add the new bridge object into DB
	 * @param b
	 */
	public void addNewBridge(Bridge b);
	
}
