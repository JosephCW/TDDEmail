package com.josephwatts.tddemail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TemplateTest {

	private Template template;
	
	@Before
	public void setUp() throws Exception {
		template = new Template("${one}, ${two}, ${three}.");
		template.set("one", "1");
		template.set("two", "2");
		template.set("three", "3");
	}
	
	@Test
	public void multipleVariables() throws Exception {
		assertTemplateEvaluatesTo("1, 2, 3.");
	}
	
	@Test
	public void unknownVariableAreIgnored() throws Exception {
		template.set("doesnotexist", "Hi.");
		assertTemplateEvaluatesTo("1, 2, 3.");
	}
	
	private void assertTemplateEvaluatesTo(String expected) {
		assertEquals(expected, template.evaluate());
	}
	
	@Test
	public void missingValueRaisesException() throws Exception {
		try {
			new Template("${foo}").evaluate();
			fail("evaluate() should throw an exception if "
					+ "a variable was left without a value!");
		} catch (MissingValueException expected) {
			assertEquals("No value for ${foo}",
					expected.getMessage());
		}
	}
}
