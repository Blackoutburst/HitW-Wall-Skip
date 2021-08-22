[![License](https://img.shields.io/github/license/Blackoutburst/HitW-Wall-Skip.svg)](LICENSE)
[![Release](https://img.shields.io/github/release/Blackoutburst/HitW-Wall-Skip.svg)](https://github.com/Blackoutburst/HitW-Wall-Skip/releases)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/afe6e173a8cd4c35b2f8aa50a8e98abc)](https://www.codacy.com/gh/Blackoutburst/HitW-Wall-Skip/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Blackoutburst/HitW-Wall-Skip&amp;utm_campaign=Badge_Grade)

# HitW-Wall-Skip
A simple bot to skip walls during the qualification stage of Hole in the Wall on Hypixel.

## Can i get banned from using it
I did some test and didn't get banned but I can't grantee anything use at your own risk i'm not responsible for any ban using this.

## Is that cheating
No, unless for you fixing a game glitch is cheating.

## WHY
Hole in the Wall on Hypixel suffer from a glitch only problematic during the qualification round.

This issue affects the scores of high-level players, so this mod is used to fix this issue.

If you don't peek through glass you are not concerned by this and don't need this.

## The issue
When playing after completing a wall you can see the preview of the next wall through glass but if you are the one generating the walls (the fastest player) sometimes the preview show your current wall instead of the next one leading to mistake when building due to incorrect wall memorisation.

To overcome this issue, this mod make a player a bot account skipping walls during all the round, this make the server generate all walls before actual player build them making the preview show the correct next wall since the bot is now in the case of the fastest player.

## How to use
[Video explanation](https://www.youtube.com/watch?v=s1S8jGpmLeI)

0) This mod use [forge 1.8.9](https://files.minecraftforge.net/net/minecraftforge/forge/index_1.8.9.html) to work.
1) Launch a separated game with another account using this mod.
2) With your main account (the one you play with) party the bot account and queue a game of Hole in the Wall.
3) When entering the hole in the wall lobby on the bot account open the inventory and that it.

Why the inventory yo may ask the reason is: the inventory prevent the game from pausing itself when the game window is no longer focused.

If the game is paused or the chat is open the player can't do action but for some reason the player can still perform action while the inventory is open, this is why you need to open the inventory and not the chat or pause the game.

## Current problem
The game pause itself when you re queue since the windows is not focused anymore so you need to go on the bot account unpause the game and re open the inventory.

Could fix every problem by making every action server side using packet but eh better do extra steps than getting banned
