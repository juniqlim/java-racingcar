package im.juniq.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {
	@DisplayName("자동차 n대를 생성한다")
	@ParameterizedTest
	@ValueSource(ints = {5})
	void createRacingCar(int numberOfCarsToBuild) {
		for (int i = 0; i < numberOfCarsToBuild; i++) {
			RacingCar racingCar = new RacingCar(i);
		}
	}
}