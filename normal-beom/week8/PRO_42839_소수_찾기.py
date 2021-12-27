## Point ##
#1. itertools 라이브러리의 permutations 함수 사용하여 numbers의 조합 구하기
#2. 해당 조합의 값이 소수인지 판별, 소수인 경우 number_list.append(소수)
#3. number_list의 길이 반환

from itertools import permutations

def solution(numbers):
    length = len(numbers)
    number_list = []
    
    for i in range(1, length+1):
        number_list += list(map(''.join, permutations(numbers, i)))

    number_list = list(set(map(int, number_list)))
    answer = []
    for v in number_list:
        if v <= 1: continue
        flag = True
        for i in range(2, v):
            if v % i == 0:
                flag = False
                break
        if flag:
            answer.append(v)

    return len(answer)