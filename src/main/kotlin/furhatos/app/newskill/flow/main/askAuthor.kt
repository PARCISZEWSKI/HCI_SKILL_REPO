package furhatos.app.newskill.flow.main

import Author
import furhatos.app.newskill.flow.Parent
import furhatos.app.newskill.flow.currentAuthor
import furhatos.app.newskill.flow.expValue
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes


val Askauthor: State = state(Parent) {
    onEntry {
        furhat.gesture(Gestures.BrowRaise(1.0 * expValue, 1.0 + expValue))
        furhat.ask("Do you know the author of the title you are looking for?")
    }
    onReentry {
        furhat.listen()
    }

    onResponse<Author>{
        furhat.say{
            +"Perfect, "
            +it.intent.toString()
            +" has some books available"

        }
        currentAuthor = it.intent.toString()
        //println(currentAuthor)
        goto(Asktitle)
    }
    onResponse<No> {
        furhat.say("Oh alright, I can also search by title!")
        furhat.gesture(Gestures.Surprise(1.0 * expValue, 1.0 + expValue))
        goto(Asktitle)
    }
    onResponse<Yes> {
        furhat.say("What is the authors name?")
        furhat.gesture(Gestures.Smile(1.0 * expValue, 1.0 + expValue))
        reentry()
    }

    onResponse {
        furhat.gesture(Gestures.Surprise(1.0 * expValue, 1.0 + expValue))
        furhat.say("Sorry we don´t seem to have this author!")
        goto(reentry())
    }

    onNoResponse {
        reentry()
    }

}

