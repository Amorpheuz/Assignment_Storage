#include "array.h"
#include<stdio.h>

int main(int argc, char const *argv[])
{
    amorphArray arr;
    short size = -1;
    printf("Enter size of array to create: ");
    scanf("%hd", &size);
    createArr(&arr,size);
    if (checkError())
    {
        printf("Array Created.\nPlease enter values for the array.\n");
        for (int iterator = 0; iterator < arr.size; iterator++)
        {
            int tempVal;
            printf("Enter value %d: ", iterator);
            scanf("%d", &tempVal);
            storeArr(&arr, tempVal, iterator);
            if (checkError())
            {
                continue;
            }
            break;
        }
        printf("\n\nPrinting Array: \n");
        for (int iterator = 0; iterator < arr.size; iterator++)
        {
            int temp = readArr(&arr, iterator);
            if (checkError())
            {
                printf("Value Stored at %d: %d\n", iterator, temp);
                continue;
            }
            break;
        }
    }
    return 0;
}
