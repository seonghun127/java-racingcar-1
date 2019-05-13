package view;

import domain.Car;
import domain.Const;

import java.util.List;

public class OutputView {
    public static void outputGameResultTile() {
        System.out.println(Const.OUTPUT_GAME_RESULT);
    }

    public static void outputGameResult(List<Car> carsOnRace) {
        for (Car car : carsOnRace) {
            System.out.println(car);
        }
        System.out.println();
    }

    public static void outputWinners(String winners) {
        System.out.println(winners + Const.OUTPUT_WINNER);
    }
}
