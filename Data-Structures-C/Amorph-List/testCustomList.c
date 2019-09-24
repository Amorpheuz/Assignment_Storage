/*
 * testCustomList.c - File for testing custom List 
 * author -  @Dhanoz (GitHub)
 * version - 1.0, September 4, 2019
 */
#include"si_list.h"
#include <stdio.h>
#include <stdlib.h>
#include<errno.h>
struct slnode* head=NULL;
void main()
{
    int choice,data,pos;
    struct slnode* temp_address;
    while (1)
    {
        printf("\n 1.Create \n 2.Add node \n 3.Insert node \n 4.Delete \n 5.Length of the list \n 6.Dispplay List \n 7.Exit\n");
        printf("Enter option :");
        scanf("%d",&choice);
        switch (choice)
        {
            case 1: printf("\n Enter the data want to add into link list :");
                    scanf("%d",&data);
                    head=sin_create(data);
                    if (head!=0)
                    {
                        printf("\n Node is allocated");
                    }
                    break;
            case 2: printf("\n Enter the data you want to add :");
                    scanf("%d",&data);
                    sin_add(&head,sin_create(data));
                    printf("Node Added\n");
                    break;
            case 3: printf("\n Enter the data you want to add and what posistion :");
                    scanf("%d %d",&data,&pos);
                    temp_address=sin_insert(&head,data,pos);
                    printf("The address of that node is : %p",temp_address);
                    temp_address = NULL;
                    break;
            case 4: printf("\nEnter the posistion node that you want to delete:");
                    scanf("%d",&pos);
                    data=sin_delete(&head,pos); 
                    printf("The delete element is : %d",data);
                    break;
            case 5: data=sin_length(head);
                    printf("The length of the list is : %d",data);
                    break;
            case 6: data=sin_print(head);
                    printf("The count is : %d",data);
                    break;
            case 7: temp_address = sin_midpoint(head);
                    printf("Midpoint node: %d, Address: %p",temp_address -> data, temp_address);
                    temp_address = NULL;
                    break;
            case 8: exit(0);       
            
            default:printf("Please choose the correct choice :");    
                break;
        }
    }
    
}