int compress(char* chars, int charsSize) {
    int count = 1;
    int index = 0;
    for(int i = 1; i <= charsSize; i++){
        if(i == charsSize || chars[i] != chars[i - 1]){
            chars[index++] = chars[i - 1];
            if(count > 1){
                char countStr[12];
                sprintf(countStr, "%d", count);
                for (int j = 0; countStr[j] != '\0'; j++) {
                    chars[index++] = countStr[j];
                }
                count = 1;
            }
        }else{
            count++;
        }
    }
    return index;
}
