import java.util.Scanner;
import java.util.Random;

class Traveller
{
	public String name;
	public void Classification()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("\nHello Traveller!\nEnter your name: ");
		name = in.nextLine();
		System.out.println("Welcome to the dungeon "+ name);
	}
	public String getName()
	{
		return name;
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
			int attempts= 5;
			System.out.println("\nThis is the first level. Before you proceed any further, complete this level. ");
			
			while (attempts > 0) 
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
	                return; // exit the method if the guess is correct
	            }

	            attempts--;
	            System.out.println("You have " + attempts + " attempts left.");
	        }

	        System.out.println("You ran out of attempts. You failed this level.");
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

// class FourthLevel
// 	{
// 	 public void MonsterFightGame() 
// 	    {
// 	        try (Scanner scanner = new Scanner(System.in)) 
// 	        {
// 				Random random = new Random();

// 				Player player = new Player(100, 20);
// 				Monster monster = new Monster(50, 15);

// 				System.out.println("\nThis is the fourth level. Get ready to fight a monster!");

// 				while (player.isAlive() && monster.isAlive()) 
// 				{
// 				    printStatsBox("Player Stats", player);
// 				    printStatsBox("Monster Stats", monster);

// 				    System.out.print("\nWhat do you want to do? (1 - Attack, 2 - Run): ");
// 				    int choice = scanner.nextInt();

// 				    if (choice == 1) 
// 				    {
// 				        playerAttack(player, monster, random);
// 				    }
// 				    else if (choice == 2) 
// 				    {
// 				        System.out.println("You chose to run away.");
// 				        break;
// 				    } 
// 				    else
// 				    {
// 				        System.out.println("Invalid choice. Please choose 1 or 2.");
// 				    }
// 				}

// 				if (player.isAlive())
// 				{
// 				    System.out.println("\nCongratulations! You defeated the monster and proceed to the next level!");
// 				} 
// 				else 
// 				{
// 				    System.out.println("\nGame over! The monster was too strong for you.");
// 				}
// 				// scanner.close();
// 			}
// 	    }

// 	    private static void playerAttack(Player player, Monster monster, Random random)
// 	    {
// 	        int playerDamage = random.nextInt(player.getAttack()) + 1;
// 	        monster.takeDamage(playerDamage);
// 	        System.out.println("You dealt " + playerDamage + " damage to the monster!");

// 	        int monsterDamage = random.nextInt(monster.getAttack()) + 1;
// 	        player.takeDamage(monsterDamage);
// 	        System.out.println("The monster dealt " + monsterDamage + " damage to you!");
// 	    }

// 	    private static void printStatsBox(String title, Creature creature) 
// 	    {
// 	        int boxWidth = 30;
// 	        System.out.println("+" + "-".repeat(boxWidth - 2) + "+");
// 	        System.out.println("|" + centerText(title, boxWidth - 2) + "|");
// 	        System.out.println("|" + "-".repeat(boxWidth - 2) + "|");
// 	        System.out.println("| Health: " + creature.getHealth() + spaces(boxWidth - 12 - String.valueOf(creature.getHealth()).length()) + "|");
// 	        System.out.println("| Attack: " + creature.getAttack() + spaces(boxWidth - 12 - String.valueOf(creature.getAttack()).length()) + "|");
// 	        System.out.println("+" + "-".repeat(boxWidth - 2) + "+");
// 	    }

	    
// 	    private static String centerText(String text, int width) {
// 	        int padding = (width - text.length()) / 2;
// 	        return spaces(padding) + text + spaces(padding);
// 	    }

// 	    private static String spaces(int count) 
// 	    {
// 	        return " ".repeat(count);
// 	    }

// 	    private static class Creature 
// 	    {
// 	        private int health;
// 	        private int attack;

// 	        public Creature(int health, int attack)
// 	        {
// 	            this.health = health;
// 	            this.attack = attack;
// 	        }

// 	        public int getHealth() 
// 	        {
// 	            return health;
// 	        }

// 	        public int getAttack()
// 	        {
// 	            return attack;
// 	        }

// 	        public void takeDamage(int damage) 
// 	        {
// 	            health = Math.max(0, health - damage);
// 	        }

// 	        public boolean isAlive() 
// 	        {
// 	            return health > 0;
// 	        }
// 	    }

// 	    private static class Player extends Creature 
// 	    {
// 	        public Player(int health, int attack) 
// 	        {
// 	            super(health, attack);
// 	        }
// 	    }

// 	    private static class Monster extends Creature
// 	    {
// 	        public Monster(int health, int attack) 
// 	        {
// 	            super(health, attack);
// 	        }
// 	    }
	    
	    
// 	}

class FifthLevel
{
	public void MonsterFightGame()
	{
	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	Player player = new Player("Hero", 100, 25, 15, 50);
	String bossMoves[] = new String[]{"Icicle spear!", "Blizzard!!", "Frostburn Nova!!!"};
	Enemy Boss = new Enemy("Minister Blizzard", 100, 15, 5, bossMoves);
	int attackOrder[] = {0,0,2,0,1,1,0,0,1,0};
	int attackCounter = 0;

	String bossIntro = "As the chilling winds howl and frost encases the battleground, a figure emerges from the blizzard's heart.\r\n"
						+ "Minister Blizzard, a towering colossus draped in robes of ice, commands the frozen tempests at will.\r\n"
						+ "Glacial spikes jut from his shoulders, crackling with elemental power, while his eyes gleam like frozen sapphires, filled with an ancient malevolence.\r\n"
						+ "With each step, the ground freezes, and the air thickens with an icy aura, heralding a formidable battle against this tyrant of frost and snow.\n" ;
	for(int i = 0; i < bossIntro.length(); i++)
	{
	    System.out.printf("%c", bossIntro.charAt(i));
	    try{
	        Thread.sleep(2);//0.5s pause between characters
	    }catch(InterruptedException ex){
	        Thread.currentThread().interrupt();
	    }
	}

	System.out.println("You enter into a fight for your very life!!!");
	while (player.getHealth()>0 && Boss.isAlive()) 
	        {
	            System.out.println("\nPlayer Stats - Name: " + player.getName() + ", Health: " + player.getHealth());
	            System.out.println("Monster Stats - Name: " + Boss.getName() + ", Health: " + Boss.getHealth());

	            System.out.println("\nWhat do you want to do?");
				System.out.println("1 - Attack, 2 - Heal, 3 - Display Player Stats, 4 - Display Enemy Stats");
	            int choice = sc.nextInt();

	            if (choice == 1) 
	            {
					System.out.println("Please choose type of attack - ");
					System.out.println("1 - Light Attack, 2 - Medium Attack");
					System.out.println("3 - Heavy Attack, 4 - Magic Attack");
					int attackSelect = sc.nextInt();
					do
					{
						switch (attackSelect) 
						{
							case 1:
								System.out.println(player.getDamage(1));
								//System.out.println(Boss.takeDamage(player.getDamage(0)););
								Boss.takeDamage(player.getDamage(1));
								break;
							case 2:
							System.out.println(player.getDamage(2));
								Boss.takeDamage(player.getDamage(2));
								break;
							case 3:
							System.out.println(player.getDamage(3));
								Boss.takeDamage(player.getDamage(3));
								break;
							case 4:
							System.out.println(player.getDamage(4));
								Boss.takeDamage(player.getDamage(4));
								player.decreaseMagicPoints(20);
								break;
							default:
								System.out.println("Please enter a valid value");		
								break;
						}		
					} while (attackSelect<1 || attackSelect>4);		

					System.out.println("The monster lets out a mighty roar and uses " + bossMoves[attackOrder[attackCounter]]);
					player.takeDamage((int)Boss.getDamage(attackCounter++));
	            } 
	            else if (choice == 2) 
	            {
					int healValue = random.nextInt(20 - 7) + 7;
	                // Player chooses to heal
	                System.out.println("A majestic light fills you from within, you heal " + healValue);
					player.heal(healValue);  
					// Boss attacks
					System.out.println("The monster lets out a mighty roar and uses " + bossMoves[attackCounter]);
					player.takeDamage((int)Boss.getDamage(attackCounter++));              
	            } 
	            else if (choice == 3)
	            {
	                player.displayStats();
	            }
				else if (choice == 4)
				{
					Boss.displayStats();
				}
				else 
				{
					System.out.println("Please choose a valid option between 1 - 4");
				}
	        }

	        if (player.getHealth()>0)
	        {
	            System.out.println("\nCongratulations! The boss is defeated, you win the game!!!!");
	        } 
	        else 
	        {
	            System.out.println("\nGame over! The monster was too strong for you.");
	        }
	
	sc.close();
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
        p1.Classification();
        FirstLevel level1 = new FirstLevel();
        level1.RandomNumber();
        SecondLevel level2 = new SecondLevel();
        level2.GuessTheWord();
        ThirdLevel level3 = new ThirdLevel();
        level3.DiceRollingGame();
        // FourthLevel level4 = new FourthLevel();
        // level4.MonsterFightGame();
		FifthLevel level5 = new FifthLevel();
		level5.MonsterFightGame();
	}
}


