package controller;

import domain.Car;
import domain.Const;
import domain.Race;
import util.Util;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {

    private static List<Car> makeCarList(List<String> carNameList) {
        Util.checkDuplicatedStringList(carNameList);
        Util.checkStringListSize(carNameList);
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    public static List<Car> setCarName() {
        try {
            return makeCarList(InputView.inputCarNameList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setCarName();
        }
    }

    public static int setRoundCount() {
        try {
            int roundCount = InputView.inputRoundCount();
            if (roundCount <= Const.ZERO) {
                throw new IllegalArgumentException();
            }
            return roundCount;
        } catch (Exception e) {
            System.out.println(Const.EX_ROUND_COUNT);
            return setRoundCount();
        }
    }

    public static Race moveAllCar(List<Car> carList, int roundCount) {
        Race race = new Race(carList);
        OutputView.outputGameResultTile();
        for (int i = 0; i < roundCount; i++) {
            race.moveAllCarOneTime();
            OutputView.outputGameResult(race.getRaceCars());
        }
        return race;
    }

    public static void printWinners(Race race) {
        OutputView.outputWinners(race.getRaceWinners());
    }
}
