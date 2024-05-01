package furhatos.app.newskill.flow.main

import furhatos.app.newskill.flow.Parent
import furhatos.app.newskill.flow.currentAuthor
import furhatos.app.newskill.flow.currentBook
import furhatos.app.newskill.flow.expValue
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.nlu.common.Greeting
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes
import kotlin.math.exp

val Greeting: State = state(Parent) {
    onEntry {
        currentAuthor = ""
        currentBook = ""
        furhat.listen()
    }

    onResponse {
        furhat.gesture(Gestures.BigSmile(1.0 * expValue, 1.0 + expValue))
        furhat.say {
            +"Hello!"
            +Gestures.BrowRaise(1.0 * expValue, 1.0 + expValue)
        }
        goto(Howhelp)

    }
    onNoResponse {
        //furhat.say("I'm trying to greet you, please reply")
        reentry()
    }
}

