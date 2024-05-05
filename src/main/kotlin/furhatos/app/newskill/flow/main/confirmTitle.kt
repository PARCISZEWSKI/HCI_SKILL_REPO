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
        //furhat.gesture(Gestures.Smile(1.0 * expValue, 5.0 * expValue))
        furhat.ask{
            +"So, just to confirm one last time "
            +"the title you are looking for is "
            +currentBook
            +" and the author is "
            +currentAuthor
            +"?"}
    }
    onReentry {
        furhat.listen()
    }

    onResponse<Yes> {
        furhat.gesture(Gestures.Smile(1.0 * expValue, 1.0 + expValue))
        furhat.say("Perfect!")
        goto(Loanout)
    }
    onResponse<No> {
        furhat.gesture(Gestures.Surprise(1.0 * expValue, 1.0 + expValue))
        furhat.say("Oh alright then let's try again!")
        goto(Askauthor)
    }

    onNoResponse {
        reentry()
    }

}

