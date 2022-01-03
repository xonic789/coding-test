## Point ##
#1. lost, reserve 중복 제거
#2. lost 값의 +-1 모두 reserve에 존재하는 경우
    #2.1. lost의 다음 값의 -1이 reserve에 존재하는 경우 lost값 -1 pop
    #2.2. 아닌 경우 lost값 +1 pop
#3. 2번 조건에 False 이며,
    #3.1. lost값 -1이 reserve에 존재하는 경우 lost값 -1 pop
    #3.2. lost값 +1이 reserve에 존재하는 경우 lost값 +1 pop

def solution(n, lost, reserve):
    count = 0
    # 리스트간 중복 제거
    lost, reserve = list({*lost} - {*reserve}), list({*reserve} - {*lost})
        
    for i, l in enumerate(lost):
        if l-1 in reserve and l+1 in reserve:
            if len(lost) > i+1 and lost[i+1]-1 in reserve:
                reserve.pop(reserve.index(l-1))
                count += 1
            else:
                reserve.pop(reserve.index(l+1))
                count += 1
        elif l-1 in reserve:
            reserve.pop(reserve.index(l-1))
            count += 1
        elif l+1 in reserve:
            reserve.pop(reserve.index(l+1))
            count += 1
            
    return n - len(lost) + count