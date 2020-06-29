#include <iostream>
#include <cstring>

using namespace std;

void encode(string &src, string &des) {

	int index = 0;
	char runTotal = 0, currentChar = 0;
	while(index < (int)src.length()) {

		runTotal = 0;
		currentChar = src[index];
		while(runTotal < 255 && currentChar == src[index]) {
			runTotal++;
			index++;
		}

		if(runTotal > 3) {
			des += '~';
			des += runTotal;
			des += currentChar;
		}
		else {
			for(int i = 0; i < runTotal; i++)
				des += currentChar;	

		}
	}
}

void decode(string &src, string &des) {

	int index = 0, runTotal = 0;
	char currentChar = 0;

	while(index < (int) src.length()) {
	
		if(src[index++] == '~') {
			runTotal = (int)src[index++];
			currentChar = src[index++];
		
			for(int i = 0; i < runTotal; i++)
				des += currentChar;
		}
		else {
			des += src[index - 1];
		}
	}
}

int main() {

	cout << "Run Length Encoding" << endl;
	cout << "Chapter 14: Data Compression and Encryption" << endl;
	cout << endl;

	string str = "AAAAaaBBBBBBCCCCCCddddddEEEEEeeeeFFFFGGGG";
	string encodedStr, decodedStr;

	cout << "Original Data Size:" << str.length() << endl;
	cout << "Original Data:" << endl;
	cout << str << endl << endl;

	encode(str, encodedStr);
	cout << "Compressed Size: " << encodedStr.length() << endl;
	cout << "Compressed Data:" << endl;
	cout << encodedStr << endl << endl;
	decode(encodedStr, decodedStr);
	cout << "Decompressed Size: " << decodedStr.length() << endl;
	cout << "Decompressed Data:" << endl;
	cout << decodedStr << endl << endl;

	return 0;
}
