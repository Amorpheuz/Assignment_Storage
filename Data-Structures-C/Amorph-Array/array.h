typedef struct
{
    int* abase;
    short size;
}amorphArray;

int createArr(amorphArray* inputArr, short size);
int storeArr(amorphArray* inputArr, int value, short position);
int readArr(amorphArray* inputArr, short position);
int checkError();
int freeArr(amorphArray *inputArr);