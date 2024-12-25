char * mergeAlternately(char * word1, char * word2){
    int len1 = strlen(word1);
    int len2 = strlen(word2);
    char * result = (char*)malloc((len1 + len2 + 1) * sizeof(char));
    int index = 0;
    for(int i = 0; i < len1 || i < len2; i++){
        if (i < len1) {
            result[index++] = word1[i];
        }
        if (i < len2) {
            result[index++] = word2[i];
        }
    }
    
    result[index] = '\0';
    
    return result;
}
