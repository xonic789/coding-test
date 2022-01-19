## Point ##
#1. 다음 index와 값이 같은 경우, pop을 하며 반복할 경우 효율성 문제가 발생한다.
#2. 리스트의 마지막 값과 다른 경우, push하는 형태로 구현하면 효율성 문제가 통과된다.

def solution(arr):
    answer = [arr[0]]
    for v in arr:
        if v != answer[-1]:
            answer.append(v)
            
    return answer