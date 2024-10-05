import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recipe {
	private String name;
	private Category category;
	private Map<String,String>ingre;
	private String instructions;
	private Boolean vegetarian;
	
	public Recipe(String name, Category category) {
		this.name=name;
		this.category=category;
		this.vegetarian=false;
		this.ingre=new HashMap<String, String>();
	}

	
	
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Map<String,String> getIngre() {
		return ingre;
	}


	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public Boolean getVegetarian() {
		return this.vegetarian;
	}

	public void setVegetarian() {
		this.vegetarian = true;
	}
	
	
	
}
