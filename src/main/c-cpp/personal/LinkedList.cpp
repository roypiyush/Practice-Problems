#include <iostream>

using namespace std;

struct Node
{
    int value;
    Node *next;
}
*HEAD, *TAIL;


/*
* Inserts an element to the end of the list
*/
void insertNode(int value)
{
    Node *n = new Node;
    n->value = value;
    TAIL->next = n;
    TAIL = n;
}

void deleteNode(int value)
{
    Node* prev = HEAD;

    // Deletes a value from linked list
    if(prev->value == value)
    {
        if(HEAD == TAIL) {
            HEAD = TAIL = NULL;
            return;
        }
        Node* nextNode = prev->next;
        HEAD = nextNode;
        prev = NULL;
        return;
    }

    Node* currentNode = prev->next;

    while(currentNode != NULL && currentNode->value != value)
    {
        prev = prev->next;
        currentNode = currentNode->next;
    }

    if(currentNode != NULL && currentNode->value == value) {
        prev->next = currentNode->next;
        if(currentNode == TAIL) {
            TAIL = prev;
        }
        currentNode = NULL;
    }
    else {
        cout<<"Element to be deleted not found."<<endl;
    }

}

/*
  Copies a list.
*/
Node* copyList(Node* source)
{
    if (source == NULL)
        return NULL;

    Node* result = new Node;
    result->value = source->value;
    result->next = copyList(source->next);
    return result;
}

void printList(Node *node)
{
    Node* temp = node;

    cout<<endl;

    // Traverses on a linkedlist and prints all the values
    if(temp != NULL)
    {
        while(temp != NULL)
        {
            cout<<temp->value<<"->";
            temp=temp->next;
        }
        cout<<"null"<<endl;
    }
    else
    {
        cout<<"List is EMPTY.\n";
    }

    cout<<endl;
}

/*
   Returns a reversed list. It reverses the linkage between nodes
   Time complexity O(n) Space complexity O(1)
*/
Node* reverseList(Node *node)
{
    Node* list = NULL;
    Node* nextNode = NULL;
    Node* prev;

    while(node != NULL)
    {
        prev = node;
        nextNode = node->next;

        node->next=list;
        list = node;

        node = nextNode;
    }
    HEAD = list;
    TAIL = prev;
    return list;
}


void printChoices()
{
    cout<<"1. Insert"<<endl;
    cout<<"2. Delete"<<endl;
    cout<<"3. Reverse"<<endl;
    cout<<"4. Print"<<endl;
    cout<<"5. Copying and Printing"<<endl;
    cout<<"6. Quit"<<endl;
    cout<<"Enter your choice [1-6] : ";
}

int enterValue()
{
    int value;
    cout<<"Enter node value: ";
    cin>>value;
    return value;
}


int main(int argc, char *argv[])
{
    int choice = 0;
    HEAD = NULL, TAIL = NULL;
    while(true)
    {
        printChoices();
        cin>>choice;
        switch(choice)
        {
        case 1:
            if(HEAD == NULL && TAIL == NULL)
            {
                Node *node;
                node = new Node;
                node->value=enterValue();
                HEAD = node;
                TAIL = node;
            }
            else
            {
                insertNode(enterValue());
            }
            cout<<endl;
            break;
        case 2:
            deleteNode(enterValue());
            cout<<endl;
            break;
        case 3:
            cout<<"Reversing the list"<<endl;
            Node *temp;
            temp = HEAD;
            Node* node;
            node = reverseList(temp);
            printList(node);
            break;
        case 4:
            cout<<"Printing the list"<<endl;
            printList(HEAD);
            break;
        case 5:
            cout<<"Copying list to destination"<<endl;
            Node *destination, *head;
            head = HEAD;
            destination = copyList(head);
            printList(destination);
            break;
        case 6:
            cout<<"Quitting..."<<endl;
            return 0;
        default:
            cout<<"Invalid Choice. Please try again..."<<endl;
            break;
        }
    }
}
