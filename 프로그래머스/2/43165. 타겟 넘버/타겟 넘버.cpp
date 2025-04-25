#include <string>
#include <vector>

using namespace std;

static vector<int> nums;
static int t;
static int answer = 0;

void dfs(int idx, int temp) {
    if (idx == nums.size()) {
        if (temp == t) {
            answer++;
        }
        return;
    }
    
    dfs(idx + 1, temp + nums[idx]);
    dfs(idx + 1, temp - nums[idx]);
}

int solution(vector<int> numbers, int target) {
    nums = numbers;
    t = target;
    
    dfs(0, 0);
    
    return answer;
}

/*
    3:46 ~ 4:35
    - n개: 음이 아닌 정수
    - 순서 바꾸지 않고 더하기/빼기로 타겟 넘버 만들기

    [풀이]
    - DFS: "signal: segmentation fault (core dumped)" -> idx 넘어갈 때 무조건 return
    - BFS: 시간 초과 -> 마찬가지로 인덱스 조심, 문법 주의
*/
