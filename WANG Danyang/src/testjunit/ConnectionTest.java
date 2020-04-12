package testjunit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import database.ConnectionBD;

public class ConnectionTest {
	
	@Test
	public void testConnectionBD() throws Exception{
		System.out.println("ConnectionBD");
		Result result = JUnitCore.runClasses(ConnectionBD.class);
		assertEquals(result != null, true);
	}
}
