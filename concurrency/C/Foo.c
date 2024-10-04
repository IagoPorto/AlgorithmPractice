/**
Suppose we have a class:

public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}

The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().

Note:

We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seem to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.

 

Example 1:

Input: nums = [1,2,3]
Output: "firstsecondthird"
Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.

Example 2:

Input: nums = [1,3,2]
Output: "firstsecondthird"
Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the correct output.

 

Constraints:

    nums is a permutation of [1, 2, 3].


**/

#include <stdio.h>
#include <stdlib.h>
#include <semaphore.h>
#include <pthread.h>

typedef struct {
    sem_t first_done;
    sem_t second_done;
} Foo;

Foo* fooCreate() {
    Foo* obj = (Foo*) malloc(sizeof(Foo));
    
    sem_init(&obj->first_done, 0, 0);  
    sem_init(&obj->second_done, 0, 0);  

    return obj;
}

void first(Foo* obj) {
    printFirst();
    sem_post(&obj->first_done);  
}

void second(Foo* obj) {
    sem_wait(&obj->first_done);  
    printSecond();
    sem_post(&obj->second_done);  
}

void third(Foo* obj) {
    sem_wait(&obj->second_done);  
    printThird();
}

void fooFree(Foo* obj) {
    sem_destroy(&obj->first_done);
    sem_destroy(&obj->second_done);
    free(obj);
}
