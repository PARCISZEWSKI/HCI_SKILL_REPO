package furhatos.app.newskill.flow

import furhatos.app.newskill.flow.main.Greeting
import furhatos.app.newskill.flow.main.Idle
import furhatos.flow.kotlin.*
import furhatos.nlu.SimpleIntent
import furhatos.autobehavior.*
import furhatos.gestures.Gestures

val libraryBooks = mapOf( //Book Map
    "Ian Goodfellow" to "Deep Learning",
    "Gary Marcus" to "Rebooting AI",
    "Martin Ford" to "Architects of Intelligence",
)

var currentBook : String = ""
var currentAuthor : String = ""
var expValue : Int = 1

val Parent: State = state {
    onButton("Turn expressions on") {
        furhat.prominenceGesture = listOf(Gestures.BrowRaise)
        furhat.userSpeechStartGesture = listOf(Gestures.Smile)
        furhat.setDefaultMicroexpression(blinking = true, facialMovements= true, eyeMovements = true)
        expValue = 1
        goto(Greeting)
    }
    onButton("Turn expressions off") {
        furhat.prominenceGesture = listOf()
        furhat.userSpeechStartGesture = listOf()
        furhat.setDefaultMicroexpression(blinking = false, facialMovements= false, eyeMovements = false)
        expValue = 0
        goto(Greeting)
    }
    onButton("Sleep") {
        goto(Idle)
    }
    onButton("Wake up") {
        goto(Greeting)
    }
    onUserEnter(instant = true) {
        when { // "it" is the user that entered
            furhat.isAttendingUser -> furhat.glance(it) // Glance at new users entering
            !furhat.isAttendingUser -> furhat.attend(it) // Attend user if not attending anyone
        }
    }

    onUserLeave(instant = true) {
        when {
            !users.hasAny() -> { // last user left
                furhat.attendNobody()
                goto(Idle)
            }
            furhat.isAttending(it) -> furhat.attend(users.other) // current user left
            !furhat.isAttending(it) -> furhat.glance(it.head.location) // other user left, just glance
        }
    }

}
