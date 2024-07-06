number = 3
day = "three"
print("I eat %d apples. so I was sick for %s days" % (number,day))
# 한 번에 여러 개의 문자열 중간 삽입도 가능. 타입을 자유롭게 변환 가능하지만 %s가 만능임


print("%10s" % "hi")
# 길이가 10개인 문자열을 생성하고, 그 공간에 들어가는 문자는 오른쪽 정렬해라
# 문자열 10개가 생긴다 > 빈 공간이 있으면 오른쪽 정렬하여 맨 오른쪽에서부터 2자리를 hi로 채운다

print("%-10sJane." % 'hi')
# 길이가 10개인 문자열을 생성하고, 그 공간에 들어가는 문자는 왼쪽 정렬해라.
# 문자열 10개와 Jane이 생긴다. (= 총 14자리의 문자열이 생긴다) > 빈 공간이 있으면 왼쪽 정렬하여 맨 왼쪽에서부터 2자리를 hi로 채운다

print("%0.4f" % 3.1234567890)
# 소숫점 4번째자리까지만 표시

print("I eat {0} apples".format(3))
print("I eat {0} apples".format("five"))
print("I eat {0} apples. so I was sick for {1} days".format(number, day))
# .format을 이용한 중간 삽입
# 다수의 삽입도 가능하고, {} 안에 숫자는 들어갈 순서인 듯

print("I eat {number} apples. so I was sick for {day} days".format(number=10, day=3))
# 순서 대신 변수명을 쓰면, 순서에 상관없이 변수명으로 찾아감. 순서 입력과 변수 입력 혼용도 가능.

print("{0:<10}".format("hi"))
print("{0:>10}".format("hi"))
print("{0:^10}".format("hi"))
# <, > 방향으로 정렬 방향 설정. ^는 가운데 정렬.
# 남는 공간은 모두 빈칸으로 채움

print("{0:!<10}".format("hi"))
print("{0:=<10}".format("hi"))
# :와 <, >, ^ 사이에 다른 문자나 기호를 넣으면 공백을 그걸로 채움

y = 5.123456789
print("{0:0.4f}".format(y))
print("{0:10.4f}".format(y))
# 소숫점은 이런 식으로 표현

print("{{A}}".format())
# {}를 표현하고 싶으면 {{}}

name = "홍길동"
age = 30
# print(f'나의 이름은 {name}입니다. 나이는 {age}입니다.')
# .format하기 귀찮으면 앞에 f 붙여도 되는데, 나는 파이썬 버전이 안 맞는듯?


