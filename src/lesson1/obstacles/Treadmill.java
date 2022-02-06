package lesson1.obstacles;


import lesson1.participants.Participants;

public class Treadmill implements Obstacle{
    private final int DISTANCE = 1500; // Полагая, что испытание для всех одинаково

    @Override
    public boolean passObstacles(Participants pa) {
        return pa.run(DISTANCE);
    }
}
