#include "array.h"
#include<stdlib.h>
#include<stddef.h>
#include<errno.h>
#include<stdio.h>

int createArr(amorphArray* inputArr, short dim){
    inputArr -> size = dim;
    inputArr -> abase = (int*) malloc(sizeof(int)*dim);
    if(inputArr -> abase == NULL){
        errno = EADDRNOTAVAIL;
        return errno;
    }    
    errno = 0;
    return errno;
}

int storeArr(amorphArray* inputArr, int value, short position){
    int* startPoint = inputArr -> abase;
    if(position < inputArr -> size && position >= 0){
        *(startPoint + position) = value;
        if(*(startPoint + position) == value){
            errno = 0;
            return errno;
        }
        errno = EADDRNOTAVAIL;
        return errno;
    }
    errno = EINVAL;
    return errno;
}

//Update sys variable that updates itself when error occurs.
int readArr(amorphArray* inputArr, short position){
    if(position < inputArr -> size && position >= 0)
    {
        errno = 0;
        return *(inputArr -> abase + position);   
    }
    errno = EINVAL;
    return errno;
}

int checkError()
{
    switch (errno)
    {
    case 0:
        return 1;
    case EADDRNOTAVAIL:
        perror("Invalid size");
        break;
    case EINVAL:
        perror("Array Index out of bounds");
        break;
    default:
        perror("Error Creating Array");
    }
    return 0;
}
