import java.util.Random;
import java.util.Scanner;

public class Game{
    //isNumeric from Coding Ranch
    public static Adventurer Selection(){
	Scanner input = new Scanner(System.in);
	Random rand = new Random();
	System.out.println("\nSelect the appropriate letter for the class your wish to select:");
	System.out.println("A: Warrior");
	System.out.println("B: Wizard");
	System.out.println("C: Rogue");
	String clas = "";
	while (!clas.toLowerCase().equals("a") && !clas.toLowerCase().equals("b") && !clas.toLowerCase().equals("c")){
	    clas = input.nextLine();
	}
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException ex){
	    Thread.currentThread().interrupt();
	}
	System.out.println("\nWhat is your name?");
	String name = input.nextLine();
	Adventurer player;
	if(clas.toLowerCase().equals("a")){
	    player = new Warrior(name);
	}else if(clas.toLowerCase().equals("b")){
	    player = new Wizard(name);
	}else{
	    player = new Rogue(name);
	}
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException ex){
	    Thread.currentThread().interrupt();
	}
	System.out.println("\nYou have 27 stat points which you allocate between STR, DEX, and INT. One point has already been allocated to each stat.");
	try{
	Thread.sleep(750);
	}catch(InterruptedException ex){
	    Thread.currentThread().interrupt();
	}
	System.out.println("\nYou currently have 1 point in Str. How many points do you wish to allocate towards STR?");
	int str = -1;
	while(!(str >= 0)){
	    str = input.nextInt();
	    if(str > 30){
		str = -1;
	    }
	}
	try{
	Thread.sleep(500);
	}catch(InterruptedException ex){
	    Thread.currentThread().interrupt();
	}
	System.out.println("\nYou have 1 point in Dex. You have " + (27 - str) + "remaining");
	int dex = -1;
	while(!(dex >= 0)){
	    dex = input.nextInt();
	    if(dex > 27 - str){
		dex = -1;
	    }
	}
	try{
	    Thread.sleep(500);
	}catch(InterruptedException ex){
	    Thread.currentThread().interrupt();
	}
	System.out.println("\n"+(27 - str - dex) + " were allocated to your Int \n");
	player.setStr(str + 1);
	player.setDex(dex + 1);
	player.setInt(28 - str - dex);
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException ex){
	    Thread.currentThread().interrupt();
	}
	System.out.println("\n"+player.getStats()+"\n");
	try{
	    Thread.sleep(2000);
	}catch(InterruptedException ex){
	    Thread.currentThread().interrupt();
	}
	return player;
    }
    public static Adventurer Opposition(){
	Random rand = new Random();
	System.out.println("A challenger has appeared");
	int oppc = rand.nextInt(3);
	Adventurer opponent;
	if(oppc == 0){
	    opponent = new Warrior("Zulck");
	}else if(oppc == 1){
	    opponent = new Wizard("Jace");
	}else{
	    opponent = new Rogue("Valeera");
	}
	System.out.println(opponent.getName()+" stepped out of the shadows \n");
	opponent.setStr(10);
	opponent.setDex(10);
	opponent.setInt(10);
	return opponent;
    }
    public static void Combat(Adventurer[] player, Adventurer[] opponent){
	Scanner input = new Scanner(System.in);
	Random rand = new Random();
	boolean turn = rand.nextBoolean();
	if(turn){
	    System.out.println("You have the first attack\n");
	}else{
	    System.out.println("Your opponents attacked first\n");
	    for(int i = 0; i < 3; i++){
		if(rand.nextBoolean()){
		    opponent[i].specialattack(player[rand.nextInt(3)]);
		}else{
		    opponent[i].attack(player[rand.nextInt(3)]);
		}
	    }
	}
	try{
	Thread.sleep(2000);
	}catch(InterruptedException ex){
	    Thread.currentThread().interrupt();
	}
	do{
	    for(int q = 0;q < 3;q++){
		if((player[0].getHP() > 0 || player[1].getHP() > 0 || player[2].getHP() > 0) && (opponent[0].getHP() > 0 || opponent[1].getHP() > 0 || opponent[2].getHP() > 0)){
		    if(player[q].getHP() > 0){
			System.out.println("\n"+player[q].getName()+"'s turn\n");
			System.out.println("\nYour Team\n");
			System.out.println(player[0].getStats());
			System.out.println(player[1].getStats());
			System.out.println(player[2].getStats());
			
			try{
			    Thread.sleep(2000);
			}catch(InterruptedException ex){
			    Thread.currentThread().interrupt();
			}
			System.out.println("\nOpposition");
			System.out.println("\n" + opponent[0].getStats());
			System.out.println(opponent[1].getStats());
			System.out.println(opponent[2].getStats());
			try{
			    Thread.sleep(1000);
			}catch(InterruptedException ex){
			    Thread.currentThread().interrupt();
			}
			System.out.println("\nWho will you target?");
			System.out.println("1: "+ opponent[0].getName());
			System.out.println("2: "+ opponent[1].getName());
			System.out.println("3: "+ opponent[2].getName());
			String selecto = "";
			while(!selecto.toLowerCase().equals("1") && !selecto.toLowerCase().equals("2") && !selecto.toLowerCase().equals("3")){
			    selecto = input.nextLine();
			    if(opponent[Integer.parseInt(selecto) - 1].getHP() <= 0){
				System.out.println("Invalid, that character is already dead");
				selecto = "";
			    }
			}
			
			System.out.println("\n What do you want to do?");
			System.out.println("A: Attack");
			System.out.println("B: Use a special attack");
			System.out.println("C: Heal Team");
			System.out.println("D: Flee\n");
			String select = "";
			while (!select.toLowerCase().equals("a") && !select.toLowerCase().equals("b") && !select.toLowerCase().equals("c") &&  !select.toLowerCase().equals("d")){
			    select = input.nextLine();
			}
			if(select.toLowerCase().equals("a")){
			    player[q].attack(opponent[Integer.parseInt(selecto) - 1]);
			}else if(select.toLowerCase().equals("b")){
			    player[q].specialattack(opponent[Integer.parseInt(selecto) - 1]);
			}else if(select.toLowerCase().equals("c")){
			    player[0].setHP(player[0].getHP() + 5);
			    player[1].setHP(player[1].getHP() + 5);
			    player[2].setHP(player[2].getHP() + 5);
			}else if(select.toLowerCase().equals("d")){
			    player[0].setHP(0);
			    player[1].setHP(0);
			    player[2].setHP(0);
			}
			try{
			    Thread.sleep(2000);
			}catch(InterruptedException ex){
			    Thread.currentThread().interrupt();
			}	
		    }
		}
	    }
	    try{
		Thread.sleep(500);
	    }catch(InterruptedException ex){
		Thread.currentThread().interrupt();
	    }
	    if((player[0].getHP() > 0 || player[1].getHP() > 0 || player[2].getHP() > 0) && (opponent[0].getHP() > 0 || opponent[1].getHP() > 0 || opponent[2].getHP() > 0)){
		System.out.println("They're attacking!!");
		for(int q = 0; q < 3; q++){
		    if(opponent[q].getHP() > 0){
			try{
			    Thread.sleep(2000);
			}catch(InterruptedException ex){
			    Thread.currentThread().interrupt();
			}
			if(rand.nextBoolean()){
			    opponent[q].specialattack(player[rand.nextInt(3)]);
			}else{
			    opponent[q].attack(player[rand.nextInt(3)]);
			}
		    }
		}
	    }	    
	}while((player[0].getHP() > 0 || player[1].getHP() > 0 || player[2].getHP() > 0) && (opponent[0].getHP() > 0 || opponent[1].getHP() > 0 || opponent[2].getHP() > 0));
	if(player[0].getHP() <= 0 && player[1].getHP() <= 0 && player[2].getHP() <= 0){
	    System.out.println("\n You lost");
	}else{
	    System.out.println("\n You won");
	}
    }
    public static void main(String[]args){
	Scanner input = new Scanner(System.in);
	System.out.println("Greetings, welcome to the world of Stuyablo\n");
	try{
	Thread.sleep(2000);
	}catch(InterruptedException ex){
	    Thread.currentThread().interrupt();
	}
	System.out.println("Create your team \n");
	try{
	    Thread.sleep(1000);
	}catch(InterruptedException ex){
	    Thread.currentThread().interrupt();
	}
	int[] Hearts = new int[3];
	Adventurer[] Team = new Adventurer[3];
	for(int i = 0; i < 3; i++){
	    System.out.println("Player #" + (1 + i));
	    Team[i] = Selection();
	    Hearts[i] = Team[i].getHP();
	}
	boolean cont = true;
	do{
	    System.out.println("\nYou're being attacked\n");
	    try{
		Thread.sleep(2000);
	    }catch(InterruptedException ex){
		Thread.currentThread().interrupt();
	    }
	    Adventurer[] Ens = new Adventurer[3];
	    for(int i = 0; i < 3; i++){
		Ens[i] = Opposition();
		try{
		Thread.sleep(1500);
		}catch(InterruptedException ex){
		    Thread.currentThread().interrupt();
		}
	    }
	    Combat(Team, Ens);
	    try{
		Thread.sleep(500);
	    }catch(InterruptedException ex){
		Thread.currentThread().interrupt();
	    }
	    System.out.println("Would you like to fight again?");
	    System.out.println("Y: Yes");
	    System.out.println("N: No");
	    String select = "";
	    while (!select.toLowerCase().equals("y") && !select.toLowerCase().equals("n")){
		select = input.nextLine();
	    }
	    if(select.toLowerCase().equals("n")){
		cont = false;
	    }else{
		for(int i = 0;i< 3; i++){
		    Team[i].setHP(Hearts[i]);
		}
	    }

	}while(cont);
	input.close();
    }

	
}
