package furhatos.app.newskill.flow.main

import Book
import furhatos.app.newskill.flow.*
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes

val Asktitle: State = state(Parent) {
    onEntry {
        furhat.ask("So do you know the title of the book you are looking for?")
    }
    onReentry {
        furhat.listen()
    }

    onResponse<Book> {
        furhat.say("Alright")
        currentBook = it.intent.toString()
        currentAuthor = (libraryBooks.entries.find {it.value.lowercase() == currentBook}?.key).toString()
        goto(Confirmtitle)
    }

    onResponse<Yes> {
        furhat.ask("Perfect, what is it?")
        furhat.gesture(Gestures.Smile(1.0 * expValue, 1.0 + expValue))
        reentry()
        //goto(Confirmtitle)
    }
    onResponse<No> {
        furhat.say{
            +Gestures.ExpressSad(1.0 * expValue, 2.0 + expValue)
            +"I'm sorry"
            +"but there is a minimum amount of information I need"

        }
        goto(Failurereset)
    }

    onResponse {
        if (!(currentAuthor == "" )) {
            furhat.ask {
                +Gestures.Surprise(1.0 * expValue, 1.0 + expValue)
                +"I'm sorry I didn't quite understand you, did you mean the book"
                +libraryBooks[currentAuthor].toString()
                +" by the author"
                +currentAuthor
            }
            onResponse<Yes> {
                furhat.gesture(Gestures.Smile(1.0 * expValue, 1.0 + expValue))
                furhat.say("Alright")
                currentBook = libraryBooks[currentAuthor].toString()
                goto(Loanout)
            }
            onResponse<No> {
                furhat.gesture(Gestures.Surprise(1.0 * expValue, 1.0 + expValue))
                furhat.say("That is unfortunate, lets try again, what is the title of the book?")
                reentry()
            }

        }
        else {
            furhat.say("I'm sorry I didn't quite understand the title, could you repeat it?")
            furhat.gesture(Gestures.ExpressSad(1.0 * expValue, 1.0 + expValue))
            reentry()
        }
    }

    onNoResponse {
        reentry()
    }

}

