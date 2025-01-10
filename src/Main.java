import java.util.Scanner;
import java.util.Random;

/**
 * The program is a game where the player will roll 3 dice to get a total sum of 12 in order to win.
 * The player has to roll 1-3 dice and try to reach a sum of 12.
 * The game continues until the player decides to quit by entering 'q'.
 * The number of wins and losses are tracked and displayed at the end of the game.
 *
 * --- Program Logic ---
 *
 * 1. **Initialization**:
 *    - Display a welcome message and instructions for the game.
 *    - Initialize variables to track wins, losses, and dice values.
 *
 * 2. **Main Game Loop**:
 *    - Begin each round:
 *      a. Set all dice values and their rolled statuses to initial values.
 *      b. Display the start of a new round.
 *    - Allow the player to roll up to three dice:
 *      a. Prompt the player to choose a die to roll or quit the game by entering "q".
 *      b. Validate input to ensure:
 *         - The choice is one of the valid dice (1, 2, or 3).
 *         - The chosen die has not already been rolled.
 *         - Non-numeric or invalid input is handled gracefully.
 *      c. Simulate rolling the chosen die using a random number generator.
 *      d. Update the chosen die's value and add it to the round's sum.
 *      e. Display the dice values, current sum, wins, and losses.
 *
 * 3. **Determine Round Outcome**:
 *    - After all dice rolls, check the total sum:
 *      a. If the sum equals 12, the player wins.
 *      b. If the sum exceeds 12, the player loses.
 *      c. Otherwise, it is a tie (no win/loss).
 *    - Update win/loss counters and display the outcome of the round.
 *
 * 4. **End Game**:
 *    - If the player chooses to quit, display the total wins and losses.
 *    - End the program.
 *
 * --- Additional Notes ---
 * - Random numbers between 1 and 6 simulate dice rolls.
 * - Input validation ensures the game runs smoothly without crashing due to errors.
 * - The game is modular and could be extended with additional features, such as allowing more rounds or custom target sums.
 *
 * 1.
 *
 * @author Tauhid Mahmud (taumah-4)
 */
class Main {
     // Constant strings for game messages
    static final String GAME_START = "Welcome to dice game 12. You must roll 1-3 dice and try to get the sum of 12 ...\n";
    static final String CHOOSE_DICE = "Enter which dice you want to roll [1,2,3] (exit with q):";
    static final String ROUND_WON = "You won!!";
    static final String ROUND_LOST = "You lost!!";
    static final String ROUND_TIE = "You neither won nor lost the game.";
    static final String NEXT_ROUND = "Next round!";
    static final String GAME_OVER = "Game Over!";
    static final String ALREADY_SELECTED_DICE = "Sorry, you have already rolled that dice. Try again";
    static final String INVALID_ENTRY = "Sorry, that is an invalid entry. Try again. Valid entries are 1, 2, 3, and q\n";
    static final String AMOUNT_WIN_STRING = "#win: ";
    static final String AMOUNT_LOST_STRING = " #loss: ";
    static final String SUM_STRING = " sum: ";

    // Constants for dice values and target sum
    static final int MAX_DICE_VALUE = 6;
    static final int MIN_DICE_VALUE = 1;
    static final int DICE_SUM_TARGET_VALUE = 12;

    public static void main(final String[] args) {
        // Initialize game variables
        int roundsWon = 0;
        int roundsLost = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println(GAME_START);

        // Control whether the game continues or ends
        boolean keepPlaying = true;

        // Main game loop
        while (keepPlaying) {
            // Dice values
            int dice1 = 0;
            int dice2 = 0;
            int dice3 = 0;
            // Rolled flags
            boolean rolledDice1 = false;
            boolean rolledDice2 = false;
            boolean rolledDice3 = false;

            int roundSum = 0;
            System.out.println(NEXT_ROUND);

            // Allow rolling up to three dice
            for (int rollCount = 0; rollCount < 3; rollCount++) {
                while (true) {
                    System.out.print(CHOOSE_DICE + " ");
                    String input = scanner.nextLine().trim();

                    // Check if user wants to quit
                    if (input.equalsIgnoreCase("q")) {
                        keepPlaying = false;
                        break;
                    }

                    try {
                        int diceChoice = Integer.parseInt(input);

                        // Validate dice choice
                        if (diceChoice < 1 || diceChoice > 3) {
                            System.out.print(INVALID_ENTRY);
                        } else if ((diceChoice == 1 && rolledDice1)
                            ||
                            (diceChoice == 2 && rolledDice2)
                            ||
                            (diceChoice == 3 && rolledDice3)) {
                            System.out.println(ALREADY_SELECTED_DICE);
                        } else {
                            // If input is valid, roll the chosen dice
                            int rollValue = random.nextInt(MAX_DICE_VALUE - MIN_DICE_VALUE + 1) + MIN_DICE_VALUE;

                            // Update the corresponding dice value based on the user's choice
                            if (diceChoice == 1) {
                                dice1 = rollValue;
                                rolledDice1 = true;
                            } else if (diceChoice == 2) {
                                dice2 = rollValue;
                                rolledDice2 = true;
                            } else if (diceChoice == 3) {
                                dice3 = rollValue;
                                rolledDice3 = true;
                            }

                            roundSum = dice1 + dice2 + dice3;

                             // Print the current round's dice values, sum, wins, and losses
                            System.out.printf("%d %d %d%s%d%s%d%s%d\n",
                                dice1, dice2, dice3, SUM_STRING, roundSum,
                                AMOUNT_WIN_STRING, roundsWon, AMOUNT_LOST_STRING, roundsLost);
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.print(INVALID_ENTRY);
                    }
                }

                if (!keepPlaying)  {
                    break;
                }
            }

            if (!keepPlaying) {
                break;
            }
            // After all dice are rolled, determine the result
            if (roundSum == DICE_SUM_TARGET_VALUE) {
                roundsWon++;
                System.out.println(ROUND_WON);
            } else if (roundSum > DICE_SUM_TARGET_VALUE) {
                roundsLost++;
                System.out.println(ROUND_LOST);
            } else {
                System.out.println(ROUND_TIE);
            }
        }

        // Game over summary
        System.out.printf("\n%s%d%s%d\n", AMOUNT_WIN_STRING, roundsWon, AMOUNT_LOST_STRING, roundsLost);
        System.out.println(GAME_OVER);
        scanner.close();
    }
}

