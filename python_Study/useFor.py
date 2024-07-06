test_list = ['one','two','three']
for i in test_list: # 향상된 for문 같은 느낌이네
    print(i)
    
a = [(1,2),(3,4),(5,6)]
for (first,last) in a:
    print(first+last)
    # 1+2 = 3 | 3+4 = 7 | 5+6 = 11
    # 튜플이라서 가능한 것
    
add = 0
for i in range(1,11):
    add += i
print(add)

scores = [90,25,67,45,80]
for number in range(len(scores)): # 스코어즈 배열의 숫자만큼 반복. 총 5개니까 range(len(scores) = range(0,4) 로 봐야 함
    if scores[number] < 60: # 이렇게 하니까 scores[1]부터 나옴
        continue # 점수가 60점 미만이면 뒤는 진행하지 않고 다음으로 넘어감
    print("%d번 학생 축하합니다. 합격입니다." % (number+1))
    
    
for i in range(2,10):
    for j in range(1,10):
        print(i*j, end=" ") # end= 을 붙이면 줄 나눔이 안 됨. 디폴트는 줄 나눔
    print('') # 이게 줄 나눔인가?
    
b = [1,2,3,4]
result1 = [] # null인데 연산이 되나?
for num in b:
    result1.append(num*3)
print(result1)

result2 = [num*3 for num in b if num%2 == 0] # b 배열을 돌리면서 num이 짝수면 x3을 해서 배열에 추가. for문이 엄청 간소함
print(result2)

result3 = [x*y for x in range(2,10) # 결과값을 먼저 쓰고, for문을 뒤에 쓰네
           for y in range(1,10)]
print(result3)
