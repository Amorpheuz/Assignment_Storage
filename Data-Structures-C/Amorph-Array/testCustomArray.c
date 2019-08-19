#include "array.h"
#include<stdio.h>


int main(int argc, char const *argv[])
{
    amorphArray arr;
    short size = -1;
    printf("Enter size of array to create: ");
    scanf("%d", &size);
    if (size >= 0)
    {
        int op = createArr(&arr,size);
        if(op){
            printf("Array created\n");
        }
        else{
            printf("Error Creating Array\n");
        }
        printf("Please enter values for the array.\n");
        op = 0;
        for (int iterator = 0; iterator < arr.size; iterator++)
        {
            int tempVal;
            printf("Enter value %d: ",iterator);
            scanf("%d",&tempVal);
            op += storeArr(&arr,tempVal,iterator);
        }
        
        if(op == arr.size){
            printf("\n\nPrinting Array: \n");
            for (int iterator = 0; iterator < arr.size; iterator++)
            {
                printf("Value Stored at %d: %d\n",iterator,readArr(&arr,iterator));
            }
        }
    }
    else {
        printf("Invalid size.");
    }
    
    return 0;
}
