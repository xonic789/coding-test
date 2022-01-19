## Point ##
#1. zip() 사용하여 반복문 하나에 두 리스트 포함
#2. sign 참 거짓에 따라 +- 판별, 누적 값 출력

def solution(absolutes, signs):
    answer = 0
    for value, sign in zip(absolutes, signs):
        answer += value if sign else -value
        
    return answer