package furhatos.app.newskill.flow

import furhatos.app.newskill.flow.main.Idle
import furhatos.app.newskill.flow.main.Greeting
import furhatos.app.newskill.setting.DISTANCE_TO_ENGAGE
import furhatos.app.newskill.setting.MAX_NUMBER_OF_USERS
import furhatos.event.responses.ResponseFace
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.furhat.characters.Characters
import furhatos.flow.kotlin.state
import furhatos.flow.kotlin.users
import furhatos.flow.kotlin.voice.Voice

val Init: State = state {
    init {
        /** Set our default interaction parameters */
        //furhat.mask = "Anime_Legacy" To be resoleved late uneccesary
        users.setSimpleEngagementPolicy(DISTANCE_TO_ENGAGE, MAX_NUMBER_OF_USERS)
        furhat.voice = Voice("Danielle-Neural")
    }
    onEntry {
        /** start interaction */

        when {
            furhat.isVirtual() -> goto(Greeting) // Convenient to bypass the need for user when running Virtual Furhat
            users.hasAny() -> {
                furhat.attend(users.random)
                goto(Greeting)
            }
            else -> goto(Idle)
        }
    }

}
