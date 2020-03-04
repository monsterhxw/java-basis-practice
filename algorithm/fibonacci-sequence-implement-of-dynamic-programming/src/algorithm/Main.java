package algorithm;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    int n = 40;
    System.out.println(
        "using dynamic programming : n is " + n + ", result is " + (new Main()).fibonacci(n));
  }

  public int fibonacci(int n) {
    if (n == 0) {
      return 0;
    }

    int[] memoization = new int[n + 1];
    memoization[0] = 0;
    memoization[1] = 1;

    for (int i = 2; i <= n; ++i) {
      memoization[i] = memoization[i - 1] + memoization[i - 2];
    }

    return memoization[n];
  }
}
