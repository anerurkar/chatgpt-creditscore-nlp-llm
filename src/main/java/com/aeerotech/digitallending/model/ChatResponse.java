package com.aeerotech.digitallending.model;



public class ChatResponse {
    private String reply;
    private String promptVersion;
    private String model;

    public ChatResponse(String reply, String promptVersion, String model) {
        this.reply = reply;
        this.promptVersion = promptVersion;
        this.model = model;
    }

    public String getReply() { return reply; }
    public String getPromptVersion() { return promptVersion; }
    public String getModel() { return model; }
}
