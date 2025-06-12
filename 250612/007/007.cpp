#include <iostream>
#include <string>
using namespace std;

class Agent{
    public:
        string code;
        char place; 
        int hour; 

        Agent(string code, char place, int hour){
            this->code=code; 
            this->place=place; 
            this->hour=hour; 
        } 
};

int main() {
    string code;
    char place;  
    int hour; 
    cin>>code>>place>>hour;
    Agent s = Agent(code, place, hour); 
    cout << "secret code : " << s.code << endl;
    cout << "meeting point : " << s.place << endl;
    cout << "time : " << s.hour << endl;
    return 0;
}