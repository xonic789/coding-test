## Point ##
#1. 문제에서 제공된 공식 : x * y = brown + yellow
#2. 발견한 공식
#n = yellow : { [n//1+2, 3], [n//2+2, 4], [n//3+2, 5], ... } : [n//i+2, i+2]
#3. 아래 두 조건을 만족하는 경우 반환
    # 조건1 : yellow % i== 0
        # 경우의 수에 추가되는 경우는 i에 나눠서 떨어지는 경우만 존재한다.
        # 위 조건을 제한하지 않으면 의미없는 경우의 수가 탐색되고,
        # 다음 조건(x * y == brown + yellow)과 우연히 맞아 떨어지는 경우가 존재한다.
    # 조건2 : x * y == brown + yellow

import math
def solution(brown, yellow):
    for i in range(1, int(math.sqrt(yellow) + 1)):
        x, y = yellow // i + 2, i + 2
        if yellow % i== 0 and x * y == brown + yellow:
            return [x, y]