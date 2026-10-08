package in.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.service.BankingAssistant;

@RestController
@RequestMapping("/ai")
public class AiController {
	
	private final BankingAssistant assistant;
	
	public AiController(BankingAssistant assistant)
	{
		this.assistant=assistant;
	}
	
	@PostMapping("/ask")
	public String ask(@RequestParam String question)
	{
		return assistant.chat(question);
	}
	
	

}
