# Peanutbutter (Vanilla+) [StationAPI]

## Core Principles
- good food should be made from bad food/non-food
- wood and stone tools shouldn't be abandoned in ten seconds because iron is so easy to get
  - I didn't like how in the first 5 minutes of the game, you could immediately jump right from wood to stone to iron
    tools without even going underground.
- Stripmining is just not fun
- The game should be coherent

minecraft mod that leans into the light medieval fantasy elements of Minecraft + loneliness (no other humans, they're all zombies at best), fleshing out existing mechanics without feeling bloated

new structures, new mobs (types of zombie, aggressive wildlife like wasps, piranhas, sharks), new blocks, not really new items tho

Minecraft+

## Implemented

> [!IMPORTANT]  
> Implemented features may be WIP and subject to change.

### Copper
- Replaces stone
- Slows down early game progression and makes each tool stage more rewarding
(you need to actually find a cave to get copper, then go deeper in the cave for iron)

### New mobs

- Cockatrice
  - Spawn in the nether
  - Drop golden feathers
  - Lay golden eggs
- Mummy
  - Spawns during the day in the desert
  - Zombie equivalent

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

## Planned?

Literally all my ideas good or bad

- Wings
  - made with golden feathers
  - end game gear
  - gives you a double jump
  - not as busted as the elytra but just convenient for exploring/building
- new music disc(s)
- new enemies
  - stone golem
  - goblin
- uncraftable weapons and armor
  - found in structures or as mob drops
  - throwable dynamite
- add new achievements that guide the player through new content
  - [code reference](https://github.com/telvarost/WhatAreYouScoring-StationAPI/blob/main/src%2Fmain%2Fjava%2Fcom%2Fgithub%2Ftelvarost%2Fwhatareyouscoring%2Fevents%2Finit%2FAchievementListener.java)

maybe update project dependencies ([reference](https://github.com/telvarost/AmbientOverride-StationAPI/commit/8e2b9abc1d68de11ebf130302313078292ce8a1d)) 

<img height="100" src="https://static.wikia.nocookie.net/stardew-valley-minecraft-datapack/images/9/96/Music_disc_concernedapewinternocturneofice.png">
<img height="100" src="https://static.wikia.nocookie.net/shivaxis-rlcraft/images/c/cc/Iron_Hammer_%28Better_Survival%29.png">

### Sound sources
https://www.videvo.net/sound-effect/dove-pigeon-coo-pe912203/242526/#rs=audio-download
https://www.soundsnap.com/wind_chimes_24_wav (audacity -> echo -> reverb -> fade out)
