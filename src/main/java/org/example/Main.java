package org.example;

import com.slack.api.bolt.App;
import com.slack.api.bolt.jetty.SlackAppServer;

public class Main {

    public static void main(String[] args) {
        String SLACK_BOT_TOKEN = "";
        String SLACK_SIGNING_SECRET = "";

        App app = new App(SLACK_BOT_TOKEN, SLACK_SIGNING_SECRET);

        app.command("/hello", (req, ctx) -> {
            return ctx.ack(":wave: Hello!");
        });

        app.command("/echo", (req, ctx) -> {
            return ctx.ack(req.getRequestBodyAsString() + ctx.getBotId());
        });

        SlackAppServer server = new SlackAppServer(app);
        server.start(); // http://localhost:3000/slack/events
    }

}
