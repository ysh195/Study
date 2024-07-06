s1 = set([1,2,3])
l1 = list(s1)
t1 = tuple(s1)
print(s1)
print(l1)
print(t1)

s2 = set("hello") # 역순에 중복 제거인가?
print(s2) # 역순이 아니라 순서가 없다고 하네. 그리고 순서가 없으니 인덱스 같은 것이 불가함. 그래서 인덱스를 쓰고 싶으면 리스트나 튜플로 전환해야 함

s1 = set([1,2,3,4,5,6])
s2 = set([4,5,6,7,8,9])
print(s1&s2) # 교집합
print(s1.intersection(s2)) # 이것도 교집합 만드는 함수

print(s1|s2)
print(s1.union(s2)) # 합집합

print(s1-s2)
print(s2-s1) # 차집합

s1.add(7) # 1개 추가
s1.update(8,9,10) # 여러 개 추가

s1.remove(3) # 특정값 제거
