#include <iostream>
#include <cassert> // 백준 제출 시 삭제
#include <algorithm>
#include <vector>
#include <queue> // 백준 제출 시 삭제
#include <functional> // 백준 제출 시 삭제

#define _CRT_SECURE_NO_WARNINGS // 백준 제출 시 삭제
#pragma warning(disable:4996) // 백준 제출 시 삭제
#define endl '\n'
#define prt(x) #x << ' ' << x << ' '
#define REP(i,a,b) for (auto i = (a); i <= (b); ++i) // vector.end() - 1
#define false 0
#define true 1

using namespace std;
int T, t, res, n, k;
vector<vector<int>> things(102, vector<int>(2, 0));
int dr[] = { 0, 0, 0, 1, -1 }; // 백준 제출 시 삭제
int dc[] = { 0, 1, -1, 0, 0 }; // 백준 제출 시 삭제

void init() {
	res = 0;
	things.clear();
	things.resize(102, vector<int>(2, 0));
}

int main() {
	assert(freopen("input.txt", "r", stdin)); // 백준 제출 시 삭제
	assert(freopen("output.txt", "w", stdout)); // 백준 제출 시 삭제

	cin >> T; // 백준 제출 시 변형
	t = 0;

	while (t < T) {
		// 초기화 & 입력
		t++;
		init();

		cin >> n >> k;
		REP(i, 1, n) {
			cin >> things[i][0] >> things[i][1];
		}
		// 입력 완료
    
		// 물건 개수 - 총 무게에서 최댓값만 기억하는 테이블
		vector<vector<int>> memo(102, vector<int>(100002, 0));
		REP(i, 1, n) {
			REP(j, 1, k) {
				memo[i][j] = memo[i - 1][j]; // 안 넣은 경우
				if (things[i][0] <= j) // 넣는 경우
					memo[i][j] = max(memo[i][j], things[i][1] + memo[i - 1][j - things[i][0]]);
				res = max(res, memo[i][j]);
			}
		}
		
		cout << "test " << t << " : " << res << endl; // 백준 제출 시 변형
		
	}
	
	return 0;
}

/*
// 시간초과 판정
void bag(int weight, int value, vector<bool> visit, int cnt) {
	if (cnt >= n) return; // 모든 물건에 대한 선택을 완료
	//cout << prt(weight) << prt(value) << prt(cnt) << endl;
	REP(i, 1, n) {
		// 가방에 안 넣은 경우
		visit[i] = true;
		bag(weight, value, visit, ++cnt);
		--cnt;
		visit[i] = false;
		// 가방에 넣기
		if (!visit[i] && weight + things[i][0] <= k) {
			visit[i] = true;
			weight += things[i][0];
			value += things[i][1];
			if (res < value) res = value;
			bag(weight, value, visit, ++cnt);
			--cnt;
			visit[i] = false;
			weight -= things[i][0];
			value -= things[i][1];
		}
	}
}
*/
