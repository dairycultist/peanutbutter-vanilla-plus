# Peanutbutter (Vanilla+) [StationAPI]

Get it, 'cuz it's a vanilla+ mod and it's called peanutbutter, which you add to vanilla icecream? I thought it was witty.

## Core Beliefs
- good food should be made from bad food/non-food
- wood and stone tools shouldn't be abandoned in ten seconds because iron is so easy to get
  - I didn't like how in the first 5 minutes of the game, you could immediately jump right from wood to stone to iron
    tools without even going underground.
- Stripmining is just not fun
- The game should be coherent

## Implemented

> [!IMPORTANT]  
> Implemented features may be WIP and subject to change.

### New, useful ores

**Copper**
- Replaces stone
- Slows down early game progression and makes each tool stage more rewarding
(you need to actually find a cave to get copper, then go deeper in the cave for iron)

**Hematite**
- Red ingot
- Found in the nether
- Sidegrade (not upgrade) from diamond, better for combat since nether is combat-focused

### New structures

**Overworld**
- Pyramids (plains and desert)
- Ruins (procedural, every one is different!)

**Nether**
- Pyramid

### New mobs

- Cockatrice
  - Spawn in the nether
  - Drop golden feathers
  - Lay golden eggs
- Swamp Monster
  - Challenging monster

### Tweaks

- Iron spawns lower (no longer at the surface)
- Mobs now guaranteed to drop at least 1 of their item

### Other

- New decoration blocks
  - Stone bricks
  - Carved bone
  - Copper block
- New crops/food
  - Tomato (stacks to 8, heals 1 heart)
    - Tomato seeds
    - Tomato crop
  - Curry (TODO shapeless craft with 1 sugar, 1 mushroom, 1 tomato, 1 bowl)
  - Muffin (8 wheat surrounding 1 sugar)
- Ectogel
  - Dropped by ghasts (12-32)
  - You run faster on it

### Planned? (Literally all my ideas good or bad)
- Quicksilver
  - The ore has streaks in it like nether quartz
  - Found in the nether
  - Sidegrade (not upgrade) from diamond, mines the fastest but has mid-range durability and the mining level of wood
- Hematite lance
  - hi dmg + reach
  - hematite top right, two sticks diagonal, and two golden feathers by the hematite
- Hematite hammer
  - hi dmg + knockback
- Wings
  - made with golden feathers
  - end game gear
  - gives you a double jump
  - not as busted as the elytra but just convenient for exploring/building
- new music disc(s)
- maracas
- baubles
  - bauble shards, which you need 9 of to craft a bauble
  - bauble slots (like 4 or something?)
  - Chest bauble (increases your inventory space by 9)
  - Jump bauble (gives you an extra air jump)
- new enemies
  - stone golem
  - goblin
- uncraftable weapons and armor
  - found in structures
  - throwable dynamite
- boss called the "Undead Queen," (summoned by placing a nether crown from a structure on top of a T of gold)
  - gives a use to gold
  - drops a rare/useful item
  - idk where the nether crown will be found
- "ghast nursery" structure that spawns baby ghasts
- overworld structure (underground, like strongholds) made of blocks (called "???") that require hematite to be able to break into, so there's no way to go into them until after you reach the nether
- add new achievements
  - "Doom the nether" / defeat the nether queen
  - "This is my jam" / collect all the music discs
  - other achievements that guide the player through new content
  - [code reference](https://github.com/telvarost/WhatAreYouScoring-StationAPI/blob/main/src%2Fmain%2Fjava%2Fcom%2Fgithub%2Ftelvarost%2Fwhatareyouscoring%2Fevents%2Finit%2FAchievementListener.java)

maybe update project dependencies ([reference](https://github.com/telvarost/AmbientOverride-StationAPI/commit/8e2b9abc1d68de11ebf130302313078292ce8a1d)) 

<img height="100" src="https://static.wikia.nocookie.net/stardew-valley-minecraft-datapack/images/9/96/Music_disc_concernedapewinternocturneofice.png">
<img height="100" src="https://static.wikia.nocookie.net/shivaxis-rlcraft/images/c/cc/Iron_Hammer_%28Better_Survival%29.png">

### Sound sources
https://www.videvo.net/sound-effect/dove-pigeon-coo-pe912203/242526/#rs=audio-download
https://www.soundsnap.com/wind_chimes_24_wav (audacity -> echo -> reverb -> fade out)