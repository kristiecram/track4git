package org.ssglobal.training.codes;

public class Country {

	public enum Choice {BRZ, PHL, JPN, USA, SPN}
	
	public String sayGreet(Choice country) {
		
		switch(country) {
		case PHL:
			return "MABUHAY";
		case BRZ:
			return "Obrigado";
		case JPN: 
			return "Ohayou gozaimasu";
		case USA:
			return "Hello";
		case SPN: 
			return "Co musta";
		default:
			return null;
		}
	}
 }
