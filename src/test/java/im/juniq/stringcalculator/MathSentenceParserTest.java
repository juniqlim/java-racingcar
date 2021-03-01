package im.juniq.stringcalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MathSentenceParserTest {
	@ParameterizedTest
	@ValueSource(strings = {"2 + 3 * 4 / 2"})
	void testParser(String input) {
		String[] destnation = {"2", "+", "3", "*", "4", "/", "2"};

		MathSentenceParser separator = new MathSentenceParser(input);

		Assertions.assertArrayEquals(destnation, separator.parse());
	}

	@ParameterizedTest
	@NullSource
	@EmptySource
	void testParserInputNullAndBlank(String input) {
		MathSentenceParser separator = new MathSentenceParser(input);

		Assertions.assertThrows(IllegalArgumentException.class, () -> separator.parse());
	}

	@ParameterizedTest
	@ValueSource(strings = {"2 + 3 * 4 2", "2 + 3 * 4 @ 2"})
	void testParserInputOperator(String input) {
		MathSentenceParser separator = new MathSentenceParser(input);

		Assertions.assertThrows(IllegalArgumentException.class, () -> separator.parse());
	}
}
