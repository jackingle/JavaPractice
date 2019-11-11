import static org.junit.Assert.*;

import org.junit.Test;

public class LibClassTest {

	@Test
	public void testAcrostic() {
		System.err.println("Running testAcrostic...");
		String result = LibClass.acrostic(new String[] {
				"fnord", "polly", "tropism"
		});
		assertEquals("Correct value", "foo", result);
	}

}
