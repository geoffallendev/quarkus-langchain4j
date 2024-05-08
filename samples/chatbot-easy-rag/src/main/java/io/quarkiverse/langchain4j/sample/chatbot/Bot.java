package io.quarkiverse.langchain4j.sample.chatbot;

import jakarta.inject.Singleton;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService // no need to declare a retrieval augmentor here, it is automatically generated and discovered
@Singleton // this is singleton because WebSockets currently never closes the scope
public interface Bot {

    @SystemMessage("""
            You are an AI answering questions about the menus at Maggianos

            Your response must be polite, use the same language as the question, and be relevant to the question.

            When you don't know, respond that you don't know the answer and the bank will contact the customer directly.

            Introduce yourself with: "Hello, I'm Walter the Waiter, how can I help you?"
            """)
    String chat(@MemoryId Object session, @UserMessage String question);
}
