public class TernarySearch {
    public static int ternarySearch(int[] arr, int target) {
        int hi = arr.length - 1;
        int lo = 0;
        int idx = -1;

        while (lo <= hi && idx == -1) {
            int mid1 = lo + (hi - lo) / 3;
            int mid2 = lo + 2 * (hi - lo) / 3;

            if (arr[mid1] == target) {
                idx = mid1;
            } else if (arr[mid2] == target) {
                idx = mid2;
            } else if (arr[mid1] > target) {
                hi = mid1 - 1;
            } else if (arr[mid1] < target && target < arr[mid2]) {
                lo = mid1 + 1;
                hi = mid2 - 1;
            } else {
                lo = mid2 + 1;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        int[] arr = {
                1,
                3,
                4,
                5,
                7,
                11,
                12,
                13,
                115,
                200
        };

        System.out.println(ternarySearch(arr, 0));
        System.out.println(ternarySearch(arr, 1));
        System.out.println(ternarySearch(arr, 4));
        System.out.println(ternarySearch(arr, 11));
        System.out.println(ternarySearch(arr, 115));
        System.out.println(ternarySearch(arr, 200));
        System.out.println(ternarySearch(arr, 500));
    }
}
