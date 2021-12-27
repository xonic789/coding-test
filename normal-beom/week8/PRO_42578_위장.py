## Point ##
#1. 리스트 구조체화( key: 종류, value: 이름 )
#2. 경우의 수 반복문 수행
    #( answer *= count+1, answer += count )

def solution(clothes):
    closet = {}
    answer = 0
    
    for value in clothes:
        if closet.get(value[1]):
            closet[value[1]].append(value[0])
        else:
            closet[value[1]] = [value[0]]

    for key in closet:
        count = len(closet[key])
        answer *= (count + 1)
        answer += count
    
    return answer