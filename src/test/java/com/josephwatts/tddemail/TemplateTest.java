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
}
