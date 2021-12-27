## Point ##
#1. citations 값 중에서
    #1.1 'h 이상' 조건에 만족하는 값의 개수를 구한다.
    #1.2 'h 이상' 조건에 만족하지 않는 값의 개수를 구한다.( 나머지 )
#2. 'h 이상' 조건 만족하는 값의 개수가 'h 이상' 그리고 나머지 개수가 'h 이하'인 경우 리스트에 추가
#3. 리스트의 길이가 0보다 크다면 가장 큰 값을 출력, 길이가 1이라면 리스트[0] 출력

def solution(citations):
    index_list = []
    n = len(citations)
    for h in range(1, n+1):
        over, under = 0, 0
        for v in citations:
            if(v >= h): over += 1 # h번 이상 인용된 논문
            else: under += 1 # 나머지 논문
        
        if over >= h and under <= h: # h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용
            index_list.append(h)
    
    return max(index_list) if len(index_list) > 0 else citations[0]