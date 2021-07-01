package cn.mitrecx.sort;

public class CountingSort {
    private int getMax(int[] a) {
        if (a == null || a.length == 0) {
            throw new RuntimeException("invalid array.");
        }
        int max = a[0];
        for (int j : a) {
            if (max < j) {
                max = j;
            }
        }
        return max;
    }

    /**
     * @param a value from Integer.Zero to Integer.Max
     */
    public int[] unstableSort(int[] a) {
        int[] countArray = new int[getMax(a) + 1];
        for (int k : a) {
            countArray[k]++;
        }

        int[] sorted = new int[a.length];
        int j = 0;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                sorted[j++] = i;
                countArray[i]--;
            }
        }
        return sorted;
    }

    /**
     * @param a value from Integer.Zero to Integer.Max
     */
    public int[] stableSort(int[] a) {
        int[] countArray = new int[getMax(a) + 1];
        for (int k : a) {
            countArray[k]++;
        }
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] = countArray[i] + countArray[i - 1];
        }
        int[] sorted = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            sorted[countArray[a[i]] - 1] = a[i];
            countArray[a[i]]--;
        }
        return sorted;
    }

    public static void main(String[] args) {
        int[] a = {1, 9, 8, 7, 0, 5, 4, 5};
        CountingSort cs = new CountingSort();
//      int[] sorted1 = cs.unstableSort(a);
//        for (int i : sorted1) {
//            System.out.println(i);
//        }
        int[] sorted2 = cs.stableSort(a);
        for (int i : sorted2) {
            System.out.println(i);
        }
    }
}
