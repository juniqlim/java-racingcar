package im.juniq.racingcar;

import im.juniq.racingcar.domain.Car;
import im.juniq.racingcar.domain.OnlyTrueMovingStrategy;
import im.juniq.racingcar.domain.RacingGame;
import im.juniq.racingcar.domain.RandomNumberMovingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
	@DisplayName("자동차 n대를 생성한다")
	@Test
	void createCars() {
		String[] carNames = {"pobi", "poci"};
		RacingGame racingGame = new RacingGame();
		racingGame.createCars(carNames, new RandomNumberMovingStrategy());

		assertThat(racingGame.getCarsStatus()).contains(carNames);
	}

	@DisplayName("자동차 n대를 이동한다")
	@Test
	void moveCars() {
		Car pobi = new Car("pobi", new OnlyTrueMovingStrategy());
		Car poci = new Car("poci", new OnlyTrueMovingStrategy());
		RacingGame racingGame = new RacingGame(pobi, poci);

		racingGame.move();

		assertThat(racingGame.getCarsStatus()).contains("-");
	}

	@DisplayName("가장 먼 위치에 도달한 차 찾기")
	@Test
	void findByTopPosition() {
		Car pobi = new Car("pobi", new OnlyTrueMovingStrategy());
		Car poci = new Car("poci", new RandomNumberMovingStrategy());
		RacingGame racingGame = new RacingGame(pobi, poci);

		for (int i = 0; i < 10; i++) {
			racingGame.move();
		}

		assertThat(racingGame.getWinner()).isEqualTo("pobi");
	}
}