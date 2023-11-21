package marika;
import java.util.Scanner;
import java.util.Random;

class Traveller
{
	public void Classification(String p1)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("\nHello Traveller!\nEnter your name: ");
		String name = in.nextLine();
		System.out.println("Welcome to the dungeon "+ name);
	}
}
class FirstLevel
{
	public void RandomNumber()
	{
		Scanner in = new Scanner(System.in);
		Random r1 = new Random();
		int randomNumber = r1.nextInt(10) + 1; 
		int guess;
		System.out.println("\nThis is the first level. Before you proceed any further, complete this level. ");
		do 
		{
			
			System.out.print("\nGuess the number (1-10): ");
			guess = in.nextInt();
			if (guess < randomNumber)
			{
				System.out.println("Too low! Try again.");
			} 
			else if (guess > randomNumber) 
			{
				System.out.println("Too high! Try again.");
			} 
			else
			{
				System.out.println("\nCongratulations! You guessed the number.");
				System.out.println("You may proceed to the next level.");
			}
			}
		while (guess != randomNumber);

	}
}

class SecondLevel
{
	public void GuessTheWord()
	{
        Scanner in = new Scanner(System.in);
        String[] words = {"apple", "banana", "orange", "grape", "watermelon"};
        Random random = new Random();
        String selectedWord = words[random.nextInt(words.length)];
        char[] dashedWord = new char[selectedWord.length()];

        for (int i = 0; i < selectedWord.length(); i++)
        {
            dashedWord[i] = '_';
        }

        System.out.println("\nThis is the second level. Here, you have to guess the name of a fruit. Guess the word:");

        do 
        {
            System.out.println("Current Progress: " + new String(dashedWord));
            System.out.print("Enter a letter: ");
            char guess = in.next().charAt(0);
            guess = Character.toLowerCase(guess);

            boolean correctGuess = false;

            for (int i = 0; i < selectedWord.length(); i++)
            {
                if (selectedWord.charAt(i) == guess) 
                {
                    dashedWord[i] = guess;
                    correctGuess = true;
                }
            }

            if (!correctGuess) 
            {
                System.out.println("Incorrect guess. Try again.");
            }

        } 
        while (new String(dashedWord).contains("_"));

        System.out.println("\nCongratulations! You guessed the word.");
        System.out.println("You have successfully completed this level!");
        System.out.println("You may proceed to the next level");
        
    }
}

class ThirdLevel 
{
    public void DiceRollingGame() 
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int targetTotal = 25;
        int currentTotal = 0;
        int rolls = 0;

        System.out.println("\nThis is the third level. Welcome to the Dice Rolling Game!");
        System.out.println("Try to reach the target total of " + targetTotal);

        while (currentTotal < targetTotal) 
        {
            int roll = rollDie();
            currentTotal += roll;
            rolls++;

            System.out.println("Roll #" + rolls + ": You rolled a " + roll + " (Current Total: " + currentTotal + ")");

            if (currentTotal >= targetTotal) {
                System.out.println("Congratulations! You reached the target total in " + rolls + " rolls.");
                System.out.println("You may proceed to the next level.");
            } else {
                System.out.print("Roll again? (yes/no): ");
                String response = scanner.nextLine().toLowerCase();

                if (!response.equals("yes")) {
                    System.out.println("Thanks for playing! Your final total is " + currentTotal);
                    break;
                }
            }
        }

        //scanner.close();
    }

    private static int rollDie() 
    {
        Random random = new Random();
        return random.nextInt(6) + 1; // Returns a random number between 1 and 6
    }
}

class FourthLevel
	{
	    public void MonsterFightGame() 
	    {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();

	        Player player = new Player(100, 20);
	        Monster monster = new Monster(50, 15);

	        System.out.println("\nThis is the fourth level. Get ready to fight a monster!");

	        while (player.isAlive() && monster.isAlive()) 
	        {
	            System.out.println("\nPlayer Stats - Health: " + player.getHealth() + ", Attack: " + player.getAttack());
	            System.out.println("Monster Stats - Health: " + monster.getHealth() + ", Attack: " + monster.getAttack());

	            System.out.print("\nWhat do you want to do? (1 - Attack, 2 - Run): ");
	            int choice = scanner.nextInt();

	            if (choice == 1) 
	            {
	                // Player attacks the monster
	                int playerDamage = random.nextInt(player.getAttack()) + 1;
	                monster.takeDamage(playerDamage);
	                System.out.println("You dealt " + playerDamage + " damage to the monster!");

	                // Monster attacks the player
	                int monsterDamage = random.nextInt(monster.getAttack()) + 1;
	                player.takeDamage(monsterDamage);
	                System.out.println("The monster dealt " + monsterDamage + " damage to you!");
	            } 
	            else if (choice == 2) 
	            {
	                // Player chooses to run
	                System.out.println("You chose to run away. Game over!");
	                break;
	            } 
	            else 
	            {
	                System.out.println("Invalid choice. Please choose 1 or 2.");
	            }
	        }

	        if (player.isAlive())
	        {
	            System.out.println("\nCongratulations! You defeated the monster and proceed to the next level!");
	        } 
	        else 
	        {
	            System.out.println("\nGame over! The monster was too strong for you.");
	        }

	        //scanner.close();
	    }

	    private static class Player 
	    {
	        private int health;
	        private int attack;

	        public Player(int health, int attack)
	        {
	            this.health = health;
	            this.attack = attack;
	        }

	        public int getHealth() 
	        {
	            return health;
	        }

	        public int getAttack() 
	        {
	            return attack;
	        }

	        public void takeDamage(int damage) 
	        {
	            health -= damage;
	            if (health < 0)
	            {
	                health = 0;
	            }
	        }

	        public boolean isAlive() 
	        {
	            return health > 0;
	        }
	    }

	    private static class Monster 
	    {
	        private int health;
	        private int attack;

	        public Monster(int health, int attack) 
	        {
	            this.health = health;
	            this.attack = attack;
	        }

	        public int getHealth()
	        {
	            return health;
	        }

	        public int getAttack() 
	        {
	            return attack;
	        }

	        public void takeDamage(int damage) 
	        {
	            health -= damage;
	            if (health < 0)
	            {
	                health = 0;
	            }
	        }

	        public boolean isAlive()
	        {
	            return health > 0;
	        }
	    }
	}



public class Main 
{
    public static void main(String[] args)
    {
        String art = 
                "  _____      __      _     ____     ___       ___   ______     ______      _____   _________   ________ \r\n"
                + " / ____\\    /  \\    / )   / __ \\   (  (       )  ) (_  __ \\   (   __ \\    (_   _) (_   _____) (___  ___)\r\n"
                + "( (___     / /\\ \\  / /   / /  \\ \\   \\  \\  _  /  /    ) ) \\ \\   ) (__) )     | |     ) (___        ) )   \r\n"
                + " \\___ \\    ) ) ) ) ) )  ( ()  () )   \\  \\/ \\/  /    ( (   ) ) (    __/      | |    (   ___)      ( (    \r\n"
                + "     ) )  ( ( ( ( ( (   ( ()  () )    )   _   (      ) )  ) )  ) \\ \\  _     | |     ) (           ) )   \r\n"
                + " ___/ /   / /  \\ \\/ /    \\ \\__/ /     \\  ( )  /     / /__/ /  ( ( \\ \\_))   _| |__  (   )         ( (    \r\n"
                + "/____/   (_/    \\__/      \\____/       \\_/ \\_/     (______/    )_) \\__/   /_____(   \\_/          /__\\   ";
        
        System.out.println(art);  // Print the ASCII art
        
        Traveller p1 = new Traveller();
        p1.Classification(null);
        FirstLevel level1 = new FirstLevel();
        level1.RandomNumber();
        SecondLevel level2 = new SecondLevel();
        level2.GuessTheWord();
        ThirdLevel level3 = new ThirdLevel();
        level3.DiceRollingGame();
        FourthLevel level4 = new FourthLevel();
        level4.MonsterFightGame();
    }
}

