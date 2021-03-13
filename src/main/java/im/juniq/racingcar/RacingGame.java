package im.juniq.racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
	private List<Car> cars = new ArrayList<>();

	public static void main(String[] args) {
		RacingGame racingGame = new RacingGame();
		racingGame.play();
	}

	public void play() {
		InputView inputView = new InputView();
		inputView.scan();
		createCars(inputView.getNumberOfCars());
		racing(inputView.getNumberOfTries());
	}

	public void createCars(int numberOfCars) {
		for (int i = 0; i < numberOfCars; i++) {
			cars.add(new Car(i));
		}
	}

	private void racing(int numberOfTries) {
		for (int i = 0; i < numberOfTries; i++) {
			moveCars(new RandomNumberMovingStrategy());
			printCarsMoveCount();
		}
	}

	public void moveCars(MovingStrategy movingStrategy) {
		for (Car car : cars) {
			car.move(movingStrategy);
		}
	}

	private void printCarsMoveCount() {
		ResultView resultView = new ResultView(cars);
		resultView.printCarMoveCount();
	}

	public List<Car> getCars() {
		return cars;
	}
}
