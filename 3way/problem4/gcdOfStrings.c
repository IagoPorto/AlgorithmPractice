int mcd(int a, int b);

char* gcdOfStrings(char* str1, char* str2) {
    int len1 = strlen(str1);
    int len2 = strlen(str2);
    char first[len1 + len2 + 1];
    char second[len2 + len1 + 1];
    for(int i = 0; i < len1; i++){
        first[i] = str1[i];
        second[len2 + i] = str1[i];
    }
    for(int i = 0; i < len2; i++){
        first[len1 + i] = str2[i];
        second[i] = str2[i];
    }
    first[len1 + len2] = '\0';
    second[len1 + len2] = '\0';
    for(int i = 0; i < len2 + len1; i++){
        if(!(first[i] == second[i])){
            return "";
        }
    }

    int gcd = mcd(len1,len2);

    char* result = (char*)malloc(gcd + 1) ;
    strncpy(result, first, gcd);
    result[gcd] = '\0';

    return result;

}

int mcd(int a, int b){

    return b == 0 ? a : mcd(b, a % b);

}
