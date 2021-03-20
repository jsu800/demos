#include <iostream>
#include <string>
using namespace std;

/**
 * PURPOSE: Given two valid, English-lowercase, non-empty C++ strings, s1 and s2, check to see 
 *          if they are an anagram of each other.
 * PARAMETER:
 *     string s1, the first string.
 *     string s2, the second string.
 * RETURN VALUE:
 *     A boolean value representing the outcome of whether the strings are an anagram of each other.
 * FUNCTION SINGATURE:
 *     bool isAnagram(string s1, string s2)
*/
bool isAnagram(string s1, string s2) {

    if (s1.length() != s2.length()) return false;

    // O(1) - memory 
    char dictionary[26] = {};

    // O(N)
    for (int i=0; i<s1.length(); i++) {
        dictionary[s1[i]-'a']++;
        dictionary[s2[i]-'a']--;
    }

    // O(N)
    for (int i=0; i<s1.length(); i++) {
        if (dictionary[i] != 0) return false;
    }
    return true;
}


int main()
{
    cout << isAnagram("adobe", "abode") << endl;
    return 0;
}