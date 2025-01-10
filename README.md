Dice Game: Roll to Win 12
Welcome to the Dice Game! In this game, you will roll up to 3 dice in an attempt to achieve a total sum of 12 in order to win. The game keeps track of your wins and losses, and you can keep playing until you choose to quit.

Program Logic
1. Initialization:
Upon starting the game, you will receive a welcome message and game instructions.
The program initializes variables to track the number of wins, losses, and the values of the dice.
2. Main Game Loop:
Each round begins by resetting the dice values and their roll statuses to their initial values.
You can choose to roll 1 to 3 dice. For each die, you will be prompted to choose a die to roll or quit the game by entering 'q'.
Valid input must be:
A number between 1 and 3 (indicating which die to roll).
The die must not have been rolled already.
The input is checked for validity, and any non-numeric or invalid input is handled gracefully.
Upon rolling a chosen die, the program generates a random number between 1 and 6 (simulating the roll of a die).
The chosen die's value is updated and added to the round's total sum.
The dice values, current sum, and win/loss count are displayed after each roll.
3. Round Outcome:
After all dice rolls (or if the player decides to quit):
If the total sum equals 12, the player wins.
If the total sum exceeds 12, the player loses.
Otherwise, the round is considered a tie.
The win/loss counters are updated accordingly.
4. End Game:
If the player opts to quit by entering 'q', the program will display the total number of wins and losses.
The game ends, and the program concludes.
