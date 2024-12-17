package task;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

	public class RockPaperScissors {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();

	        System.out.print("Enter your name: ");
	        String playerName = scanner.nextLine();

	        Player player = new Player(playerName);

	        while (true) {
	            System.out.println("1. Play Game");
	            System.out.println("2. View Leaderboard");
	            System.out.println("3. Exit");

	            System.out.print("Choose an option: ");
	            int option = scanner.nextInt();
	            scanner.nextLine(); // Consume newline left-over

	            switch (option) {
	                case 1:
	                    playGame(player, scanner, random);
	                    break;
	                case 2:
	                    viewLeaderboard(player);
	                    break;
	                case 3:
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Invalid option. Please choose again.");
	            }
	        }
	    }

	    public static void playGame(Player player, Scanner scanner, Random random) {
	        System.out.println("Choose your move:");
	        System.out.println("1. Rock");
	        System.out.println("2. Paper");
	        System.out.println("3. Scissors");

	        System.out.print("Enter your choice (1-3): ");
	        int playerMove = scanner.nextInt();
	        scanner.nextLine(); // Consume newline left-over

	        int computerMove = random.nextInt(3) + 1;

	        LocalTime startTime = LocalTime.now();
	        System.out.println("\nYou chose: " + getMoveName(playerMove));
	        System.out.println("Computer chose: " + getMoveName(computerMove));
	        LocalTime endTime = LocalTime.now();

	        Duration duration = Duration.between(startTime, endTime);
	        long timeTaken = duration.toMillis();

	        int result = determineWinner(playerMove, computerMove);

	        switch (result) {
	            case 1:
	                System.out.println("You win!");
	                player.wins++;
	                break;
	            case 2:
	                System.out.println("Computer wins!");
	                player.losses++;
	                break;
	            case 3:
	                System.out.println("It's a draw!");
	                player.draws++;
	                break;
	        }

	        player.totalTime += timeTaken;

	        System.out.println("Time taken: " + timeTaken + " milliseconds");
	    }

	    public static void viewLeaderboard(Player player) {
	        System.out.println("Leaderboard:");
	        System.out.println("Name: " + player.name);
	        System.out.println("Wins: " + player.wins);
	        System.out.println("Losses: " + player.losses);
	        System.out.println("Draws: " + player.draws);
	        System.out.println("Total Time: " + player.totalTime + " milliseconds");
	    }

	    public static String getMoveName(int move) {
	        switch (move) {
	            case 1:
	                return "Rock";
	            case 2:
	                return "Paper";
	            case 3:
	                return "Scissors";
	            default:
	                return "Invalid move";
	        }
	    }

	    public static int determineWinner(int playerMove, int computerMove)
	    {
	    	if (playerMove == computerMove) {
	            return 3; // Draw
	    	
	    }
	    	 switch (playerMove) {
	            case 1: // Rock
	                return computerMove == 3 ? 1 : 2; // Rock beats Scissors, loses to Paper
	            case 2: // Paper
	                return computerMove == 1 ? 1 : 2; // Paper beats Rock, loses to Scissors
	            case 3: // Scissors
	                return computerMove == 2 ? 1 : 2; // Scissors beats Paper, loses to Rock
	            default:
	            	return computerMove == 3 ? 1 : 2;}
	    }
	}
	    
	
	
	
