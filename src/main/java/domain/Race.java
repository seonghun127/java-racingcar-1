package domain;

import util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Race {
    private List<Car> carsOnRace;
    private int roundCount;
    private int currentRound;

    public Race(List<String> carNames, int roundCount) {
        this.carsOnRace = new CarsFactory(carNames).createCars();
        this.roundCount = roundCount;
        this.currentRound = Const.FIRST_ROUND;
    }

    public List<Car> moveAllCarsByRoundCount() {
        for (Car car : carsOnRace) {
            car.increasePositionOrNot(Util.getRandomNumber());
        }
        return carsOnRace;
    }

    public boolean hasNextRound() {
        return this.roundCount >= this.currentRound++;
    }

    public List<CarDto> getCarsOnFinishedRace(){
        List<CarDto> carsOnFinishedRace = new ArrayList<>();

        carsOnRace.stream()
                .map(c -> new CarDto(c.getName(), c.getPosition()))
                .forEach(carsOnFinishedRace::add);

        return carsOnFinishedRace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return roundCount == race.roundCount &&
                Objects.equals(carsOnRace, race.carsOnRace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carsOnRace, roundCount);
    }
}
