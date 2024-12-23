int kthFactor(int n, int k) {
    int i = 1;
    for(i; i <= n; i++){
        if(n % i == 0){
            k--;
        }
        if(k == 0){
            return i;
        }
    }
    return -1;
}
