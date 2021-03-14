package im.juniq.racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private List<Car> cars = new ArrayList<>();

	public Cars(Car... car) {
		cars.addAll(Arrays.asList(car));
	}

	public void createCars(String[] carNames) {
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	public void move() {
		for (Car car : cars) {
			car.move();
		}
	}

	public List<Car> findByTopPosition() {
		int topPosition = cars.stream()
			.max(Comparator.comparing(Car::getPosition))
			.orElseThrow(IllegalStateException::new)
			.getPosition();

		return cars.stream().filter(car -> topPosition == car.getPosition())
			.collect(Collectors.toCollection(ArrayList::new));
	}

	public List<Car> get() {
		return cars;
	}

	public Car get(int index) {
		return cars.get(index);
	}
}
