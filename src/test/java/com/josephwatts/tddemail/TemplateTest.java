package com.josephwatts.tddemail;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TemplateTest {

	@Test
	public void oneVariable() throws Exception {
		Template template = new Template("Hello, ${name}");
		template.set("name", "Reader");
		assertEquals("Hello, Reader", template.evaluate());
	}
	
	@Test
	public void multipleVariables() throws Exception {
		Template template = new Template("${one}, ${two}, ${three}.");
		template.set("one", "1");
		template.set("two", "2");
		template.set("three", "3");
		assertEquals("1, 2, 3.", template.evaluate());
	}
	
	@Test
	public void unknownVariableAreIgnored() throws Exception {
		Template template = new Template("Hello, ${name}");
		template.set("name", "Reader");
		template.set("doesnotexist", "Hi.");
		assertEquals("Hello, Reader", template.evaluate());
	}
}
