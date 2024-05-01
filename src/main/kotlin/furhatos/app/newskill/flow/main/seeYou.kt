package furhatos.app.newskill.flow.main

import furhatos.app.newskill.flow.Parent
import furhatos.flow.kotlin.*
import furhatos.nlu.common.Goodbye
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes

val Seeyou: State = state(Parent) {
    onEntry {
        furhat.ask("Thank you and goodbye")
    }

    onReentry {
        furhat.listen()
    }
    onResponse {
        furhat.say("Bye, bye!")
        goto(Idle)
    }

    onNoResponse {
        goto(Idle)
    }

}

