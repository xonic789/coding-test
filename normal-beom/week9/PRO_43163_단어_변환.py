## Point ##
#1. target이 words 안에 있는 경우 index 저장
#2. target이 words 안에 없는 경우 0 반환
#3. words_graph와 begin_graph 생성
#4. dfs 이용하여 target까지의 거리 구하여 리스트에 누적
#5. 누적된 값 중에서 가장 작은 값 반환 (현재 테스트케이스에서는 필요 없는 구분)

def solution(begin, target, words):
    list_length = len(words)
    word_length = len(begin)
    words_graph = [[] for _ in range(list_length)]
    begin_graph = []
    target_index = 0
    answer_list = []
    
    if target in words: #1
        target_index = words.index(target)
    else: #2
        return 0

    for i in range(list_length): #3
        for k in range(list_length):
            if len([j for j in range(word_length) if words[i][j] == words[k][j]]) == word_length - 1:
                words_graph[i] += [k]
        if len([j for j in range(word_length) if begin[j] == words[i][j]]) == word_length - 1:
            begin_graph.append(i)

    def dfs(now, acc, visited): #4
        visited[now] = True
        if now == target_index:
            return acc
        if target_index in words_graph[now]:
            return acc + 1
        else:
            for index in words_graph[now]:
                if not visited[index]:
                    return dfs(index, acc+1, visited)
        return 0
        

    for v in begin_graph: #4
        visited = [False for _ in range(list_length)]
        answer_list.append(dfs(v, 1, visited))
    
    return min(answer_list) #5