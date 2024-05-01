package furhatos.app.newskill.flow.main

import furhatos.app.newskill.flow.Parent
import furhatos.app.newskill.flow.currentAuthor
import furhatos.app.newskill.flow.currentBook
import furhatos.app.newskill.flow.expValue
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes

val Confirmtitle: State = state(Parent) {
    onEntry {
        furhat.ask{
            +"So, just to confirm one last time "
            +Gestures.BrowFrown(1.0 * expValue, 1.0 * expValue)
            +"the title you are looking for is "
            +currentBook
            +" and the author is "
            +Gestures.BrowRaise(1.0 * expValue, 1.0 * expValue)
            +currentAuthor
            +"?"}
    }
    onReentry {
        furhat.listen()
    }

    onResponse<Yes> {
        furhat.say("Perfect!")
        goto(Loanout)
    }
    onResponse<No> {
        furhat.say("Oh alright then let's try again!")
        goto(Askauthor)
    }

    onNoResponse {
        reentry()
    }

}

