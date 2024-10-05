import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
	private RecipeBook book;
	
	public UserInterface(RecipeBook book) {
		this.book=book;
		this.loadRecipe();
	}
	
	public void addRecipe(Recipe recipe) {
		this.book.add(recipe);
	}
	
	
	public void loadRecipe() {		
		try (Scanner scanner = new Scanner(new File("lib/recipes.txt"))) {
			while(scanner.hasNextLine()) {
				//create Recipe object
				Category cat=Category.valueOf(scanner.next());
				String name=scanner.nextLine();
				System.out.println(cat+name);
				Recipe r = new Recipe(name,cat);
				this.addRecipe(r);
				
				//decide whether it's vegetarian
				String veg=scanner.nextLine().trim();				
				if(veg.equalsIgnoreCase("veg")) {
					r.setVegetarian();
				}
				
				//read ingredients
				while(scanner.hasNextLine()) {
						String ingreLine=scanner.nextLine();
						if(ingreLine.isEmpty()) {
							break;
						}
						try (Scanner linesc = new Scanner(ingreLine)) {
							while(linesc.hasNext()) {
								String amount= linesc.next();
								String ingre=linesc.nextLine().trim();
								r.getIngre().put(amount, ingre);
								
							}
						}
				}				
				//read instrcutions
				while(scanner.hasNextLine()) {
					String instructionLine=scanner.nextLine();
					if(instructionLine.equals("---")) {
						break;
					}
					String instruction="";
					instruction+= instructionLine;
					r.setInstructions(instruction);
					
				}						
			}	
		}catch(IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void saveRecipe() {
		
	}
	
}
