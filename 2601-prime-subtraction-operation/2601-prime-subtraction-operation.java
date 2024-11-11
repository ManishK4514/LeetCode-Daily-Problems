class Solution {
    public static boolean[] sieve(int n) {
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);

        for (int p = 2; p*p <= n; p++) {
            if (primes[p]) {
                for (int i = p*p; i <= n; i += p) {
                    primes[i] = false;
                }
            }
        }

        primes[0] = false;
        primes[1] = false;
        return primes;
    }
    public int helper(int curr, ArrayList<Integer> primes, int prev){
        for(int i = primes.size() - 1; i >= 0; i--) {
            if(curr - primes.get(i) > prev) return curr - primes.get(i);
        }

        return curr;
    }
    public boolean primeSubOperation(int[] nums) {
        boolean[] prime = sieve(1000);
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = 1; i <= 1000; i++){
            if(prime[i]) primes.add(i);
        }
        
        int prev = 0, n = nums.length;

        for(int i = 0; i < n; i++) {
            int curr = helper(nums[i], primes, prev);
            if(prev >= curr) return false;
            prev = curr;
        }

        return true;           
    }
}