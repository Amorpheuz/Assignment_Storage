#include "array.h"
#include<stdio.h>

int main(int argc, char const *argv[])
{
    amorphArray arr;
    short size = -1;
    int flag = 1, option = 0;
    int tempVal, tempPos;
    printf("Enter size of array to create: ");
    scanf("%hd", &size);
    createArr(&arr,size);
    if (checkError())
    {
        printf("Array Created.\n");
        while (flag)
        {
            printf("Select option to perform action:\n\t1. Store Value\n\t2. Read position\n\t3. Exit\nInput: ");
            scanf("%d",&option);
            printf("--------------------------------\n");
            switch (option)
            {
                case 1:
                    printf("Enter value: ");
                    if(!scanf("%d", &tempVal)){
                        flag = 0;
                        printf("Invalid input\n");
                        continue;
                    }
                    printf("Enter position: ");
                    if (!scanf("%d", &tempPos))
                    {
                        flag = 0;
                        printf("Invalid input\n");
                        continue;
                    }
                    storeArr(&arr, tempVal, tempPos);
                    if (checkError())
                    {
                        printf("Value Stored.\n");
                    }                    
                    break;
                case 2:
                    printf("Enter position: ");
                    if (!scanf("%d", &tempPos))
                    {
                        flag = 0;
                        printf("Invalid input\n");
                        continue;
                    }
                    int temp = readArr(&arr, tempPos);
                    if (checkError())
                    {
                        printf("Value Stored at %d: %d\n", tempPos, temp);
                    }
                    break;
                case 3:
                    flag = 0;
                    continue;
                    break;
                default:
                    printf("Invalid Selection.\n");
                    break;
            }
            printf("--------------------------------\n");
        }
    }
    return 0;
}
