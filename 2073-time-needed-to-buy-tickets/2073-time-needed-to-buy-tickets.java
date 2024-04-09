class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0, n = tickets.length, kthTicket = tickets[k];
        for(int i = 0; i < n; i++) {
            int currRequired = tickets[i];
            if(currRequired >= kthTicket) {
                if(i <= k) time += kthTicket;
                else time += kthTicket - 1; 
            }
            else time += currRequired;
        }
        return time;
    }
}