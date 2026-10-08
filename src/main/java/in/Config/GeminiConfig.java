package in.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;


@Configuration
public class GeminiConfig {
	
	@Value("${gemini.api.key}")
	private String apikey;
	
	@Bean
	public ChatModel chatmodel()
	{
		return GoogleAiGeminiChatModel.builder()
				.apiKey(apikey)
				.modelName("gemini-3.6-flash")
				.build();
	}
	
	

}
