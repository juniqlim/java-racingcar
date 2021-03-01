package im.juniq.stringcalculator;

import java.util.Arrays;
import java.util.List;

public class MathSentenceParser {
	private static final String SEPARATOR = " ";
	private String input;
	private String[] destnation;

	public MathSentenceParser(String input) {
		this.input = input;
	}

	public String[] parse() {

		validInputIsNullAndBlank();
		splitInput();
		validFourOperatorSymbol();

		return destnation;
	}

	private void validInputIsNullAndBlank() {
		if (input == null || "".equals(input)) {
			throw new IllegalArgumentException("input cannot be null or blank");
		}
	}

	private void splitInput() {
		destnation = input.split(SEPARATOR);
	}

	private void validFourOperatorSymbol() {
		for (int i = 0; i < destnation.length; i++) {
			checkEvenTermIfOperator(i);
		}
	}

	private void checkEvenTermIfOperator(int i) {
		if (i % 2 == 1) {
			checkFourOperator(destnation[i]);
		}
	}

	private void checkFourOperator(String s) {
		if (!"+-*/".contains(s)) {
			throw new IllegalArgumentException("even number must be an operator");
		}
	}
}
