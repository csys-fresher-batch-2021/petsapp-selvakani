package app;

import static org.junit.Assert.fail;

import org.junit.Test;

import in.selva.util.ConnectionUtil;

public class ConnectionTest {
    
	@Test
	public static void main(String[] args) {
		try {
			ConnectionUtil.getConnection();
			System.out.println("success");
		} catch (Exception e) {
			fail();
		}
	}

}