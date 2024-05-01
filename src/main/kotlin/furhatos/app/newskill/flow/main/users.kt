package furhatos.app.newskill.flow.main

import furhatos.flow.kotlin.UserDataDelegate
import furhatos.records.User

var User.knowsAuthor : String? by UserDataDelegate()
var User.knowsTitle: String? by UserDataDelegate()