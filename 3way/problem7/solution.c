char* reverseVowels(char* s) {
    char isVowel[128];
    char vowels[] = {'a','A','e','E','u','U','i','I','o','O'};
    int start = 0;
    int end = strlen(s) - 1;

    for(int i = 0; i < 10; i++){
        isVowel[vowels[i]] = true;
    }

    while(start < end){
        if(isVowel[s[start]]){
            while(true){
                if(isVowel[s[end]]){
                    char c = s[start];
                    s[start] = s[end];
                    s[end] = c;
                    end--;
                    break;
                }
                end--;
            }
        }
        start++;
    }

    return s;

}
