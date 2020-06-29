#include <iostream>
#include <vector>
#include <tr1/memory>
#include <algorithm>
#include <iterator>
 
template <typename E>
struct Node {
  E value;
  std::tr1::shared_ptr<Node<E> > pointer;
};
 
template <class E>
struct node_ptr_less {
  bool operator()(const std::tr1::shared_ptr<Node<E> > &node1,
		  const std::tr1::shared_ptr<Node<E> > &node2) const {
    return node1->value < node2->value;
  }
};
 
 
template <typename E>
std::vector<E> lis(const std::vector<E> &n) {
  typedef std::tr1::shared_ptr<Node<E> > NodePtr;
 
  std::vector<NodePtr> pileTops;
  // sort into piles
  for (typename std::vector<E>::const_iterator it = n.begin(); it != n.end(); it++) {
    NodePtr node(new Node<E>());
    node->value = *it;
    typename std::vector<NodePtr>::iterator j =
      std::lower_bound(pileTops.begin(), pileTops.end(), node, node_ptr_less<E>());
    if (j != pileTops.begin())
      node->pointer = *(j-1);
    if (j != pileTops.end())
      *j = node;
    else
      pileTops.push_back(node);
  }
  // extract LIS from piles
  std::vector<E> result;
  for (NodePtr node = pileTops.back(); node != NULL; node = node->pointer)
    result.push_back(node->value);
  std::reverse(result.begin(), result.end());
  return result;
}

int main() {
  int n; std::cin>>n;
  int arr1[n];
  int i = 0;
  while(i < n) {
      std::cin>>arr1[i];
      i++;
  }
  std::vector<int> vec1(arr1, arr1 + sizeof(arr1)/sizeof(*arr1));
  std::vector<int> result1 = lis(vec1);
  std::cout << result1.size() <<std::endl;
}
