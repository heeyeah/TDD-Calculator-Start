

## TDD로 간단한 계산기 만들기를 위한 Fill Codes in Empty Space!


#### 생각생각
**TDD로 개발하는 방식은 Test Code를 먼저 작성한 후 Develop!** 그래서 Operator, Parser, Printer 테스트케이스를 각각 만들었다.
각각 만든 테스트 케이스에서 필요한 메소드와 return 값을 정한 후 작성!


#### 실행실행
- Operator, Parser, Printer class 생성

<br/>

***

## TDD로 간단한 계산기 만들기

##### 요구사항 1단계
 - 계산은 한번 할 수 있어야한다.
 
 - "+", "-", "*", "/"를 계산 할 수 있어야 한다.
 
 - 사용자 입력에 대한 결과 값을 print 한다.
    - 입력: 1+2-1*2
    - 출력: 4
    
 - 곱셈, 나눗셈에 대한 처리에 상관없이 순서대로 계산한다.
 
 - 나눗셈의 값은 정수값으로 표현한다.
 
 
##### 요구사항 2단계

 - 4칙 연산 이외에 다른 연산에 대한 에러 처리
     - "NaN" 출력
     
 - 잘못된 연산에 대한 에러 처리
    -  예 
        - 1+-2  (x)
        - +1-2  (x)
        - 1-2-  (x)
    - "NaN" 출력
    
 - 계산 과정을 print
    - 예 :1+2-1*2
    - 1 + 2 = 3
    - 3 - 1 = 2
    - 2 * 2 = 4
    - 결과 값: 4
    
  - OOP(Object orient Programing)로 최적화