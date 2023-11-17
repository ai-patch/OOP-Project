import java.util.Random;

class Player
{
    private String name;
    private int maxHealth;
    private int health;
    private int attack;
    private int defense;
    private int staminaPoints;
    private int magicPoints;

    public Player(String name, int maxHealth, int attack, int defense, int staminaPoints, int magicPoints)
    {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.defense = defense;
        this.staminaPoints = staminaPoints;
        this.magicPoints = magicPoints;
    }

    public String getName()
    {
        return name;
    }

    public int getHealth()
    {
        return health;
    }

    public int getDefense()
    {
        return defense;
    }

    public int getstaminaPoints()
    {
        return staminaPoints;
    }

    public int getMagicPoints()
    {
        return magicPoints;
    }

    public int dealDamage()
    {
        Random random = new Random();
        int damage = attack + random.nextInt(5);
        return damage;
    }

    public void takeDamage(int damage)
    {
        health -= damage;
        if (health < 0)
        {
            health = 0;
        }
    }

    public void heal(int amount)
    {
        health += amount;
        if (health > maxHealth)
        {
            health = maxHealth;
        }
    }

    public void increaseDefense(int amount)
    {
        defense += amount;
    }

    public void decreaseDefense(int amount)
    {
        defense -= amount;
        if (defense < 0)
        {
            defense = 0;
        }
    }

    public void increasestaminaPoints(int amount)
    {
        staminaPoints += amount;
    }

    public void decreasestaminaPoints(int amount)
    {
        staminaPoints -= amount;
        if (staminaPoints < 0) 
        {
            staminaPoints = 0;
        }
    }

    public void increaseMagicPoints(int amount) 
    {
        magicPoints += amount;
    }

    public void decreaseMagicPoints(int amount)
    {
        magicPoints -= amount;
        if (magicPoints < 0)
        {
            magicPoints = 0;
        }
    }
    

    public void displayStats() 
    {
        System.out.println("Player Stats:");
        System.out.println("Name: " + name);
        System.out.println("Health: " + health + "/" + maxHealth);
        System.out.println("Defense: " + defense);
        System.out.println("Special Points: " + staminaPoints);
        System.out.println("Magic Points: " + magicPoints);
    }
}

public class RPGGame 
{
    public static void main(String[] args) 
    {
        Player player = new Player("Hero", 100, 15, 10, 20, 30);

        Player enemy = new Player("Enemy", 50, 5, 10, 10, 10);

        int damageDealt = player.dealDamage();
        enemy.takeDamage(damageDealt);

        //Damage
        player.takeDamage(15);

        //Heals
        player.heal(10);

        //Increase DP
        player.increaseDefense(5);

        //Decrease SP
        player.decreasestaminaPoints(10);

        //Display Player Stats
        player.displayStats();
        System.out.println();
        enemy.displayStats();
    }
}