# Furhat Hi-Fi bot
## How to use
There is only a single skill file provided, in the sdk you need to run the skill, after running the skill:
- Launch the web interface
- You need to select the AnimePink face yourself as I didn't manage to make it autoselect, there is some issue with legacy masks.
- In the web interface open the wizarding tab
- The bot is already waiting for you to respond
 ![image](https://github.com/PARCISZEWSKI/HCI_SKILL_REPO/assets/16108674/9092f8ec-5058-41fa-9b57-a947022d4ec5)
- There are four buttons that you can press here as seen on the image above
  - You can turn off the expressions, this also makes the bot go to its initial state
  - You can turn on the expressions, this also makes the bot go to its initial state
  - You can turn the bot off
  - You can turn the bot on
- All these functions happen in real time, and restart the bot to it's initial state
## Interacting with the bot
- The bot will wait for you to say hello or another greeting.
- The conversation starts, here are the books and authors that the bot can detect:
```
val libraryBooks = mapOf( //Book Map
    "Ian Goodfellow" to "Deep Learning",
    "Gary Marcus" to "Rebooting AI",
    "Martin Ford" to "Architects of Intelligence",
)
```

### _Made by: Group 23 (P. A. Arciszewski (2813638), Carlos Tam (2804219), Omar Rampado (2817231), Sander Bindels (2589706))_
