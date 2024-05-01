package furhatos.app.newskill.flow.main

import furhatos.app.newskill.flow.Parent
import furhatos.app.newskill.flow.expValue
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.nlu.common.Goodbye
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes

val Failurereset: State = state(Parent) {
    onEntry {
        furhat.gesture(Gestures.Smile(1.0 * expValue, 1.0 + expValue))
        furhat.ask("Do you want to try and search for another book?")
    }

    onReentry {
        furhat.listen()
    }
    onResponse<Yes> {
        furhat.gesture(Gestures.BigSmile(1.0 * expValue, 1.0 + expValue))
        furhat.say("Alright!")
        goto(Askauthor)
    }
    onResponse<No> {
        furhat.gesture(Gestures.BigSmile(1.0 * expValue, 1.0 + expValue))
        furhat.say("Alright!")
        goto(Seeyou)
    }

    onNoResponse {
        reentry()
    }

}

