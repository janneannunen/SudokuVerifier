import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testVerify() {
		SudokuVerifier sudo = new SudokuVerifier();
		String string = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int result = sudo.verify(string);
		assertEquals("Verify pass fail ", 1, result);
	}
	@Test
	public void testVerifyFail() {
		SudokuVerifier sudo = new SudokuVerifier();
		String string = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		int result = sudo.verify(string);
	
		assertEquals("Verify fail fail ", 0, result);
	}
}
