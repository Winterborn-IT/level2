package lesson5;

import java.util.Arrays;

public class Main {
    private static final int SIZE = 10_000_000;
    private static final int HALF_SIZE = 5_000_000;

    public static void main(String[] args) {
        first();
        second();
    }

    public static void first() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end = System.currentTimeMillis();
        System.out.println("Время однопоточного выполнения = " + (end - start) + " ms.");

    }

    public static void second() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        float[] arrLeft = new float[HALF_SIZE];
        float[] arrRight = new float[HALF_SIZE];

        long start = System.currentTimeMillis();

        System.arraycopy(arr, 0, arrLeft, 0, HALF_SIZE);
        System.arraycopy(arr, HALF_SIZE, arrRight, 0, HALF_SIZE);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < arrLeft.length; i++) {
                arrLeft[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Время выполнения первого потока = " + (System.currentTimeMillis() - start) + " ms.");
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < arrRight.length; i++) {
                arrRight[i] = (float) (arr[i] * Math.sin(0.2f + (i + HALF_SIZE) / 5) * Math.cos(0.2f + (i + HALF_SIZE) / 5) * Math.cos(0.4f + (i + HALF_SIZE) / 2));
            }
            System.out.println("Время выполнения второго потока = " + (System.currentTimeMillis() - start) + " ms.");
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        float[] mergeArr = new float[SIZE];
        System.arraycopy(arrLeft, 0, mergeArr, 0, HALF_SIZE);
        System.arraycopy(arrRight, 0, mergeArr, HALF_SIZE, HALF_SIZE);

        System.out.println("Время выполнения двумя потоками =  " + (System.currentTimeMillis() - start) + " ms.");

    }
}
