bool isSubsequence(char* s, char* t) {
    int sIndex = 0;
    int tIndex = 0;
    int sLen = strlen(s);
    int tLen = strlen(t);
    while(sIndex < sLen && tIndex < tLen){
        if(s[sIndex] == t[tIndex]){
            sIndex++;
        }
        tIndex++;
    }
    return sIndex == sLen;
}
