# Furhat Hi-Fi bot version 0.1
## State of the estate
This is the initial Hi-Fi version. Please read the readme and, open new issues on the issues tab of this repo when you encounter problems or you have suggestions. This will streamline possible bug fixing for me so that I can progress quickly with updating the robot. You can find the codeless version of the skill file in the releases section on github to the right.
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
    "Melanie Mitchell"   to "Artificial Intelligence: A Guide for Thinking Humans",
    "Ian Goodfellow" to "Deep Learning",
    "Brian Christian" to "The Alignment Problem",
    "Max Tegmark" to "Life 3.0",
    "Raymond Kurzweil" to "The Singularity Is Near",
    "Kai-Fu Lee" to "AI Superpowers",
    "Kate Crawford" to "The Atlas of AI",
    "Gary Marcus" to "Rebooting AI",
    "Hubert Dreyfus" to "What Computers Can't Do",
    "Martin Ford" to "Architects of Intelligence",
)
```
- Other then this I would recommend going in blind so I can get the best feedback possible on improvements and what conflicts we can forsee.


## Other things of note
- The unexpressive bot is much better, it has no expressions now

## To do
- Testing and bugfixing
- More features
### _Made by: Group 23 (P. A. Arciszewski (2813638), Carlos Tam (2804219), Omar Rampado (2817231), Sander Bindels (2589706))_
