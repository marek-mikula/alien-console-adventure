# Alien console game

Very basic console game written in Java. This was my school work during second semester. The game is inspired by [Zork](https://en.wikipedia.org/wiki/Zork).

Author: [Marek Mikula](https://github.com/marek-mikula)
Version: 1.0.0

## Story

You are one of the main control technics on the Nostromo ship owned by space-mining company Weyland-Yutani. The Nostromo serves a as mother ship for miners who work on the planet LV178 not too far from Nostromo. There are two groups of miners, the first one is on the planet working, the second is resting on the mother ship. Every month there is a change between these two groups. The day were just yesterday. You are waking up after a long day shift on the mother ship Nostromo. Something is not right. You've been woken up by an emergency siren and a smell of burnt plastic. You should go to command bridge and find out what is going on.

## How to play

You can play the game only using predefined commands. To list all available commands, use `help` command.

## Available commands

| Command name | Signature | Description |
|---|---|---|
| Help | ```help``` | Lists all available commands. |
| Search | ```search``` | Searches the current room and shows list of available items. |
| Pick | ```pick {itemNumber}``` | Picks an item in the current room. |
| Drop | ```drop {itemNumber}``` | Drops an item from inventory. |
| Go | ```go {roomNumber OR "back"}``` | Moves Ellen to a different room. ```back``` keyword can be used. |
| Inventory | ```inventory``` | Lists all items in the inventory. |
| Interact | ```interact {itemNumber}``` | Interacts with an item in the current room. For example terminals, etc. |
| Map | ```map``` | Shows the map of the game, current room and possible exits. |
| Open | ```open {roomNumber} {itemNumber}``` | Opens the connection between rooms with an item from the inventory. |
