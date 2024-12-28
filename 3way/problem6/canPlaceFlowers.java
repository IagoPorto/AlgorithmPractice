class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 1;

        for(var i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 0){
                count++;
                if(count == 3){
                    n--;
                    count = 1;
                }
            }else{
                count = 0;
            }
        }

        if(count == 2){
            n--;
        }

        return n <= 0;
    }
}
