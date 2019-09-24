/*
 * silist.h - header file for tree api for creating and managing BST of integers. 
 * author -  Yash Dave, https://github.com/Amorpheuz
 * version - 1.0, September 23, 2019
 */

#ifndef SYM_TREE_H

#define SYM_TREE_H

typedef struct bstnode
{
    int data;             // data element
    struct bstnode *left; // address of left node (if present)
    struct bstnode *right;// address of right node (if present)
    int balance_factor;   // balance factor of the node
    int height;           // height of the sub-tree having the node as root
} BSTNODE;                // BSTNODE represents a node of Binary Search Tree

BSTNODE *bstnode_create(int data); // Allocates the memory ofr a node

void bstnode_add(BSTNODE** root, BSTNODE* new_node); // Adds a node to the BST

int bstnode_delete(BSTNODE** root, int data); // Deletes the given node

int bstnode_height(BSTNODE* root); // Determines height considering give node as root

void bst_print(BSTNODE* root); //prints the bst

void bst_balance(); // Balances the BST

#endif