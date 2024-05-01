package furhatos.app.newskill.flow.main

import furhatos.app.newskill.flow.Parent
import furhatos.flow.kotlin.*
import furhatos.nlu.common.Goodbye
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes

val Failurereset: State = state(Parent) {
    onEntry {
        furhat.ask("Do you want to try and search for another book?")
    }

    onReentry {
        furhat.listen()
    }
    onResponse<Yes> {
        furhat.say("Alright!")
        goto(Askauthor)
    }
    onResponse<No> {
        furhat.say("Alright!")
        goto(Seeyou)
    }

    onNoResponse {
        reentry()
    }

}

