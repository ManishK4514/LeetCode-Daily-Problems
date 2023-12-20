class Solution {
    public int buyChoco(int[] prices, int money) {
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for(int it : prices) {
            if(it < firstMin) {
                secondMin = firstMin;
                firstMin = it;
            }
            else if(it < secondMin) secondMin = it;
        }

        return firstMin + secondMin <= money ? money - (firstMin + secondMin) : money;
    }
}