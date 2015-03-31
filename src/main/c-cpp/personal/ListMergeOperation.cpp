#include <iostream>

using namespace std;

class Node
{
	private:
    int value;
    Node *next, *HEAD, *TAIL;
    
    
    public:
    
    int getValue() {
    	return this->value;
    }
    
    Node* getNext() {
    	return this->next;
    }
    
    void setNext(Node* n) {
    	this->next = n;
    }
    
    Node* getHead() {
    	return this->HEAD;
    }
    
    void setHead(Node* n) {
    	this->HEAD = n;
    }
    
    Node* getTail() {
    	return this->TAIL;
    }
    
    void setTail(Node* n) {
    	this->TAIL = n;
    }
    
    /*
	* Inserts an element to the end of the list
	*/
	void insertNode(int value)
	{
		if(HEAD == NULL) {
			this->value = value;
			HEAD = this;
			TAIL = this;
			return;	
		}
		
		Node *n = new Node;
		n->value = value;
		TAIL->next = n;
		TAIL = n;
	}

	void printList()
	{
		Node* temp = HEAD;

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
};

Node* merge(Node* lista, Node* listb) {
	Node *cur, *cura, *curb;
	
	cout<<"List A : ";lista->printList();
	cout<<"List B : ";listb->printList();
	
	cura = lista;
	curb = listb;
	
	int listNo = 0;
	if(cura->getValue() <= curb->getValue()) {
		cur = cura;
		cura = cura->getNext();
		listNo = 1;
	}
	else {
		cur = curb;
		curb = curb->getNext();
		listNo = 2;
	}
	
	while(cura != NULL && curb != NULL) {
	
		if(cura->getValue() <= curb->getValue()) {
			cur->setNext(cura);
			cur = cura;
			cura = cura->getNext();
		}
		else {
			cur->setNext(curb);
			cur = curb;
			curb = curb->getNext();
		}
	}
	
	if(cura == NULL && curb != NULL) {
		cur->setNext(curb);
	}
	if(cura != NULL && curb == NULL) {
		cur->setNext(cura);
	}
	
	if(listNo == 1)
		return lista;
	else
		return listb;
	
	
	
}

int main(int argc, char *argv[])
{
	Node *lista, *listb, *mergedList;
	lista = new Node;
	listb = new Node;
	
	lista->insertNode(3);lista->insertNode(8);lista->insertNode(10);lista->insertNode(15);lista->insertNode(17);lista->insertNode(18);lista->insertNode(19);
	listb->insertNode(2);listb->insertNode(3);listb->insertNode(5);listb->insertNode(15);listb->insertNode(18);listb->insertNode(20);listb->insertNode(21);
	
	mergedList = merge(lista, listb);
	cout<<"Merged List : ";mergedList->printList();
	cout<<"Printing both lists after merge list"<<endl;
	
	cout<<"List A : ";lista->printList();
	cout<<"List B : ";listb->printList();
	
	return 0;
}
