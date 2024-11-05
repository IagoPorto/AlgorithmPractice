/**
You have the four functions:

    printFizz that prints the word "fizz" to the console,
    printBuzz that prints the word "buzz" to the console,
    printFizzBuzz that prints the word "fizzbuzz" to the console, and
    printNumber that prints a given integer to the console.

You are given an instance of the class FizzBuzz that has four functions: fizz, buzz, fizzbuzz and number. The same instance of FizzBuzz will be passed to four different threads:

    Thread A: calls fizz() that should output the word "fizz".
    Thread B: calls buzz() that should output the word "buzz".
    Thread C: calls fizzbuzz() that should output the word "fizzbuzz".
    Thread D: calls number() that should only output the integers.

Modify the given class to output the series [1, 2, "fizz", 4, "buzz", ...] where the ith token (1-indexed) of the series is:

    "fizzbuzz" if i is divisible by 3 and 5,
    "fizz" if i is divisible by 3 and not 5,
    "buzz" if i is divisible by 5 and not 3, or
    i if i is not divisible by 3 or 5.

Implement the FizzBuzz class:

    FizzBuzz(int n) Initializes the object with the number n that represents the length of the sequence that should be printed.
    void fizz(printFizz) Calls printFizz to output "fizz".
    void buzz(printBuzz) Calls printBuzz to output "buzz".
    void fizzbuzz(printFizzBuzz) Calls printFizzBuzz to output "fizzbuzz".
    void number(printNumber) Calls printnumber to output the numbers.

 

Example 1:

Input: n = 15
Output: [1,2,"fizz",4,"buzz","fizz",7,8,"fizz","buzz",11,"fizz",13,14,"fizzbuzz"]

Example 2:

Input: n = 5
Output: [1,2,"fizz",4,"buzz"]

 

Constraints:

    1 <= n <= 50




Intuition

To generate the FizzBuzz sequence, we need to coordinate multiple threads so that they print the correct values based on divisibility by 3 and 5. Each thread should wait for its turn to output its respective value.
Approach

We use semaphores to manage the synchronization between four threads: one for printing "fizz", one for "buzz", one for "fizzbuzz", and one for printing numbers. Each method waits for its corresponding semaphore, and after printing, it calls releaseNext to determine which thread should proceed next based on the current number.
Complexity

    Time complexity: O(n)

    Space complexity: O(1)

Code
**/

typedef struct {
    int n;
    sem_t fizz;
    sem_t buzz;
    sem_t fizzbuzz;
    sem_t number;
    int current;
} FizzBuzz;

void releaseNext();
void printBuzz();
void printFizz();
void printFizzBuzz();
void printNumber(int x);

FizzBuzz* fizzBuzzCreate(int n) {
    FizzBuzz* obj = (FizzBuzz*) malloc(sizeof(FizzBuzz));
    obj->n = n;
    sem_init(&obj->fizz, 0, 0);
    sem_init(&obj->buzz, 0, 0);
    sem_init(&obj->fizzbuzz, 0, 0);
    sem_init(&obj->number, 0, 1);
    obj->current = 1;
    return obj;
}

// printFizz() outputs "fizz".
void fizz(FizzBuzz* obj) {
    while(true){
        sem_wait(&obj->fizz);
        if(obj->current > obj->n){
            return;
        }
        printFizz();
        releaseNext(obj);
    }
    
}

// printBuzz() outputs "buzz".
void buzz(FizzBuzz* obj) {
    while(true){
        sem_wait(&obj->buzz);
        if(obj->current > obj->n){
            return;
        }
        printBuzz();
        releaseNext(obj);
    }
}

// printFizzBuzz() outputs "fizzbuzz".
void fizzbuzz(FizzBuzz* obj) {
    while(true){
        sem_wait(&obj->fizzbuzz);
        if(obj->current > obj->n){
            return;
        }
        printFizzBuzz();
        releaseNext(obj);
    }
}

// You may call global function `void printNumber(int x)`
// to output "x", where x is an integer.
void number(FizzBuzz* obj) {
    while(true){
        sem_wait(&obj->number);
        if(obj->current > obj->n){
            return;
        }
        printNumber(obj->current);
        releaseNext(obj);
    }
}

void releaseNext(FizzBuzz* obj){
    obj->current++;
    if (obj->current > obj->n) {
        sem_post(&obj->fizz);
        sem_post(&obj->buzz);
        sem_post(&obj->fizzbuzz);
        sem_post(&obj->number);
    } else if (obj->current % 3 == 0 && obj->current % 5 == 0) {
        sem_post(&obj->fizzbuzz);
    } else if (obj->current % 3 == 0) {
        sem_post(&obj->fizz);
    } else if (obj->current % 5 == 0) {
        sem_post(&obj->buzz);
    } else {
        sem_post(&obj->number);
    }
}

void fizzBuzzFree(FizzBuzz* obj) {
    sem_destroy(&obj->fizz);
    sem_destroy(&obj->buzz);
    sem_destroy(&obj->fizzbuzz);
    sem_destroy(&obj->number);
    free(obj);
}
