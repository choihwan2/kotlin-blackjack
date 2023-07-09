# kotlin-blackjack

블랙잭 게임을 변형한 프로그램을 구현한다. 블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.

카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다.
게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며, 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다. 21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다.

요구사항
카드(Card)
[X] A 는 먼저 1의 값을 가진다.
[X] K,Q,J 은 10 으로 계산한다.
[X] 카드는 숫자와 문양을 가진다.

카드뭉치(Deck)
[X] 카드뭉치의 카드는 총 52장이다.
[X] 카드 뭉치는 처음에 하트,다이아몬드,스페이드,클로버로 한 문양당 13(A~9, K,Q,J)장으로 이루어져 있다.

플레이어(Player)
[] 21을 넘게되면 카드를 더 받을 수 없다.
[] 카드를 받게되면 그 사람이 갖고 있는 카드를 보여준다.
[] 카드를 처음부터 받지 않으면 그 사람이 갖고 있는 카드를 보여준다.
[] 카드를 받고나서 카드를 받지 않으면 그 사람이 갖고 있는 카드를 보여주지 않는다.
[] A 카드의 개수를 가지고 있어야한다.
[] 플레이어는 카드를 받을 수 있다.

블랙잭게임(BlackJack)
[] 게임 참가자의 이름을 문자열로 받을 수 있다.
[] 게임을 시작하면 플레이어는 두장의 카드를 지급 받는다.
[] 플레이어는 카드를 더 받거나 그만 받을 수 있다.
[] 마지막에 결과값을 보여주어야한다.
[] A 카드는 11이 될수도 있다.

