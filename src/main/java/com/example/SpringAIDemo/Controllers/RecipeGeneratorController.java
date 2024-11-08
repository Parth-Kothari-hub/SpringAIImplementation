package com.example.SpringAIDemo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringAIDemo.Services.RecipeGeneratorService;

@RestController
public class RecipeGeneratorController {

	@Autowired
	private RecipeGeneratorService recipeGeneratorService;
	
	@PostMapping("/recipeGenerator/generateRecipe")
	public String generateRecipe(@RequestParam(value = "ingredients") String ingredients,
			@RequestParam(value = "cuisine", defaultValue = "any") String cuisine,
			@RequestParam(value = "dietRestructions", defaultValue = "empty") String dietRestructions) {

		// Pass the cleaned list to the recipe creation method
		return recipeGeneratorService.createRecipe(ingredients, cuisine, dietRestructions);
	}
}
