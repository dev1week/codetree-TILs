#include <iostream>
#include <string>
#include <algorithm> 

using namespace std;

int n;
string name[10];
int korean[10];
int english[10];
int math[10];

class Student{


    public:
        string name; 
        int kor, eng, math; 
        Student(string name, int kor, int eng, int math){
            this->name=name; 
            this->kor=kor;
            this->eng=eng;
            this->math=math; 
        }
        Student(){

        }

        void get_string(){
            cout<<name<<" "<<kor<<" "<<eng<<" "<<math<<endl; 
        }

};

bool cmp(Student s1, Student s2){
    if(s1.kor==s2.kor){
        if(s1.eng==s2.eng){
            return s1.math>s2.math; 
        }
        return s1.eng>s2.eng; 
    }
    return s1.kor>s2.kor;
}

int main() {
    cin >> n;
    Student students[n]; 

    for (int i = 0; i < n; i++) {
        string name;
        int kor, eng, math; 
        cin>>name>>kor>>eng>>math; 
        students[i] = Student(name, kor, eng, math);
    }


    sort(students, students+n, cmp);

    for(int i=0; i<n; i++){
        students[i].get_string(); 
    }
    // Please write your code here.

    return 0;
}