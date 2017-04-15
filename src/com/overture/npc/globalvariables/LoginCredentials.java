package com.overture.npc.globalvariables;

public class LoginCredentials {
	
	private final String NPC_DEV_USERNAME = "seoAdmin";
	private final String NPC_DEV_INVALID_USERNAME = "seoAdmin_1";
	private final String NPC_DEV_PASSWORD = "Overture1";
	
	private final String NPC_UAT_USERNAME = "seoAdmin";
	private final String NPC_UAT_INVALID_USERNAME = "seoAdmin_1";
	private final String NPC_UAT_PASSWORD = "Overture1";
	
	
	private final String NPC_PROD_USERNAME = "pravinAdmin";
	private final String NPC_PROD_INVALID_USERNAME = "pravinAdmin_1";
	private final String NPC_PROD_PASSWORD = "Password1!";
	
	public String getNPC_DEV_USERNAME() {
		return NPC_DEV_USERNAME;
	}

	public String getNPC_DEV_PASSWORD() {
		return NPC_DEV_PASSWORD;
	}

	public String getNPC_UAT_USERNAME() {
		return NPC_UAT_USERNAME;
	}

	public String getNPC_UAT_PASSWORD() {
		return NPC_UAT_PASSWORD;
	}
	
	public String getNPC_UAT_INVALID_USERNAME() {
		return NPC_UAT_INVALID_USERNAME;
	}

	public String getNPC_PROD_USERNAME() {
		return NPC_PROD_USERNAME;
	}

	public String getNPC_PROD_PASSWORD() {
		return NPC_PROD_PASSWORD;
	}

	public String getNPC_LOCAL_INVALID_USERNAME() {
		return NPC_DEV_INVALID_USERNAME;
	}

	public String getNPC_PROD_INVALID_USERNAME() {
		return NPC_PROD_INVALID_USERNAME;
	}

	

}
