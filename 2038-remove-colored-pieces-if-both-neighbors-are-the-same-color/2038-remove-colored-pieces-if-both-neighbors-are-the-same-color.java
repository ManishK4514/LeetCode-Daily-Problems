class Solution {
    public boolean winnerOfGame(String colors) {
        int alice = 0, bob = 0, n = colors.length();

        int consAlice = (colors.charAt(0) == 'A') ? 1 : 0;
        int consBob = (colors.charAt(0) == 'B') ? 1 : 0;
        

        for(int i = 1; i < colors.length(); i++) {
            if(colors.charAt(i) == colors.charAt(i - 1)) {
                if(colors.charAt(i) == 'A') consAlice++;
                else consBob++;
            }
            else {
                if(colors.charAt(i) == 'A') {
                    consAlice = 1;
                    if(consBob > 2) {
                        bob += consBob - 2;
                    }
                    consBob = 0;
                }                
                else {
                    consBob = 1;
                    if(consAlice > 2) {
                        alice += consAlice - 2;
                    }
                    consAlice = 0;
                }
            }
        }
        
        if(consAlice > 2) alice += consAlice - 2;
        if(consBob > 2) bob += consBob - 2;

        return alice - bob >= 1;
    }
}