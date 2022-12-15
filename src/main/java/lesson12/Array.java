package lesson12;

import java.util.Arrays;

public class Array {

    double[] array;

    /**
     * Array constructor
     * @param size of array
     */
    public Array(int size) {
        this.array = new double[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    /**
     * Calculating each array's element
     * @param arr for calculations
     * @return new array with calculated values
     */
    public double[] arrayProcess(double[] arr) {
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] * Math.sin(0.2 + ((double) array.length) / 5) *
                        Math.cos(0.2 + ((double) array.length) / 5) * Math.cos(0.4 + ((double) array.length) / 2);
            }
        }
        return arr;
    }

    /**
     * Calculates time to process single thread array
     */
    public void singleThreadProcess() {
        long time1 = System.currentTimeMillis();
        double[] processedArray = arrayProcess(array);
        long delay = System.currentTimeMillis() - time1;
//        System.out.println(Arrays.toString(processedArray));
        System.out.printf("Single thread delay %d ms\n", delay);
    }

    /**
     * Test method with arguments to check how several threads work simultaneously
     * @param sleep time in ms
     * @param currentThread number of thread
     */
    public static void testMethod(int sleep, int currentThread) {
        System.out.println("Test method started #" + currentThread);
        try{
            Thread.sleep(sleep);
            System.out.println("Some actions in the thread #" + currentThread);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("Finished method #" + currentThread);
    }

    /**
     * Calculates time to process an array with mutliple threads
     * @param threadsNumber given number of threads
     */
    public void multiThreadsProcess(int threadsNumber) {
        double[] processedArray = new double[array.length];
        long time1 = System.currentTimeMillis();
        // new array with given number of threads
        Thread[] threads = new Thread[threadsNumber];
        for (int i = 0; i < threadsNumber; i++) {
            int threadNo = i;
            // lambda expression for each thread
            threads[i] = new Thread(() -> {
                int startingPosition;
                double[] subArray;
                int elements;
                // distributing elements from parent array to sub array
                try {
                    // constructing sub array
                    if (threadNo == threadsNumber - 1) {
                        subArray = new double[array.length -
                                ((int) Math.ceil((double) array.length / threadsNumber)) * (threadsNumber - 1)];
                        elements = array.length -
                                ((int) Math.ceil((double) array.length / threadsNumber)) * (threadsNumber - 1);
                    } else {
                        subArray = new double[(int) Math.ceil((double) array.length / threadsNumber)];
                        elements = (int) Math.ceil((double) array.length / threadsNumber);
                    }
                    startingPosition = ((int) Math.ceil((double) array.length / threadsNumber)) * threadNo;
                    System.arraycopy(array, startingPosition, subArray, 0, elements);
                    // calculating values for sub array
                    arrayProcess(subArray);
//                    System.out.println(Arrays.toString(subArray));
                    // adding sub array to new processed array
                    System.arraycopy(subArray, 0, processedArray, startingPosition, subArray.length);
                } catch (Exception e) {
                    System.out.println("Wrong threads number");
                }
            });
            threads[i].start();
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        long delay = System.currentTimeMillis() - time1;
        System.out.printf("%d threads delay %d ms\n", threadsNumber, delay);
//        System.out.println(Arrays.toString(processedArray));
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}