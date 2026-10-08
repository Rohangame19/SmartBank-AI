package in.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface BankingAssistant {
	
	@SystemMessage("""
			you are a helpful banking assistant for SmartBank,
			Answer customer question about banking concepts, account features,
			deposits,withdraw, any general financial guidance.
			Do not give specific investment or legal advice.
			keep answer concise and clear.
			""")
	String chat(@UserMessage String userMessage);

}
