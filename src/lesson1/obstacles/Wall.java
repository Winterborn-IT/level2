package lesson1.obstacles;


import lesson1.participants.Participants;

public class Wall implements Obstacle{
    private final int HEIGHT = 3; // Полагая, что испытание для всех одинаково

    @Override
    public boolean passObstacles(Participants pa) {
        return pa.jump(HEIGHT);
    }
}

