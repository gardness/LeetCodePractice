public class AAA {

    public static void arrayEg() {
        int[] array = new int[]{1, 2, 3};
        int[] arr = new int[10];

        arr[0] = 1;

        int[][] array2 = new int[][]{
                {1, 2, 3},
                {1, 2, 3}
        };

        int[][] arr2 = new int[3][2];

    }

    public static void isNullorEmpty(String str) {
        if (str == null) {
            System.out.println("str == null");
        } else if (str.length() == 0) {
            System.out.println("str.length == 0");
        }
    }

    public static void main(String[] args) {
        isNullorEmpty("");
        isNullorEmpty();

    }

}
