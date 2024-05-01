package furhatos.app.newskill.flow.main

import furhatos.app.newskill.flow.Parent
import furhatos.app.newskill.flow.expValue
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.nlu.common.Goodbye
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes

val Seeyou: State = state(Parent) {
    onEntry {
        furhat.gesture(Gestures.BigSmile(1.0 * expValue, 1.0 + expValue))
        furhat.ask("Thank you and goodbye")
    }

    onReentry {
        furhat.listen()
    }
    onResponse {
        furhat.gesture(Gestures.BigSmile(1.0 * expValue, 1.0 + expValue))
        furhat.say("Bye, bye!")
        goto(Idle)
    }

    onNoResponse {
        goto(Idle)
    }

}

