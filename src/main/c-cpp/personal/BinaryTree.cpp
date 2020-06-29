#include <iostream>
#include <unordered_set>

using namespace std;


struct Node {
    int data;
    struct Node* left, *right;
};
 
/* utility that allocates a new node with the
given data and NULL left and right pointers. */
struct Node* newnode(int data) {
    struct Node* node = new Node;
    node->data = data;
    node->left = node->right  = NULL;
    return (node);
}

bool isPath(Node *root, unordered_set<int> &s, Node *cur) {

	if(cur == NULL) return false;

	int data = root->data - cur->data;
	if(s.find(data) != s.end())
		return true;

	s.insert(cur->data);

	bool result = isPath(root, s, cur->left) || isPath(root, s, cur->right);
	s.erase(cur->data);
	return result;
}

bool isPathSum(Node *root) {

	// create an empty hash table 
	unordered_set<int> s;
	return isPath(root, s, root->left) || isPath(root, s, root->right);

}

int main()
{
    struct Node *root = newnode(8);
    root->left    = newnode(5);
    root->right   = newnode(4);
    root->left->left = newnode(9);
    root->left->right = newnode(7);
    root->left->right->left = newnode(1);
    root->left->right->right = newnode(12);
    root->left->right->right->right = newnode(2);
    root->right->right = newnode(11);
    root->right->right->left = newnode(3);
    isPathSum(root)? cout << "Yes"<<endl : cout << "No"<<endl;
    return 0;
}
