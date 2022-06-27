# kotlin-blackjack

## 2단계 - 블랙잭

### 요구사항 정리
- 블랙잭 게임을 변형한 프로그램을 구현한다. 블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.
- 카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다.
- 게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며, 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다. 21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다.

### 도메인 용어 공부
- 참고: [위키](https://ko.wikipedia.org/wiki/%ED%94%8C%EB%A0%88%EC%9E%89_%EC%B9%B4%EB%93%9C), [용어 정리](https://blog.naver.com/lmxmxmxl/222135922821)
- 네이밍은 위키 기준으로
- 버스트(bust): 카드 합이 21 초과하는 경우 배팅한 금액을 모두 잃음
- 힛(hit) : 카드 2장 받을 후에 더 받는 것
- 스테이(stay) : 카드를 그만 받는 것
- 푸시(push) : 카드 합이 같은 경우. 비김

### 대략적인 구조 설계
#### 일단 클래스 부터 뽑아보자
- ```카드```(무늬와 끗수)
- ```무늬``` 4개와 ```끗수``` 13개는 enum
- 카드는 무늬와 끗수를 크로스 조인하여 총 52개
- 카드전체를 담고 한장씩 뽑을 수 있는 ```덱```
- ```플레이어``` 는 입력을 받아 행동을 정할 수 있다. 
- 점수는 끗수에 의해 정해지니 enum 에 포함시킨다. 에이스 일때만 예외 처리?

#### 클래스 별 기능 정의
- ```카드(Card)```: 단순히 무늬와 끗수만을 가짐
- ```무늬(Suit)```: 출력을 위한 symbol 
- ```끗수(Denomination)```: 끗수에 따른 점수
  - 점수 계산 기능
- ```덱(Deck)```: 카드 인스턴스 52개를 미리 생성해 저장해놓는다
  - 초기화(객체 미리 생성)
  - 셔플 기능
  - 한장씩 카드 peek? 큐나 스택에서 꺼내서
- ```플레이어(Player)```: 이름, 소지 카드, 상태 를 가진다
    - 입력에 따른 상태 변화: y -> hit, n -> stay
    - 카드 추가 기능
- 상태 변화 시나리오 (카드를 받거나 입력을 받을 때 마다 상태 변화 가능) 
  - hit 로 초기화 
  - hit -> stay 로 바뀔때까지 카드 계속 추가
  - 그러다가 21 넘으면 hit -> bust 되고 그만

## 3단계 - 블랙잭(딜러)

### 요구사항 정리
- 딜러는 처음에 받은 2장의 합계가 16이하이면 반드시 1장의 카드를 추가로 받아야 하고, 17점 이상이면 추가로 받을 수 없다.
- 딜러가 21을 초과하면 그 시점까지 남아 있던 플레이어들은 가지고 있는 패에 상관 없이 승리한다.
- 게임을 완료한 후 각 플레이어별로 승패를 출력한다.

```text
게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)
pobi,jason

딜러와 pobi, jason에게 2장의 나누었습니다.
딜러: 3다이아몬드, 9클로버
pobi카드: 2하트, 8스페이드
jason카드: 7클로버, K스페이드

pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
y
pobi카드: 2하트, 8스페이드, A클로버
pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason은 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason카드: 7클로버, K스페이드

딜러는 16이하라 한장의 카드를 더 받았습니다.

딜러 카드: 3다이아몬드, 9클로버, 8다이아몬드 - 결과: 20
pobi카드: 2하트, 8스페이드, A클로버 - 결과: 21
jason카드: 7클로버, K스페이드 - 결과: 17

## 최종 승패
딜러: 1승 1패
pobi: 승 
jason: 패
```
