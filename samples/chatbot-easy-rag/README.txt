For instructions related to this sample, refer to docs/modules/ROOT/pages/easy-rag.adoc

This is an example of the https://docs.quarkiverse.io/quarkus-langchain4j/dev/easy-rag.html sample.

I just updated the documents that are ingested to be from the Maggianos Menu[https://www.maggianos.com/menus/500-16th-st./]

To make things simple, I just included the documents in the app. 

Update [application.properties](src/main/resources/application.properties)
quarkus.langchain4j.easy-rag.path=<docs-to-ingest>

Provide you OpenAI Key - https://platform.openai.com/api-keys
quarkus.langchain4j.openai.api-key=<openai-key>

Run `quarkus dev` or `mvn quarkus:dev` to start app in Dev Mode.

Open browser and then click the robot icon to open the chat window.
# menu-bot