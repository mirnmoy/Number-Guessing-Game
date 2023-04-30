package guessthenumber;
import java.util.Scanner;
import java.util.Random;
 
		class Game {
			int systemInput;
			int userInput;
			int attempts=0;
			int MAX_GUESS = 100;
		    int MAX_ATTEMPTS = 10;
			Game() {
				Random random = new Random();
				this.systemInput = random.nextInt(MAX_GUESS) + 1;
			}
			public boolean takeUserInput() {
				if ( attempts < MAX_ATTEMPTS ) {
					System.out.print("Guess the number : ");
					this.userInput = guessthenumber.takeIntegerInput(MAX_GUESS);
					attempts++;
					return false;
				}
				else {
					System.out.println("Better luck next time, Your number of attempts over\n");
					return true;
				}
			}
			public boolean isCorrectGuess() {
				
				if ( systemInput == userInput ) {
					System.out.println("Congratulations, you guess the number " + systemInput +
					" in " + attempts + " guesses");
					switch(attempts) {
						case 1:
						System.out.println("Your score is 100");
						break;
						case 2:
						System.out.println("Your score is 90");
						break;
						case 3:
						System.out.println("Your score is 80");
						break;
						case 4:
						System.out.println("Your score is 70");
						break;
						case 5:
						System.out.println("Your score is 60");
						break;
						case 6:
						System.out.println("Your score is 50");
						break;
						case 7:
						System.out.println("Your score is 40");
						break;
						case 8:
						System.out.println("Your score is 30");
						break;
						case 9:
						System.out.println("Your score is 20");
						break;
						case 10:
						System.out.println("Your score is 10");
						break;
					}
					System.out.println();
					return true;
				}
				else if ( attempts < MAX_ATTEMPTS   && userInput > systemInput ) {
					if ( userInput - systemInput > MAX_ATTEMPTS   ) {
						System.out.println("Too High");
					}
					else {
						System.out.println("Little High");
					}
				}
				else if ( attempts < MAX_ATTEMPTS  && userInput < systemInput ) {
					if ( systemInput - userInput > MAX_ATTEMPTS   ) {
						System.out.println("Too low");
					}
					else {
						System.out.println("Little low");
					}
				}
				return false;
			}
		}
		public class guessthenumber {
			public static int takeIntegerInput(int limit) {
				int input = 0;
				boolean flag = false;
				
				while ( !flag ) {
					try {
						Scanner sc = new Scanner(System.in);
						input = sc.nextInt();
						flag = true;
						
						if ( flag && input > limit || input < 1 ) {
							System.out.println("Choose the number between 1 to  "+limit );
							flag = false;
						}
					}
					catch ( Exception e ) {
						System.out.println("Enter only integer value");
						flag = false;
					}
				};
				return input;
			}
			public static void main(String[] args) {
				
				System.out.println("1. Start the Game \n2. Exit \nEnter your choice");
				int choice = takeIntegerInput(2);
				int continuePlaying = 1;
				int numberOfRound = 0;
				
				if ( choice == 1 ) {
					
					while ( continuePlaying == 1 ) {
			
						Game game = new Game();
						boolean isMatched = false;
						boolean isLimitCross = false;
						System.out.println("\nRound " + ++numberOfRound + " starts...");
						
						while ( !isMatched && !isLimitCross) {
							isLimitCross = game.takeUserInput();
							isMatched = game.isCorrectGuess();
						}
						System.out.println("1. continuePlaying \n2. Exit \nEnter your choice");
						continuePlaying = takeIntegerInput(2);
						if ( continuePlaying != 1 ) {
							System.exit(0);
						}
					}
				}
				else {
					System.exit(0);
				}
			}
   }


