package com.example.SpringAIDemo.Services;

import java.util.Map;

import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeGeneratorService {

	@Autowired
	private OllamaChatModel chatModel;
	
	public String createRecipe(String ingredients, String cuisine, String dietRestrictions) {

		var template = "I want to create recipe using following ingredients: {ingredients}."
				+ "The cuisine type I prefer is: {cuisine}."
				+ "Please consider following dietry restrictions: {dietRestrictions}."
				+ "Please provide me with a detailed recipe including title, list of ingredients and cooking instructions.";

		PromptTemplate promptTemplate = new PromptTemplate(template);

		Map<String, Object> params = Map.of("ingredients", ingredients, "cuisine", cuisine, "dietRestrictions",
				dietRestrictions);

		Prompt prompt = promptTemplate.create(params);

		String response = chatModel.call(prompt).getResult().getOutput().getContent();

		return response;
	}
}
