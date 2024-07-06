# 홍길동의 과목별 점수는 다음과 같다. 국어 : 80, 영어 : 75, 수학 :55. 평균 점수를 구하라.
hong_score = {'lang' : 80, 'eng' : 75, 'math' : 55}
total=sum(hong_score.values())
avg = total/len(hong_score)
print(avg)

# 13이 홀수인지 짝수인지 판별할 수 있는 방법
num13 = 13%2
print(num13 == 1)

# 홍길동의 주민등록번호는 881120-1068234이다. 주민등록번호를 연원일(yyyymmdd) 부분과 그 뒤의 숫자로 나누어보자.
pin = "881120-1068234"
divider = pin.index("-")
front = pin[:divider]
back = pin[(divider+1):]
print(front)
print(back)

# 주민번호에서 뒷자리의 맨 첫 번째 숫자는 성별을 나타낸다. 성별을 나타내는 숫자를 출력해보자.
print(pin[7]) # 숫자가 0부터 시작하니까

# 문자열 a:b:c:d가 있다. replace를 이용하여 :를 #으로 바꿔서 출력하라
textA = "a:b:c:d"
textB = textA.replace(":","#")
print(textB)

# [1,3,5,4,2] 리스트를 [5,4,3,2,1]로 바꾸자
listA = [1,3,5,4,2]
listA.sort()
listA.reverse()
print(listA)
