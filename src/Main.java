import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Interval[]sortedLeftA = new Interval[n];
        Interval[]sortedRightA = new Interval[n];
        for (int i = 0; i < n; i++){
            int left = scanner.nextInt();
            int right = scanner.nextInt();

            Interval interval = new Interval(left, right);
            Interval interval1 = new Interval(left, right);
            sortedLeftA[i] = interval;
            sortedRightA[i] = interval1;
        }

        QuickSort(sortedLeftA, 0, n - 1);

        Interval.setSortByLeft(false);
        QuickSort(sortedRightA, 0, n - 1);
        //System.out.println();

        for (int i = 0; i < m; i++){
            int dot = scanner.nextInt();

            Interval.setSortByLeft(true);

            int rightSearch = bisect_right(sortedLeftA, dot);

            Interval.setSortByLeft(false);
            int leftSearch = bisect_left(sortedRightA, dot);

            System.out.print(rightSearch - leftSearch + " ");
        }
    }

    public static int bisect_right(Interval[] A, int x) {
        return bisect_right(A, x, 0, A.length);
    }

    public static int bisect_right(Interval[] A, int x, int lo, int hi) {
        int N = A.length;
        if (N == 0) {
            return 0;
        }
        if (x < A[lo].getCoordinate()) {
            return lo;
        }
        if (x > A[hi - 1].getCoordinate()) {
            return hi;
        }
        for (;;) {
            if (lo + 1 == hi) {
                return lo + 1;
            }
            int mi = (hi + lo) / 2;
            if (x < A[mi].getCoordinate()) {
                hi = mi;
            } else {
                lo = mi;
            }
        }
    }

    public static int bisect_left(Interval[] A, int x) {
        return bisect_left(A, x, 0, A.length);
    }

    public static int bisect_left(Interval[] A, int x, int lo, int hi) {
        int N = A.length;
        if (N == 0) {
            return 0;
        }
        if (x < A[lo].getCoordinate()) {
            return lo;
        }
        if (x > A[hi - 1].getCoordinate()) {
            return hi;
        }
        for (;;) {
            if (lo + 1 == hi) {
                return x == A[lo].getCoordinate() ? lo : (lo + 1);
            }
            int mi = (hi + lo) / 2;
            if (x <= A[mi].getCoordinate()) {
                hi = mi;
            } else {
                lo = mi;
            }
        }
    }

    public static void QuickSort (Interval[] arr, int b, int e)
    {
        int l = b, r = e;
        int randomNum = ThreadLocalRandom.current().nextInt(l, r + 1);
        int piv = arr[randomNum].getCoordinate();
        while (l <= r)
        {
            while (arr[l].getCoordinate() < piv)
                l++;
            while (arr[r].getCoordinate() > piv)
                r--;
            if (l <= r)
                arr[l++].swap(arr[r--]);
        }
        if (b < r)
            QuickSort(arr, b, r);
        if (e > l)
            QuickSort(arr, l, e);
    }
}
