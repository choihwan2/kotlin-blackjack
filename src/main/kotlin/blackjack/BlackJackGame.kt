package blackjack

import blackjack.domain.CardDeck
import blackjack.domain.Cards
import blackjack.domain.Player
import blackjack.domain.Players
import blackjack.view.InputView
import blackjack.view.ResultView

class BlackJackGame {
    fun play(cardDeck: CardDeck) {
        val players = getPlayers(cardDeck)
        printCurrentState(players)
        hitCard(players, cardDeck)
        players.forEach(ResultView::printResult)
    }

    private fun getPlayers(cardDeck: CardDeck): List<Player> {
        ResultView.printMessage(ResultView.Message.REQUEST_PLAYERS)
        val names: List<String> = InputView.requestStringList()

        return Players(names, cardDeck).players
    }

    private fun printCurrentState(players: List<Player>) {
        ResultView.newLine()
        ResultView.printHit(players.map { it.name })

        players.forEach(ResultView::printState)

        ResultView.newLine()
    }

    private fun hitCard(players: List<Player>, cardDeck: CardDeck) {
        players.forEach { player ->
            hitCard(player, cardDeck)
        }

        ResultView.newLine()
    }

    private fun hitCard(player: Player, cardDeck: CardDeck) {
        while (!player.isBust()) {
            ResultView.printMessage(player.name, ResultView.Message.REQUEST_HIT)
            val isHit = InputView.requestConfirm()

            if (!isHit) {
                break
            }

            val card = cardDeck.draw()
            player.hit(card)

            ResultView.printState(player)
        }

        if (player.isBust()) {
            ResultView.printMessage(player.name, ResultView.Message.BUST)
            ResultView.newLine()
        }
    }

}

fun main() {
    BlackJackGame().play(CardDeck.shuffle())
}