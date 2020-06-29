#include <iostream>

using namespace std;

bool interleaved(char *A, char * B)
{
	return false;
}


int main(int argc, char* argv[])
{
	char * s = "Joe"; //First of all, why can I assign 3 chars to a pointer?
  cout << s << endl;

  s = "Frederick"; //Why can I change the pointer to a different number of chars? What does this even point to??
  cout << s << endl;
  return 0;
}
