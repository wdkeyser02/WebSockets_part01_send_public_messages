package willydekeyser.demo_websockets.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import willydekeyser.demo_websockets.model.GreetingRequest;
import willydekeyser.demo_websockets.model.GreetingResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class GreetingController {

    @MessageMapping("/message")
    @SendTo("/topic/greetings")
    GreetingResponse greet(GreetingRequest request) {
        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        return new GreetingResponse("Hello, " + request.name() + " - " + time);
    }

}
