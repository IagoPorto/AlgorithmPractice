int largestAltitude(int* gain, int gainSize) {
    int max = 0;
    int prev = 0;
    for(int i = 0; i < gainSize; i++){
        prev += gain[i];
        max = max > prev ? max : prev;
    }

    return max;
}
