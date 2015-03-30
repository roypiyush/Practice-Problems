#include <iostream>
#include <cstdio>

using namespace std;

class BinaryTree {

private:
    int value;
    BinaryTree *left = NULL;
    BinaryTree *right = NULL;
    BinaryTree *parent = NULL;

    int k;

public:
    BinaryTree(int value) {
        this->value = value;
    }

    ~BinaryTree() {
        this->value = 0;
        this->left = NULL;
        this->right = NULL;
        this->parent = NULL;
    }

    void setValue(int value) {
        this->value = value;
    }

    int getValue() {
        return this->value;
    }

    void setLeft(BinaryTree *left) {
        this->left = left;
    }

    void setRight(BinaryTree *right) {
        this->right = right;
    }

    void setParent(BinaryTree *parent) {
        this->parent = parent;
    }

    void insert(int key) {

        BinaryTree *node = this;
        BinaryTree *child = new BinaryTree(key);

        if(node == NULL) {
            node = child;
            return;
        }

        BinaryTree *parent = this;
        while(node != NULL) {

            if(node->value == key)
                cout<<"Value already exists in the tree.\n";

            parent = node;
            if(key < node->value) {
                node = node->left;
            }
            else {
                node = node->right;
            }

        }

        if(key < parent->value) {
            parent->left = child;
        }
        else {
            parent->right = child;
        }

        child->parent = parent;
    }

    void inorderTraverse(BinaryTree *node) {

        if(node == NULL)
            return;
        inorderTraverse(node->left);
        cout<<node->getValue()<<" ";
        inorderTraverse(node->right);
    }

    void preorderTraverse(BinaryTree *node) {

        if(node == NULL)
            return;
        cout<<node->getValue()<<" ";
        preorderTraverse(node->left);
        preorderTraverse(node->right);
    }

    void postorderTraverse(BinaryTree *node) {

        if(node == NULL)
            return;
        postorderTraverse(node->left);
        postorderTraverse(node->right);
        cout<<node->getValue()<<" ";
    }

    BinaryTree* treeMinimum(BinaryTree *node) {

        if(node == NULL)
            return NULL;

        while(node->left != NULL) {
            node = node->left;
        }
        return node;
    }


    BinaryTree* treeMaximum(BinaryTree* node) {

        if(node == NULL)
            return NULL;

        while(node->right != NULL) {
            node = node->right;
        }

        return node;
    }

    BinaryTree* successor(BinaryTree *node) {

        if(node == NULL)
            return NULL;

        if(node->right != NULL)
            return treeMinimum(node->right);

        BinaryTree* y = NULL;
        y = node->parent;
        while(y != NULL && node == y->right) {

            node = y;
            y = y->parent;
        }

        return y;
    }

    BinaryTree* predecessor(BinaryTree *node) {

        if(node == NULL)
            return NULL;

        if(node->left != NULL)
            return treeMaximum(node->left);

        BinaryTree* y = NULL;
        y = node->parent;
        while(y != NULL && node == y->left) {
            node = y;
            y = y->parent;
        }
        return y;
    }

    void transplant(BinaryTree* u, BinaryTree* v) {

        BinaryTree* up = NULL;

        if(u == NULL)
            return;
        else if(u->parent == NULL) {
            //Root = v;
            return;
        }

        up = u->parent;
        if(u == up->left)
            up->left = v;
        else
            up->right = v;

        if(v != NULL) {
            v->parent = u->parent;

        }

    }


    BinaryTree* searchNode(int key) {
        BinaryTree* node = NULL;
        node = this;

        while(node != NULL && node->value != key) {
            if(node->value > key)
                node = node->left;
            else
                node = node->right;
        }

        return node;
    }

    void deleteNode(BinaryTree* z) {

        BinaryTree* root = NULL;
        root = this;

        if(z->left == NULL) {
            transplant(z, z->right);
        }
        else if(z->right == NULL) {
            transplant(z, z->left);
        }
        else {
            BinaryTree* y = treeMinimum(z->right);
            if(y->parent != NULL) {
                transplant(y, y->right);
                y->right = z->right;
                y->right->parent = y;
            }
            transplant(z, y);
            y->left = z->left;
            y->left->parent = y;
        }

    }

}*Root;


int main(int argc, char *argv[]) {

    Root = new BinaryTree(32);
    Root->insert(10);
    Root->insert(9);
    Root->insert(11);
    Root->insert(40);
    Root->insert(35);

    printf("Inorder   Traverse   ");
    Root->inorderTraverse(Root);
    cout<<endl;
    printf("Preorder  Traverse   ");
    Root->preorderTraverse(Root);
    cout<<endl;
    printf("Postorder Traverse   ");
    Root->postorderTraverse(Root);
    cout<<endl;

    printf("Tree Minimum: %d \n", Root->treeMinimum(Root)->getValue());
    printf("Tree Maximum: %d \n", Root->treeMaximum(Root)->getValue());
    printf("Tree Successor   of Root = %d is %d \n",  Root->getValue(), Root->successor(Root)->getValue());
    printf("Tree Predecessor of Root = %d is %d \n",  Root->getValue(), Root->predecessor(Root)->getValue());


    int key = 40;
    printf("Searching for %d ", key);
    BinaryTree* nodeToDelete = NULL;
    if((nodeToDelete = Root->searchNode(key)) != NULL) {
        cout<<"Found";
    }
    else {
        cout<<"Not Found";
    }
    cout<<endl;

    Root->deleteNode(nodeToDelete);
    printf("Inorder   Traverse   ");
    Root->inorderTraverse(Root);
    cout<<endl;

    return 0;
}
