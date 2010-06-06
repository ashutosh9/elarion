package game.unit;

import java.awt.Toolkit;
import java.util.Random;

import game.main.MainClass;

public class RandomHeroGenerator {
	private Hero randomHero;

	public RandomHeroGenerator(MainClass mc) {
		randomHero = new Hero(mc);
		
		String name;
		String firstName = "";
		String lastName1 = "";
		String lastName2 = "";
		
		Random random = new Random();
		
		int i = random.nextInt(6);
		
		if(i == 0){
			firstName = new String("Bryan");
		}
		if(i == 1){
			firstName = new String("Illakar");
		}
		if(i == 2){
			firstName = new String("Saorin");
		}
		if(i == 3){
			firstName = new String("Saarion");
		}
		if(i == 4){
			firstName = new String("Legolas");
		}
		if(i == 5){
			firstName = new String("Istanar");
		} 
		
		i = random.nextInt(6);
		
		if(i == 0){
			lastName1 = new String("Wood");
		}
		if(i == 1){
			lastName1 = new String("Cloud");
		}
		if(i == 2){
			lastName1 = new String("Night");
		}
		if(i == 3){
			lastName1 = new String("Hunt");
		}
		if(i == 4){
			lastName1 = new String("Light");
		}
		if(i == 5){
			lastName1 = new String("Storm");
		}
		
		i = random.nextInt(6);
		
		if(i == 0){
			lastName2 = new String("runner");
		}
		if(i == 1){
			lastName2 = new String("seeker");
		}
		if(i == 2){
			lastName2 = new String("strider");
		}
		if(i == 3){
			lastName2 = new String("guardian");
		}
		if(i == 4){
			lastName2 = new String("linker");
		}
		if(i == 5){
			lastName2 = new String("starter");
		} 
		
		name = new String(firstName + " " + lastName1 + lastName2);
		randomHero.setName(name);
		
		randomHero.getCombatStats().setMovementpoints(100);
		
		i = random.nextInt(6);
		
		if(i == 0){
			randomHero.getCombatStats().setInitiative(11);
			
			randomHero.getCombatStats().setStrenght(16);
			randomHero.getCombatStats().setConstitution(14);
			
			randomHero.getCombatStats().setDexterity(12);
			randomHero.getCombatStats().setIntelligence(10);
			
			randomHero.getCombatStats().setWisdom(10);
			randomHero.getCombatStats().setCharisma(10);
		}
		if(i == 1){
			randomHero.getCombatStats().setInitiative(12);
			
			randomHero.getCombatStats().setStrenght(14);
			randomHero.getCombatStats().setConstitution(16);
			
			randomHero.getCombatStats().setDexterity(14);
			randomHero.getCombatStats().setIntelligence(10);
			
			randomHero.getCombatStats().setWisdom(8);
			randomHero.getCombatStats().setCharisma(10);
		}
		if(i == 2){
			randomHero.getCombatStats().setInitiative(13);
			
			randomHero.getCombatStats().setStrenght(10);
			randomHero.getCombatStats().setConstitution(12);
			
			randomHero.getCombatStats().setDexterity(16);
			randomHero.getCombatStats().setIntelligence(14);
			
			randomHero.getCombatStats().setWisdom(10);
			randomHero.getCombatStats().setCharisma(10);
		}
		if(i == 3){
			randomHero.getCombatStats().setInitiative(12);
			
			randomHero.getCombatStats().setStrenght(10);
			randomHero.getCombatStats().setConstitution(10);
			
			randomHero.getCombatStats().setDexterity(14);
			randomHero.getCombatStats().setIntelligence(16);
			
			randomHero.getCombatStats().setWisdom(12);
			randomHero.getCombatStats().setCharisma(10);
		}
		if(i == 4){
			randomHero.getCombatStats().setInitiative(10);
			
			randomHero.getCombatStats().setStrenght(10);
			randomHero.getCombatStats().setConstitution(10);
			
			randomHero.getCombatStats().setDexterity(10);
			randomHero.getCombatStats().setIntelligence(12);
			
			randomHero.getCombatStats().setWisdom(16);
			randomHero.getCombatStats().setCharisma(14);
		}
		if(i == 5){
			randomHero.getCombatStats().setInitiative(12);
			
			randomHero.getCombatStats().setStrenght(10);
			randomHero.getCombatStats().setConstitution(14);
			
			randomHero.getCombatStats().setDexterity(14);
			randomHero.getCombatStats().setIntelligence(10);
			
			randomHero.getCombatStats().setWisdom(10);
			randomHero.getCombatStats().setCharisma(14);
		} 
		
		i = random.nextInt(8);
		i++;
		
		if(i==1){
			String s="Images/heroes/human/human_hero.jpg";
			randomHero.setIcon(Toolkit.getDefaultToolkit().getImage(s));
		} else {
			String s = "Images/heroes/human/human_hero_" + i + ".jpg"; 
			randomHero.setIcon(Toolkit.getDefaultToolkit().getImage(s));
		}
		
		
	}
	
	public Hero getRandomHero() {
		return randomHero;
	}
}
