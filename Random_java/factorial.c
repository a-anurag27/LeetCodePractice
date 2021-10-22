#include <stdio.h>

int Fact(int n){
    if(n == 1){
        return 1;
    }
    else {
        return n * Fact(n-1);
    }
}

int main(){
    int n;
    n = 5;
    printf("Factorial of %d is %d",n,Fact(n));
    return 0;
} 