## Point ##
#1. 3진법 값 0, 1, 2를 각각 1, 2, 4로 변경하여 리스트에 저장
#2. 마지막 자리 수 부터 값을 값을 구하면서 왼쪽에 새로운 값 붙이기

def solution(n):
    value = [1, 2, 4]
    answer = ''

    while n > 0:
        answer = str(value[n % 3 - 1]) + answer
        if n % 3 == 0:
            n -= 1
        n = n // 3
    
    return answer