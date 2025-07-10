#include <iostream>
#include <string> 
#include <algorithm> 
using namespace std;

class Person{
    string name;
    int h, w; 

    public: 
    Person(int h, int w, string name){
        this->h = h;
        this->w = w;
        this->name = name; 
    }
    Person(){

    }

    void get_string(){
       cout<<name<<" "<<h<<" "<<w<<endl; 
    }
    int get_w(){
        return w;
    }
    int get_h(){
        return h; 
    }
};

bool cmp(Person p1, Person p2){
    return p2.get_h()>p1.get_h(); 
}

int main() {

    int n; 

    cin>>n; 

    Person people[n];
    for(int i=0; i<n; i++){
        string name;
        int h, w;
        cin>>name>>h>>w; 
        people[i] = Person(h,w,name); 
    }

    sort(people, people+n, cmp); 

    for(int i=0; i<n; i++){
        people[i].get_string(); 
    }
    // Please write your code here.
    return 0;
}