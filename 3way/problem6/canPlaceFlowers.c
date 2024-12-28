bool canPlaceFlowers(int* flowerbed, int flowerbedSize, int n) {
    int count = 1;

    for(int i = 0; i < flowerbedSize; i++){
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
