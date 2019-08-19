#include "array.h"
#include<stdlib.h>
#include<stddef.h>

int createArr(amorphArray* inputArr, short dim){
    inputArr -> size = dim;
    inputArr -> abase = (int*) malloc(sizeof(int)*dim);
    if(inputArr -> abase == NULL){
        return 0;
    }    
    return 1;
}

int storeArr(amorphArray* inputArr, int value, short position){
    int* startPoint = inputArr -> abase;
    if(position < inputArr -> size && position >= 0){
        *(startPoint + position) = value;
        if(*(startPoint + position) == value){
            return 1;
        }
        return 0;
    }
    return 0;
}

//Update sys variable that updates itself when error occurs.
int readArr(amorphArray* inputArr, short position){
    if(position < inputArr -> size && position >= 0)
    {
        return *(inputArr -> abase + position);   
    }
    return 0;
}
