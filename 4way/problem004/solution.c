/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
bool contains(int* arr, int size, int val) {
    for (int i = 0; i < size; i++) {
        if (arr[i] == val) return true;
    }
    return false;
}

int** findDifference(int* nums1, int nums1Size, int* nums2, int nums2Size, int* returnSize, int** returnColumnSizes) {
    int** result = (int**)malloc(2 * sizeof(int*));
    result[0] = (int*)malloc(nums1Size * sizeof(int));
    result[1] = (int*)malloc(nums2Size * sizeof(int));
    
    *returnColumnSizes = (int*)malloc(2 * sizeof(int));
    (*returnColumnSizes)[0] = 0;
    (*returnColumnSizes)[1] = 0;

    for (int i = 0; i < nums1Size; i++) {
        if (!contains(nums2, nums2Size, nums1[i]) && !contains(result[0], (*returnColumnSizes)[0], nums1[i])) {
            result[0][(*returnColumnSizes)[0]++] = nums1[i];
        }
    }
    
    for (int i = 0; i < nums2Size; i++) {
        if (!contains(nums1, nums1Size, nums2[i]) && !contains(result[1], (*returnColumnSizes)[1], nums2[i])) {
            result[1][(*returnColumnSizes)[1]++] = nums2[i];
        }
    }

    *returnSize = 2;
    return result;
}
