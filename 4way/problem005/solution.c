#define MAX 2001

bool uniqueOccurrences(int* arr, int arrSize) {
    int occurrences[MAX] = {0};
    int freq[MAX] = {0};

    for (int i = 0; i < arrSize; i++) {
        occurrences[arr[i] + 1000]++;
    }

    for (int i = 0; i < MAX; i++) {
        if (occurrences[i] > 0) {
            int count = occurrences[i];
            if (freq[count] > 0) {
                return false;
            }
            freq[count] = 1;
        }
    }

    return true;
}
