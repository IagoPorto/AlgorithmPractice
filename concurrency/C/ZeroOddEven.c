/**
You have a function printNumber that can be called with an integer parameter and prints it to the console.

    For example, calling printNumber(7) prints 7 to the console.

You are given an instance of the class ZeroEvenOdd that has three functions: zero, even, and odd. The same instance of ZeroEvenOdd will be passed to three different threads:

    Thread A: calls zero() that should only output 0's.
    Thread B: calls even() that should only output even numbers.
    Thread C: calls odd() that should only output odd numbers.

Modify the given class to output the series "010203040506..." where the length of the series must be 2n.

Implement the ZeroEvenOdd class:

    ZeroEvenOdd(int n) Initializes the object with the number n that represents the numbers that should be printed.
    void zero(printNumber) Calls printNumber to output one zero.
    void even(printNumber) Calls printNumber to output one even number.
    void odd(printNumber) Calls printNumber to output one odd number.

 

Example 1:

Input: n = 2
Output: "0102"
Explanation: There are three threads being fired asynchronously.
One of them calls zero(), the other calls even(), and the last one calls odd().
"0102" is the correct output.

Example 2:

Input: n = 5
Output: "0102030405"

 

Constraints:

    1 <= n <= 1000


**/

#include <stdio.h>
#include <stdlib.h>
#include <semaphore.h>

typedef struct {
    int n;
    int j;
    sem_t zero;
    sem_t even;
    sem_t odd;
} ZeroEvenOdd;

ZeroEvenOdd* zeroEvenOddCreate(int n) {
    ZeroEvenOdd* obj = (ZeroEvenOdd*) malloc(sizeof(ZeroEvenOdd));
    obj->n = n;
    obj->j = 1;
    sem_init(&obj->zero, 0, 1);
    sem_init(&obj->even, 0, 0);
    sem_init(&obj->odd, 0, 0);
    return obj;
}

void zero(ZeroEvenOdd* obj) {
    for (int i = 0; i < obj->n; i++) {
        sem_wait(&obj->zero);
        printNumber(0);
        if (obj->j % 2 == 0) {
            sem_post(&obj->even);
        } else {
            sem_post(&obj->odd);
        }
    }
}

void even(ZeroEvenOdd* obj) {
    for (int i = 2; i <= obj->n; i += 2) {
        sem_wait(&obj->even);
        printNumber( i);
        sem_post(&obj->zero);
        obj->j++;
    }
}

void odd(ZeroEvenOdd* obj) {
    for (int i = 1; i <= obj->n; i += 2) {
        sem_wait(&obj->odd);
        printNumber(i);
        sem_post(&obj->zero);
        obj->j++;
    }
}

void zeroEvenOddFree(ZeroEvenOdd* obj) {
    sem_destroy(&obj->zero);
    sem_destroy(&obj->even);
    sem_destroy(&obj->odd);
    free(obj);
}
