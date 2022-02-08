package lesson1.participants;

public class Robot implements Participants {
    private String name;
    private final int MAX_JUMP = 8;
    private final int MAX_RUN = 10000;

    public Robot(String name) {
        this.name = name;
    }

    private void runResult(boolean res) {
        if (res) {
            System.out.printf("Робот %s смог пробежать дорожку%n", name);
        } else {
            System.out.printf("Робот %s не смог пробежать дорожку%n", name);
        }
    }

    private void jumpResult(boolean res) {
        if (res) {
            System.out.printf("Робот %s смог перепрыгнуть стену%n", name);
        } else {
            System.out.printf("Робот %s не смог перепрыгнуть стену%n", name);
        }
    }

    @Override
    public boolean run(int distance) {
        if (distance <= MAX_RUN) {
            runResult(true);
            return true;
        } else {
            runResult(false);
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if (height <= MAX_JUMP) {
            jumpResult(true);
            return true;
        } else {
            jumpResult(false);
            return false;
        }
    }
}
