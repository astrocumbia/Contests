#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

#define MAX 15
int pow2[MAX];

void init() {
    pow2[0] = 1;
    for(int i = 1; i < MAX; i++) {
        pow2[i] = pow2[i-1] * 2;
    }
}

long solve(long n) {
    long flag = 0;
    long ans = 0;
    for(int i = MAX; i >= 0; i--) {
        if ((n>>i)&1 == 1) {
            if( flag == 0 ){
                ans = pow2[i];
                flag = 1;
            }
            else
                ans = ans - pow2[i];
        }
    }
    return ans - 1;
}

int main(){
    
    int q; 
    init();

    scanf("%d",&q);
    for(int a0 = 0; a0 < q; a0++){
        long x; 
        scanf("%ld",&x);
        printf("%ld\n", solve(x));
        // your code goes here
    }
    /*
    init();
    for(int i=0; i<MAX; i++)
        printf("%d ", pow2[i]);
    printf("\n");
    */
    return 0;
}
