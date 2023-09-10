class Solution {
    public long power(long x, long y, long mod) {
        long res = 1;
        x = x % mod;

        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % mod;

            y = y >> 1; 
            x = (x * x) % mod;
        }

        return res % mod;
    }
    public long factorialMod(int n, long mod) {
        long[] factorial = new long[n + 1];
        factorial[0] = 1;

        for (int i = 1; i <= n; i++) {
            factorial[i] = (factorial[i - 1] * i) % mod;
        }

        return factorial[n] % mod;
    }
    public long func(long a, long b) {
        long MOD = (long) 1e9 + 7;
        return (((long) a % MOD) * (power(b, MOD - 2, MOD)) % MOD) % MOD;
    }
    public int countOrders(int n) {
        long base = (int) power(2, n, (long)1e9 + 7);
        n = 2 * n;
        long mod = (long)(1e9 + 7);
        long fact = (int) factorialMod(n, (long)1e9 + 7);
        return (int) (func(fact, base) % mod);
    }
}