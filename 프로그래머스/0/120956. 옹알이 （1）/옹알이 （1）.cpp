#include <string>
#include <vector>
#include <set>

using namespace std;

int solution(vector<string> babbling) {
    int answer = 0;
 
    for (string s : babbling) {
        bool hasWord = true;
        // 잘라가면서 확인
        for (int j = 0; j < s.size(); j++) {
            if (s.substr(j, 3) == "aya") j += 2;
            else if (s.substr(j, 2) == "ye") j += 1;
            else if (s.substr(j, 3) == "woo") j += 2;
            else if (s.substr(j, 2) == "ma") j += 1;
            else {
                hasWord = false;
                break;
            }
        }
        answer = (hasWord) ? answer + 1 : answer;
    }
    
    return answer;
}

/*
    [풀이 참고]
    - 옹알이들 조합 = 발음 가능
    - 각 단어에서 최대 하나씩만 옹알이 조합 가능
*/