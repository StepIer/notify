package com.example.notify.route

class NavigationRoute {
    companion object {
        const val ROUTE_MAIN = "route_main"
        const val ROUTE_TABLET = "route_tablet"
        const val ROUTE_CAMERA = "route_camera"
        const val ROUTE_ENTRY = "route_entry"
    }
}

class NavigationArguments {
    companion object {
        const val ARGUMENT_NOTE_ID = "noteId"
        const val ARGUMENT_PHOTO_URI = "photoUri"
        const val ARGUMENT_WORKLIST = "worklist"
    }
}
