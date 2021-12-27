## Point ##
#1. 사용자 3명 반복 주기의 최소공배수 길이(40)만큼 리스트 선언
#2. 정답 리스트(collect) 선언
#3. answers의 값과 사용자 3명의 답을 모두 비교하여 collect에 append()
#4. 가장 큰 값과 나머지 collect 값을 비교하여 같으면, answer 리스트에 해당 사용자 추가

def solution(answers):
    user = {
        1 : [1, 2, 3, 4, 5]*8,
        2 : [2, 1, 2, 3, 2, 4, 2, 5]*5,
        3 : [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]*4
    }    
    collect = [0, 0, 0]
    answer = []
    
    for i, v in enumerate(answers):
        for j in range(1, 4):
            if v == user[j][i % 40]:
                collect[j-1] += 1
    
    max_value = max(collect)
    
    for index, value in enumerate(collect):
        if value == max_value:
            answer.append(index+1)
    
    return answer