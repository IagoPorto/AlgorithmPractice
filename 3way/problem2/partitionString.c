int partitionString(char* s) {
    bool seen[26] = {false};
    int result = 1;

    for(int i = 0; s[i] != '\0'; i++){
        int index = s[i] - 'a';
        if(seen[index]){
            result++;
            memset(seen, 0, sizeof(seen));
        }
        seen[index] = true;
    }

    return result;
    
}
