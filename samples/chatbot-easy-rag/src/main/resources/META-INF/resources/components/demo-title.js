import {LitElement, html, css} from 'lit';

export class DemoTitle extends LitElement {

    static styles = css`
      h1 {
        font-family: "Red Hat Mono", monospace;
        font-size: 60px;
        font-style: normal;
        font-variant: normal;
        font-weight: 700;
        line-height: 26.4px;
        color: var(--main-highlight-text-color);
      }

      .title {
        text-align: center;
        padding: 1em;
        background: var(--main-bg-color);
      }
      
      .explanation {
        margin-left: auto;
        margin-right: auto;
        width: 50%;
        text-align: justify;
        font-size: 20px;
      }
      
      .explanation img {
        max-width: 90%;
        display: block;
        float:left;
        margin-right: 2em;
        margin-top: 1em;
      }
    `

    render() {
        return html`
            <div class="title">
                <h1>Menu Bot</h1>
            </div>
            <div class="explanation">
                This demo shows how to build a chat bot powered by GPT 3.5 and retrieval augmented generation.
                
                The Maggianos menus are ingested into a in-memory vectorDB and relevant information
                
                is sent to the LLM before answering the user.
            </div>
            
            <div class="explanation">
            <img src="images/llms-big-picture.png"/>
            </div>
            
            <div class="explanation">
                <ol>
                    <li>The user send a question to the application.</li>
                    <li>The application looks for relevant data in the in-memory store.</li>
                    <li>The relevant data is retrieved and added to the user's question.</li>
                    <li>The extended question is sent to the LLM model.</li>
                    <li>The response is received and sent back to the user.</li>
                </ol>
            </div>
        `
    }


}

customElements.define('demo-title', DemoTitle);