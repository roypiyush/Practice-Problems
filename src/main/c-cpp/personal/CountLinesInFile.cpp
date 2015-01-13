#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main(int argc, char* argv[])
//int main(void)
{
	string line;
	int count = 0;
	ifstream file("/home/piyush/Programming/LetMeC/testFile", ios::in);
	if(file.is_open())
	{
		
		cout<<"Counting using get function. \n";

		int ch;
		while((ch = file.get()) != -1)
		{
			char c = (char)ch;
			if(c == '\n')
			{
				count = count + 1;
			}
			cout<<c;
		}

		cout<<"Line count using get() : "<<count<<endl;

		count = 0;

		//file.clear();
		file.seekg(0, ios_base::beg);

		cout<<"Counting usnig getline function. \n";

		while(!file.eof())
		{
			getline(file, line);
			count = count + 1;
			cout<<"Line : "<<count<<" ==> "<<line<<endl;
		}

		file.clear();
                file.seekg(0, ios_base::end);
		int size = file.tellg();
		cout<<"File Size : "<<size<<endl;
	}

	file.close();
	
	return 0;
}
	
