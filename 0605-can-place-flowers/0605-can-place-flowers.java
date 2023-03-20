class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {       
        int m = flowerbed.length; 
        if(n == 0) return true;
        if(m == 1 && flowerbed[0] == 0 && n == 1) return true; 
        for(int i = 0; i < flowerbed.length; i++){
            if(i == 0 && i < m - 1 && flowerbed[i] == 0 && flowerbed[i + 1] == 0){
                flowerbed[i] = 1; n--;               
            } 
            else if(i == m - 1 && i > 0 && flowerbed[i - 1] == 0 && flowerbed[i] == 0){
                flowerbed[i] = 1; n--;
            }
            else if(i > 0 && i < m - 1 &&flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] == 0){
                flowerbed[i] = 1; n--; 
            }
            if(n == 0) return true;
        }
        return n == 0;
    }
}