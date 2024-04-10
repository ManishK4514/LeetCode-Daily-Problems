class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> dq = new LinkedList<>();
        int n = deck.length;
        dq.addLast(deck[n - 1]);
        for(int i = n - 2; i >= 0; i--) {
            dq.addFirst(dq.removeLast());
            dq.addFirst(deck[i]);
        }
        
        for(int i = 0; i < n; i++) deck[i] = dq.removeFirst();
        return deck;
    }
}