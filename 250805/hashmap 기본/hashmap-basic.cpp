#include <iostream>
#include <string>
#include <unordered_map>

using namespace std;

string to_result_string(unordered_map<int, int>::const_iterator it,
                        unordered_map<int, int>::const_iterator end) {
    return (it == end ? "None" : to_string(it->second));
}

void handle_action(unordered_map<int, int>& map,
                   const string& action,
                   int key) {
    if (action == "add") {
        int value;
        cin >> value;
        map[key] = value;
    } else if (action == "find") {
        cout << to_result_string(map.find(key), map.end()) << endl;
    } else if (action == "remove") {
        map.erase(key);
    }
}

int main() {
    unordered_map<int, int> map;
    int n;
    cin >> n;

    while (n--) {
        string action;
        int key;
        cin >> action >> key;
        handle_action(map, action, key);
    }

    return 0;
}