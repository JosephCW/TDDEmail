package com.josephwatts.tddemail;

public class Template {
	private String templateText;
	private String variableValue;
	
	public Template(String templateText) {
		this.templateText = templateText;
	}

	public void set(String variable, String value) {
		this.variableValue = value;
	}

	public String evaluate() {
		return templateText.replaceAll("\\$\\{name\\}", variableValue);
	}
}
