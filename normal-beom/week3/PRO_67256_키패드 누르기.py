def solution(numbers, hand):
    left = [1, 4, 7]
    right = [3, 6, 9]
    center = [2, 5, 8, 0]
    result = ""
    left_index = 3 # 시작 키패드: '*'
    right_index = 3 # 시작 키패드: '#'
    center_flag = {"left" : False, "right" : False}
    
    for value in numbers:
        if value in left:
            left_index = left.index(value)
            result += "L"
            center_flag["left"] = False
        elif value in right:
            right_index = right.index(value)
            result += "R"
            center_flag["right"] = False
        else:
            center_index = center.index(value)

            left_sub = center_index - left_index
            if left_sub < 0: left_sub = -left_sub
            left_sub = left_sub if center_flag["left"] else left_sub + 1
            
            right_sub = center_index - right_index
            if right_sub < 0: right_sub = -right_sub
            right_sub = right_sub if center_flag["right"] else right_sub + 1
            
            flag = ""
            if left_sub == right_sub: flag = "Same"
            elif left_sub > right_sub: flag = "Right"
            else: flag = "Left"

            if flag == "Same": # 거리가 서로 같은 경우
                if hand == "right": # 오른손잡이
                    right_index = center_index
                    center_flag["right"] = True
                    result += "R"
                else: # 왼손잡이
                    left_index = center_index
                    center_flag["left"] = True
                    result += "L"
            elif flag == "Right": # 오른쪽이 더 가까운 경우
                right_index = center_index
                center_flag["right"] = True
                result += "R"
            else: # 왼쪽이 더 가까운 경우
                left_index = center_index
                center_flag["left"] = True
                result += "L"

    return result


## Point ##

#1. numbers 리스트의 값이 left 또는 right(리스트)에 속하는 경우
    #1.1. result에 "L" 또는 "R" 를 더해준다.
    #1.2. 왼쪽 또는 오른쪽 엄지 손가락의 위치(index)를 저장한다.
    #1.3. 왼쪽 또는 오른쪽 엄지 손가락의 위치가 center가 아님을 표기한다.

#2. numbers 리스트의 값(value)이 center에 속하는 경우
    #2.1. value를 통해 center index를 구하고,
    #2.2. left index까지 거리와 right index까지 거리를 구한다.
    #2.3. 엄지 손가락의 위치가 center가 아닐 경우 거리에 +1 한다.
    #2.4. 왼쪽, 오른쪽 엄지 손가락의 거리가 같을 경우
        #2.4.1. 사용자의 손잡이에 따라서 result에 "L" 또는 "R"을 더하고,
        #2.4.2. 해당 엄지 손가락의 center 여부를 True로 변경한다.
    #2.5. 엄지 손가락의 거리가 다른 경우
        #2.5.1. 더 가까운 쪽의 엄지 손가락을 움직여 result에 "L" 또는 "R"을 더하고,
        #2.5.2. 해당 엄지 손가락의 center 여부를 True로 변경한다.