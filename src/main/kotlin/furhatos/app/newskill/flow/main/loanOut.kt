package furhatos.app.newskill.flow.main

import furhatos.app.newskill.flow.Parent
import furhatos.app.newskill.flow.expValue
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes

val Loanout: State = state(Parent) {
    onEntry {
        furhat.gesture(Gestures.Smile(1.0 * expValue, 1.0 + expValue))
        furhat.ask("Do you want to loan the book out?")
    }
    onReentry {
        furhat.listen()
    }

    onResponse<Yes> {
        furhat.gesture(Gestures.BigSmile(1.0 * expValue, 1.0 + expValue))
        furhat.say("Alright, it will be ready for pickup at the desk in around five minutes!")
        goto(Seeyou)
    }
    onResponse<No> {
        goto(Failurereset)
    }

    onNoResponse {
        reentry()
    }

}

