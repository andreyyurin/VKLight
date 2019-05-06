package ltc.ru.base.navigation

class GlobalScreenKeys {
    companion object {
        const val FEED_SCREEN = "FeedScreen"
        const val AUTHORIZATION_SCREEN = "AuthorizationScreen"

        fun getBottomNavScreenKeys(): List<String> =
            listOf(FEED_SCREEN, AUTHORIZATION_SCREEN)
    }
}