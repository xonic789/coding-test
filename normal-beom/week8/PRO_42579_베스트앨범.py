## Point ##
#1. 두 가지 구조체 생성
    #1) 장르별 재생된 횟수의 총합 구조체 ( play_sum )
        # { 장르: 재생 횟수 총합 }
    #2) 장르별 재생된 횟수 ( play_count )
        # { 장르: [ index, 재생 횟수 ] }
#2. 가장 많이 재생된 장르 구하기
#3. 각 장르 순서별 plays의 index 추출 ( 최대 2개 )

def solution(genres, plays):
    length = len(genres)
    answer = []
    play_sum = {genre : 0 for genre in genres}
    play_count = {genre : [] for genre in genres}

    for i in range(length):
        play_sum[genres[i]] += plays[i]
        play_count[genres[i]].append([i, plays[i]])

    play_sum = sorted(play_sum.items(), key = lambda x: x[1], reverse = True)
    
    for genre in play_sum:
        size = len(play_count[genre[0]])
        play_count[genre[0]].sort(key=lambda x: x[1], reverse = True)
        for i in range(size if size < 3 else 2):
            answer.append(play_count[genre[0]][i][0])
    return answer