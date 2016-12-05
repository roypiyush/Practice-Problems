#include <iostream>
#include <cstdio>
#include <list>
#include <climits>

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
	// This is parent to child link up
        up = u->parent;
        if(u == up->left)
            up->left = v;
        else
            up->right = v;

	// This is child to parent link up
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
	    // Successor of node z
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

    void inorderTraverseK(BinaryTree *node, int* k, int K) {

        if(node == NULL)
            return;
        inorderTraverseK(node->left, k, K);
        (*k)++;
        if((*k) == K)
            printf("%d th element in Binary Tree is %d\n", K, node->getValue());
        inorderTraverseK(node->right, k, K);
    }

    
    bool check(BinaryTree* root, int min, int max) {
    
        if(root == NULL)
            return true;
        
        if(root->getValue() <= min || root->getValue() >= max)
            return false;
        
        if(root->left != NULL && root->left->getValue() > root->getValue())
            return false;
        
        if(root->right != NULL && root->right->getValue() < root->getValue())
            return false;
        
        return check(root->left, min, root->getValue()) && check(root->right, root->getValue(), max);
        
    }

    bool isBst(BinaryTree* root) {

        int MIN = -1;
        int MAX = 10001;
        return check(root, MIN, MAX);
    }

    BinaryTree* findLca(BinaryTree* node, int i, int j) {
    	
    	if(i == j) {
    	    return searchNode(i);
    	}
    	if(node->getValue() >= i && node->getValue() < j) {
    	    return node;
    	}
    	else if(node->getValue() > i && node->getValue() > j) {
    	    return findLca(node->left, i , j);
    	}
    	else if(node->getValue() < i && node->getValue() < j) {
    	    return findLca(node->right, i, j);
    	}
    	else {
    	    return NULL;
    	}
    }

    void printValuesInRange(BinaryTree* node, int i, int j) {
    	
    	if(node == NULL)
    	    return;
    	
    	if(node->getValue() > i)
	    printValuesInRange(node->left, i , j);

	if(node->getValue() >= i && node->getValue() <= j)
	   cout<<node->getValue()<<" ";
    	
	if(node->getValue() < j)
	    printValuesInRange(node->right, i, j);
    }

    void serialize(BinaryTree *node, list<int> &v) {
        if(node == NULL)
            return;
        v.push_back(node->value);
        serialize(node->left, v);
        serialize(node->right, v);
    }

    void deserialize(list<int> &v, BinaryTree *parent) {
        if(v.size() == 0) {
            return;
        }
        BinaryTree *node;
        int i = v.front();
        if(i < parent->value) {
            node = new BinaryTree(i);
            parent->left = node;
            node->parent = parent;
        }
        else {
            BinaryTree *p, *y;
            p = parent;
            y = p->parent;
            while(y->value < i) {
                p = y;
                if(y->parent != NULL)
                    y = y->parent;
                else
                    break;


            }
            node = new BinaryTree(i);
            p->right = node;
            node->parent = p;

        }
        v.pop_front();
        deserialize(v, node);
    }
    
    BinaryTree* des(list<int> &v, int min, int max) {
    
        if(v.size() == 0) {
            return NULL;
        }

        BinaryTree *root = NULL;
	int key = v.front();
		
	if(key < min || key > max)
	    return NULL;
		
	root = new BinaryTree(key);
	v.pop_front();
	
	if(key >= min && key <= max) {
	    root->left = des(v, min, key);
	    root->right = des(v, key, max);
	}
 
        return root;
    }
    
    
    void addGreaterValues(BinaryTree *node, int* sum) {
    
    	if(node == NULL)
    		return;
    		
    	addGreaterValues(node->right, sum);
    	node->value += *sum;
    	*sum = node->value;
    	return addGreaterValues(node->left, sum);
    
    }
    
    void greaterSumTree(BinaryTree *node, int* sum) {
    
    	if(node == NULL)
    		return;
    		
    	greaterSumTree(node->right, sum);
    	int temp = node->value;
    	node->value = *sum;
    	*sum = temp + *sum;
    	return greaterSumTree(node->left, sum);
    
    }

}*Root;


int main(int argc, char *argv[]) {

    Root = new BinaryTree(32);
    Root->insert(10);
    Root->insert(9);
    Root->insert(11);
    Root->insert(40);
    Root->insert(35);

    cout<<"Is Binary Search Tree "<<Root->isBst(Root)<<endl;
    BinaryTree* lca;
	
    int low = 9; int high = 9;
    lca = Root->findLca(Root, low, high);
    printf("Lca between %d and %d is %d \n", low, high, lca->getValue());

    low = 9; high = 35;
    lca = Root->findLca(Root, low, high);
    printf("Lca between %d and %d is %d \n", low, high, lca->getValue());
	
    low = 10; high = 11;
    lca = Root->findLca(Root, low, high);
    printf("Lca between %d and %d is %d \n", low, high, lca->getValue());

    low = 9; high = 11;
    printf("Print values in range %d and %d : ", low, high);
    Root->printValuesInRange(Root, low, high);
    cout<<endl;
	
    cout<<"Kth inorder ";
    int K = 3;
    int cur = 0;
    Root->inorderTraverseK(Root, &cur, K);

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

    cout<<"Calling serialize"<<endl;
    list<int> v;
    Root->serialize(Root, v);
    for (list<int>::iterator it = v.begin() ; it != v.end(); ++it)
        cout<<*it<<' ';
    cout<<endl;

    
    BinaryTree *newBt = NULL;
    /* 
    cout<<"Calling deserialize ";
    Root->deserialize(v, newBt);
    */
    
    newBt = Root->des(v, 9, 40);

    
    cout<<"Printing binary tree after deserialize";
    Root->inorderTraverse(newBt);
    /* */

    cout<<"\nDeleting node "<<nodeToDelete->getValue()<<endl;
    Root->deleteNode(nodeToDelete);
    printf("Inorder   Traverse   ");
    Root->inorderTraverse(Root);
    cout<<endl;
    cout<<"Add Greater values     ";
    int x = 0;
	Root->addGreaterValues(Root, &x);
	Root->inorderTraverse(Root);
	cout<<"\nGreater Sum Tree     ";
	x = 0;
	Root->greaterSumTree(Root, &x);
	Root->inorderTraverse(Root);
	cout<<endl;
    return 0;
}
