package lesson14;

public class HW14 {

    public int[] after4(int[] ar) {
        if (ar.length > 1) {
            int last4index = -1;
            for (int i = 0; i < ar.length; i++) {
                if (ar[i] == 4) {
                    last4index = i;
                }
            }
            if (last4index == -1) {
                throw new RuntimeException("No 4");
            } else {
                int[] after4array = new int[ar.length - last4index - 1];
                for (int i = 0; i < after4array.length; i++) {
                    after4array[i] = ar[last4index + 1 + i];
                }
                return after4array;
            }
        } else {
            System.out.println("Nothing to process");
            return ar;
        }
    }

    public boolean check1and4(int[] ar) {
        int count1 = 0;
        int count4 = 0;
        for (int el : ar) {
            if (el == 1) {
                count1++;
            } else if (el == 4) {
                count4++;
            } else {
                return false;
            }
        }
        return count1 != 0 && count4 != 0;
    }

    public static void main(String[] args) {

    }
}