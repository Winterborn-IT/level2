package lesson1;


import lesson1.obstacles.*;
import lesson1.participants.*;

public class Main {
    public static void main(String[] args) {
        Participants[] participants =  {
                new Cat("Барсик"),
                new Human("Игорь"),
                new Robot("Скайнет")
        };

        Obstacle[] obstacles = {
                new Wall(),
                new Treadmill()
        };

        for (Participants mem: participants) {
            for (Obstacle obs: obstacles  ) {
                if (!(obs.passObstacles(mem))) {
                    break;
                }
            }
        }

    }
}
