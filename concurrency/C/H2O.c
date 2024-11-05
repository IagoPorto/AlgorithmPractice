/**Intuition

There are two kinds of threads: oxygen and hydrogen. Your goal is to group these threads to form water molecules.

There is a barrier where each thread has to wait until a complete molecule can be formed. Hydrogen and oxygen threads will be given releaseHydrogen and releaseOxygen methods respectively, which will allow them to pass the barrier. These threads should pass the barrier in groups of three, and they must immediately bond with each other to form a water molecule. You must guarantee that all the threads from one molecule bond before any other threads from the next molecule do.

In other words:

    If an oxygen thread arrives at the barrier when no hydrogen threads are present, it must wait for two hydrogen threads.
    If a hydrogen thread arrives at the barrier when no other threads are present, it must wait for an oxygen thread and another hydrogen thread.

We do not have to worry about matching the threads up explicitly; the threads do not necessarily know which other threads they are paired up with. The key is that threads pass the barriers in complete sets; thus, if we examine the sequence of threads that bind and divide them into groups of three, each group should contain one oxygen and two hydrogen threads.

Write synchronization code for oxygen and hydrogen molecules that enforces these constraints.

 

Example 1:

Input: water = "HOH"
Output: "HHO"
Explanation: "HOH" and "OHH" are also valid answers.

Example 2:

Input: water = "OOHHHH"
Output: "HHOHHO"
Explanation: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH" and "OHHOHH" are also valid answers.

 

Constraints:

    3 * n == water.length
    1 <= n <= 20
    water[i] is either 'H' or 'O'.
    There will be exactly 2 * n 'H' in water.
    There will be exactly n 'O' in water.



To form a water molecule, we need exactly two hydrogen and one oxygen atom. This suggests a need for synchronization to ensure the correct ratio is maintained and each molecule is formed before any additional atoms are released.
Approach

We use two semaphores to control the entry of hydrogen and oxygen threads. The hydrogenSemaphore allows only two hydrogen threads to proceed at a time, while the oxygenSemaphore allows one oxygen thread to proceed only when two hydrogens are ready. A mutex lock and a hydrogenCount variable are used to track and reset the hydrogen count after each molecule formation.
Complexity

    Time complexity: O(1)

    Space complexity: O(1)

Code
**/
#include <stdio.h>
#include <stdlib.h>
#include <semaphore.h>
#include <pthread.h>

typedef struct {
    sem_t hydrogenSemaphore;
    sem_t oxygenSemaphore;
    pthread_mutex_t lock;
    int hydrogenCount;
} H2O;

H2O* h2oCreate() {
    H2O* obj = (H2O*) malloc(sizeof(H2O));
    sem_init(&obj->hydrogenSemaphore, 0, 2);
    sem_init(&obj->oxygenSemaphore, 0, 0);
    pthread_mutex_init(&obj->lock, NULL);
    obj->hydrogenCount = 0;
    return obj;
}

void hydrogen(H2O* obj) {
    sem_wait(&obj->hydrogenSemaphore);

    pthread_mutex_lock(&obj->lock);
    obj->hydrogenCount++;
    if (obj->hydrogenCount == 2) {
        sem_post(&obj->oxygenSemaphore);
        obj->hydrogenCount = 0;
    }
    pthread_mutex_unlock(&obj->lock);

    releaseHydrogen();
}

void oxygen(H2O* obj) {
    sem_wait(&obj->oxygenSemaphore);

    releaseOxygen();
    
    sem_post(&obj->hydrogenSemaphore);
    sem_post(&obj->hydrogenSemaphore);
}

void h2oFree(H2O* obj) {
    sem_destroy(&obj->hydrogenSemaphore);
    sem_destroy(&obj->oxygenSemaphore);
    pthread_mutex_destroy(&obj->lock);
    free(obj);
}
