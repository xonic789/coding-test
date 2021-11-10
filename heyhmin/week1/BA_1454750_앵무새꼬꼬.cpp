#include <iostream>
#include <string>
#include <vector>
using namespace std;
int main() {
	int n = 0;
	string input;
	vector<char> output(300);
	vector<string> out;
	cin >> n;
	cin.get(); // !
	for(int i = 1; i <= n; ++i){
		getline(cin, input); // !
		int len = input.size();
		output.clear();
		for(int j = 0; j <= len; ++j){
			switch(input[j]){
				case 'a': case 'A': case 'e': case 'E': case 'i': case 'I': case 'o': case 'O': case 'u': case 'U': output.push_back(input[j]); break;					
				default: break;
			}
		}
		if(output.empty()) out.push_back("???");
		else {
			string outtmp(output.begin(), output.end()); // !
			out.push_back(outtmp);
		}
	}
	int len = out.end() - out.begin() + 1;
	for(int i = 0; i < len; ++i){
		cout << out[i] << endl;
	}
	return 0;
}
