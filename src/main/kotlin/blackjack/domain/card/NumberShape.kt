package blackjack.domain.card

enum class NumberShape(val value: Int, val display: String) {
    ACE(1, "A"),
    ONE(1, "1"),
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    JACK(10, "J"),
    QUEEN(10, "Q"),
    KING(10, "K"),
}
