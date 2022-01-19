## 소수 찾기 Point ##
#1. 분석해야하는 구간을 찾는다.
#2. 2를 제외하고, 2로 나누어지는 값은 검사하지 않고 넘어간다.(효율성)
#3. 해당 값의 **0.5(제곱근)+1 까지 검사한다.

def solution(n):
    answer = 0
    for v in range(2, n+1): #1
        flag = True
        if v != 2 and v % 2 == 0: #3
            continue
        for i in range(2, int(v**0.5)+1): #2
            if v % i == 0:
                flag = False
                break
        if flag:
            answer += 1
    return answer