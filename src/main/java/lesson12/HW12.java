package lesson12;

public class HW12 {

    public static void main(String[] args) {
        System.out.println("Starting app\n");
        int size = 10_000_000;

        Array array1 = new Array(size);
        Array array2 = new Array(size);
        Array array3 = new Array(size);
        Array array4 = new Array(size);
        Array array5 = new Array(size);
        Array array6 = new Array(size);

        array1.singleThreadProcess();
        array2.multiThreadsProcess(2);
        array3.multiThreadsProcess(4);
        array4.multiThreadsProcess(10);
        array5.multiThreadsProcess(100);
        array6.multiThreadsProcess(1000);

        System.out.println("\nFinishing app");
    }
}