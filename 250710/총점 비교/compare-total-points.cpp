#include <iostream>
#include <algorithm> 
using namespace std;

class Student{
    public: 
        string name;
        int s1, s2, s3, tot; 

        Student(string name, int s1, int s2, int s3){
            this->name = name;
            this->s1 = s1;
            this->s2 = s2;
            this->s3 = s3; 
            this-> tot = s1+s2+s3; 
        }

        Student(){

        }

        void get_string(){
            cout<<name<<" "<<s1<<" "<<s2<<" "<<s3<<endl;
        }
};

bool cmp(Student s1, Student s2){
    return s2.tot>s1.tot; 
}

int main() {
    int n; 
    cin>>n; 
    Student students[n]; 

    for(int i=0; i<n; i++){
        string name;
        int s1, s2, s3; 
        cin>>name>>s1>>s2>>s3; 
        students[i] = Student(name, s1, s2, s3); 
    }

    sort(students, students+n, cmp);

    for(int i=0; i<n; i++){
        students[i].get_string(); 
    }
    return 0;
}