package in.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import in.service.BankingAssistant;

@Configuration
public class AiServiceConfig {
	
	@Bean
	public BankingAssistant bankingAssistant(ChatModel chatModel) {
		return AiServices.create(BankingAssistant.class, chatModel);
		
	}

}
