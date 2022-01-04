## Point ##
#1. n 인덱스의 left, right 값과 n + 1[now] 값을 더하여 더 큰 값을 n + 1[now]의 값으로 저장
#2. 단, 값의 위치가 처음과 끝일 경우, 발생 가능한 경우의 수는 단 하나이다.
#3. 위 과정을 triangle 길이만큼 반복, 가장 큰 값 출력

def solution(triangle):
    length = len(triangle)
    for i in range(1, length):
        for j in range(i+1):
            if j == 0:
                triangle[i][j] += triangle[i-1][j]
            elif j == i:
                triangle[i][j] += triangle[i-1][j-1]
            else:
                triangle[i][j] += max([triangle[i-1][j-1], triangle[i-1][j]])
        
    return max(triangle[length-1])


## 풀이 시도 - dfs (실패) ##
# 풀이 : 정방향(n -> n+1)으로 모든 경우의 수 구하여 최대값 출력
# 결과 : 시간초과, 효율성 문제

# def solution(triangle):
#     end_length = len(triangle)
#     answer = []

#     def dfs(arr, l_index, r_index, acc, count):
#         left_value = triangle[count][l_index]
#         right_value = triangle[count][r_index]
#         if count + 1 == end_length :
#             answer.append(acc + left_value)
#             answer.append(acc + right_value)
#         else:
#             dfs(triangle[count+1], l_index, l_index+1, acc + left_value, count + 1)
#             dfs(triangle[count+1], r_index, r_index+1, acc + right_value, count + 1)

#     dfs(triangle[0], 0, 0, triangle[0][0], 1)

#     return max(answer)