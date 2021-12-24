package dev.uedercardoso.websocket.web.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.HtmlUtils;

import dev.uedercardoso.websocket.web.domain.model.Greeting;
import dev.uedercardoso.websocket.web.domain.model.HelloMessage;

@Controller
public class GreetingController {

		
  @MessageMapping("/hello")
  @SendTo("/topic/greetings")
  public Greeting greeting(@RequestBody HelloMessage message) throws Exception {
    Thread.sleep(1000);
    return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
  }

}