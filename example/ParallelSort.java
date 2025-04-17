public class ParallelSort {
    public static void bubbleSort(String[] makes, int[] vins) {
        boolean sorted = false;
        for (int hi = makes.length - 1; hi > 0 && !sorted; hi--) {
            for (int i = 0; i < hi; i++) {
                sorted = true;

                if (makes[i].compareTo(makes[i + 1]) > 0) {
                    String foo = makes[i];
                    makes[i] = makes[i + 1];
                    makes[i + 1] = foo;

                    int bar = vins[i];
                    vins[i] = vins[i + 1];
                    vins[i + 1] = bar;

                    sorted = false;
                } else if (makes[i].equals(makes[i + 1]) && vins[i] > vins[i + 1]) {
                    int bar = vins[i];
                    vins[i] = vins[i + 1];
                    vins[i + 1] = bar;

                    sorted = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] makes = {
                "Ford",
                "Toyota",
                "Lexus",
                "Lexus",
                "Toyota",
                "Toyota",
                "Honda",
                "Ford",
                "Toyota",
                "Toyota"
        };

        int[] vins = {
                10,
                9,
                8,
                7,
                6,
                5,
                4,
                3,
                2,
                1
        };

        bubbleSort(makes, vins);

        for (int i = 0; i < makes.length; i++) {
            System.out.println(makes[i] + ": " + vins[i]);
        }
    }
}
