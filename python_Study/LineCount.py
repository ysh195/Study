a = "Python is the best choice"
print(a.count('b')) # 해당 문자가 몇 개 포함인지 카운트
print(a.find('b')) # 내가 찾는 문자 중 가장 먼저 나온 문자의 위치. 하지만 해당 문자가 포함되어 있지 않다면 -1을 출력
print(a.index('b')) # find와 같은 기능. 근데 해당 문자가 포함되어 있지 않다면 그냥 오류가 나옴

print(",".join('abcd')) # 엑셀 textjoin 같은 기능이네
print(",".join(['a','b','c','d','e'])) # 배열 합치는 용도로도 가능.

b = "hi"
c = "HI"
print(b.upper() +" " + c.lower()) # 대문자화, 소문자화

d = "   istrip   "
print(d.lstrip())
print(d.rstrip())
print(d.strip())
# lstrip과 rstrip으로 양쪽 공백 지우기. L과 R이다. 그냥 strip 쓰면 양쪽 다 한 번에 없어짐. 그리고 맨 뒤에 () 필요

print(a.replace("Python","java")) # 특정 문자열 교체. 왼쪽이 교체될 문자, 오른쪽이 교체할 문자

print(a.split())
print(a.split('o'))
# textsplit 기능. 문자열을 쪼개서 배열로 만듦. 아무것도 안 쓰면 띄어쓰기를 기준으로 함.
