bool isVowel(char c);
int max(int a, int b);

int maxVowels(char* s, int k) {
    int length = strlen(s);
    bool list[length];
    int count = 0;
    int max_val;
    for(int i = 0; i < length; i++){
        list[i] = isVowel(s[i]);
    } 
    for(int i = 0; i < k; i++){
        if(list[i]){
            count++;
        }
    }

    max_val = count;

    for(int i = k; i < length; i++){
        if(list[i]){
            count++;
        }
        if(list[i - k]){
            count--;
        }
        max_val = max(max_val, count);
    }
    return max_val;
}

bool isVowel(char c){
    return c == 'a' || c == 'e' || c == 'o' || c == 'i' || c == 'u';
}

int max(int a, int b){
    return (a > b) ? a : b;
}
