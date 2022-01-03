## Point ##
# visited 반복, False인 경우 방문,
    # visited[i] = True 처리 -> 자신 제외한 나머지 1 방문 -> visited[i] = True 처리 
    # -> 더이상 없을 경우 반복 종료, return 1
# visited 값이 True인 경우 return 0
# 반환값을 전부 더한 값 출력

def solution(n, computers):
    visited = [False]*n
    count = 0

    def bfs(index):
        if not visited[index]:
            visited[index] = True
            for i in range(n):
                if index != i and computers[index][i] == 1:
                    if not visited[i]:
                        bfs(i)
            return 1
        return 0

    for index in range(n):
        count += bfs(index)
        
    
    return count