/*
 * si_list.c - Ane api to provide basic functions to create, read, write and process a list of integers.
 * 
 * definition author - Harshad Gune, harshad.gune@gmail.com
 * implemented by - Yash Dave, mail2ypd@gmail.com
 * version - 1.0, August 31, 2019 
 */

# include <stdio.h>
# include <stdlib.h>
# include <errno.h>
# include "si_list.h"

/* sin_create(): Creates a new list node, if successuful returns the address of the new node. 
 * On error returns NULL and sets the errorno to ENOMEM.
 */
SINODE* sin_create(int data)
{
  SINODE* list_head = (SINODE*)malloc(sizeof(SINODE));
  list_head -> data = data;
  list_head -> next = NULL;
  if(list_head == NULL){
    errno = ENOMEM;
    return NULL;
  }
  return list_head;
}

/* sin_add(): Adds a node at the end of existing list.
 */
void sin_add(SINODE** head, SINODE* new_node)
{
  // Code to add a node at the end of exisiting list.
  // Note: The list may be empty initially
  if (*head == NULL)
  {
    sin_create(new_node -> data);
  }
  SINODE* temp = *head;
  while (temp -> next != NULL)
  {
    temp = temp -> next;
  }
  temp -> next = new_node;
}

/* sin_insert(): Creates a node with specified data and inserts it in the list at specified position and
 * returns the address of inserted node. pos = 0 signifies the first node.
 * A 0 or negative value of pos will insert the node at first position.
 * A value of pos, greater than the length will insert the node at the end.
 * On error, returns NULL and the errorno is set to ENOMEM
 */  
   
SINODE* sin_insert(SINODE** head, int data, int pos)
{
  // List is empty, new node is added as first node.
  // List is not empty, new node is inserted at first position.
  // New node is inserted beyond first node.
  if (*head == NULL)
  {
    sin_create(data);
  }  
  if (pos < 0)
  {
    pos = 0;
  }  
  if(&data == NULL)
  {
    errno = ENOMEM;
    return NULL;
  }
  int i = 0;
  SINODE* temp = *head;
  while (temp -> next != NULL)
  {
    if (i == pos - 1 || pos == 0)
    {
      break;
    }
    temp = temp -> next;
    i++;
  }
  SINODE* newTemp = (SINODE*)malloc(sizeof(SINODE));
  newTemp->data = data;
  /* Since there is no way to know if the user is handling and updating the head on the 
   * application side, I added a new node and moved the data in current head ahead in 
   * case the pos was 0.
   */
  if (pos == 0)
  {
    newTemp -> data += temp -> data;
    temp -> data = newTemp -> data - temp -> data;
    newTemp -> data -= temp -> data;
  }
  newTemp->next = temp->next;
  temp->next = newTemp;
  if (newTemp -> data == data)
  {
    return newTemp;
  }
  errno = ENOMEM;
  return NULL;
} 

/* sin_delete(): Deletes the node at specified position. Returns the data from the deleted node.
 */
int sin_delete(SINODE** head, int pos)
{
  if (pos < 0 || *head == NULL)
  {
    errno = EINVAL;
    return 0;
  }
  SINODE *temp = *head;
  int i = 0;
  int *data = (int *)malloc(sizeof(int));
  if (pos == 0)
  {
    *data = temp->data;
    *head = temp->next;
    free(temp);
    return *data;
  }
  while (temp -> next -> next != NULL)
  {
    if (i + 1 == pos)
    {
      break;
    }    
    i++;
    temp = temp -> next;
  }
  if(i + 1 != pos){
    errno = EINVAL;
    return 0;
  } 
  // else if (i + 1 == pos)
  // {
  //   *data = temp -> next -> data;
  //   free(temp -> next);
  //   temp->next = NULL;
  //   return *data;
  // }
  *data = temp->next->data;
  SINODE* delNode = temp -> next;
  temp -> next = temp -> next -> next;
  free(delNode);
  if (data != NULL)
  {
    return *data;
  }
  errno = EINVAL;
  return 0;
}

/* sin_length(): Returns the number of nodes in the list.
 */
int sin_length(SINODE* head)
{
  // Code to count the number of nodes in the list.
  if (head == NULL)
  {
    errno = EINVAL;
    return 0;
  }
  SINODE *temp = head;
  int i = 0;
  while (temp -> next != NULL)
  {
    i++;
  }
  return ++i;
}

/* sin_print(): Print the list from specified node, returns the number of nodes printed */ 
int sin_print(SINODE* curr)
{
  // Code to print the value (date) of nodes in the list.
  if (curr == NULL)
  {
    errno = EINVAL;
    return 0;
  }
  SINODE* temp = curr;
  int i = 0;
  while (temp -> next != NULL)
  {    
    printf("%d -> ",temp -> data);
    temp = temp -> next;
    i++;
  }
  printf("%d\n", temp->data);
  return ++i;
}
