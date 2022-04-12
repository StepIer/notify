package com.example.notify.route

class NavigationRoute {
    companion object {
        const val ROUTE_MAIN = "route_main"
        const val ROUTE_TABLET = "route_tablet"

        const val ROUTE_NOTES = "route_notes"
        const val ROUTE_TODOLIST = "route_todo_list"
        const val ROUTE_CALENDAR = "route_calendar"
    }
}

class NavigationArguments {
    companion object {
        const val ARGUMENT_NOTE_ID = "noteId"
    }
}
