package furhatos.app.newskill.flow.main

import furhatos.app.newskill.flow.Parent
import furhatos.flow.kotlin.*
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes

val Loanout: State = state(Parent) {
    onEntry {
        furhat.ask("Do you want to loan the book out?")
    }
    onReentry {
        furhat.listen()
    }

    onResponse<Yes> {
        furhat.say("Alright, it will be ready for pickup at the desk in 5 mintues!")
        goto(Seeyou)
    }
    onResponse<No> {
        goto(Failurereset)
    }

    onNoResponse {
        reentry()
    }

}

