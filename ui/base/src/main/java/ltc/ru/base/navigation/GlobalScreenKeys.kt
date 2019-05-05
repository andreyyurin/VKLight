package ltc.ru.base.navigation

class GlobalScreenKeys {
    companion object {
        const val MY_TASKS_SCREEN = "MyTasksScreen"
        const val PEOPLE_TASKS_SCREEN = "PeopleTasksScreen"
        const val MORE_SCREEN = "MoreScreen"
        const val AUTHORIZATION_SCREEN = "AuthorizationScreen"

        fun getBottomNavScreenKeys(): List<String> =
            listOf(MY_TASKS_SCREEN, PEOPLE_TASKS_SCREEN, MORE_SCREEN, AUTHORIZATION_SCREEN)
    }
}