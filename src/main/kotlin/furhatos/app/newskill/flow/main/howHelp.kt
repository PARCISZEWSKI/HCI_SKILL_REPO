package furhatos.app.newskill.flow.main

import furhatos.app.newskill.flow.Parent
import furhatos.app.newskill.flow.expValue
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.nlu.SimpleIntent
val bookLook = SimpleIntent("Looking for a book", "Loan out a book", "Searching for a book", "I need a book", "Book")

val Howhelp: State = state(Parent) {
    onEntry {
        furhat.gesture(Gestures.BrowRaise(1.0 * expValue, 1.0 + expValue))
        furhat.ask("How can I help you today?")
    }
    onReentry {
        furhat.listen()
    }
    onResponse(bookLook) {
        furhat.say{
            +"Ok, perfect"
            +Gestures.BigSmile(1.0 * expValue, 1.0 + expValue)
            +" let me ask you some questions to help you find it!"
            +Gestures.Smile(1.0 * expValue, 1.0 + expValue)
        }
        goto(Askauthor)
    }

    onResponse {
        furhat.say{
            +"Sorry I can only help you with looking for a book"
        }
        reentry()
    }

    onNoResponse {
        reentry()
    }

}

