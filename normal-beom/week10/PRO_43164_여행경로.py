## Point ##
#1. DFS 재귀 풀이
#2. 출발지가 'ICN'인 경우가 여러개 존재할 수 있음을 감안하여 구현
#3. tickets과 now_record를 얕은 복사를 이용하여 DFS 구현
#4. 모든 항공권을 사용한 경우를 전역변수 record에 추가
#5. 정렬 후 가장 앞에 있는 리스트 반환

def solution(tickets):
    record = []
    size = len(tickets)

    def dfs(tickets, index, now_record, count):
        ticket = tickets.pop(index)
        next_place = ticket[1]
        now_record.append(next_place)

        if count == size:
            return record.append(now_record) #4
        
        for idx, arr in enumerate(tickets):
            if arr[0] == next_place:
                dfs(tickets[:], idx, now_record[:], count + 1) #3
                

    for idx, arr in enumerate(tickets): #2
        if arr[0] == 'ICN':
            dfs(tickets[:], idx, ['ICN'], 1) #3
    
    return sorted(record)[0] #5