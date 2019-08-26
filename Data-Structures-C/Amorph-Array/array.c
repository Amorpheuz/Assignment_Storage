#include "array.h"
#include<stdlib.h>
#include<stddef.h>
#include<errno.h>
#include<stdio.h>

int createArr(amorphArray* inputArr, short dim){
    inputArr -> size = dim;
    inputArr -> abase = (int*) malloc(sizeof(int)*dim);
    if(inputArr -> abase == NULL){
        errno = EINVAL;
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
        errno = EINVAL;
        return errno;
    }
    errno = EINVAL;
    return errno;
}

int readArr(amorphArray* inputArr, short position){
    if(position < inputArr -> size && position >= 0)
    {
        errno = 0;
        return *(inputArr -> abase + position);   
    }
    errno = EINVAL;
    return errno;
}

int freeArr(amorphArray *inputArr)
{
    free(inputArr->abase);
    inputArr->abase = NULL;
    if (inputArr->abase == NULL)
    {
        errno = 0;
        return 1;
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
        case EINVAL:
            perror("Error");
            errno = 0;
            break;
        default:
            perror("Error");
            errno = 0;
    }
    return 0;
}
