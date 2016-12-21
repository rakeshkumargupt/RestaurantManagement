/**
 * Created by rakeshgupta on 12/21/16.
 */
import com.yammer.dropwizard.config.Configuration;

import javax.validation.Valid;

public class ExampleServiceConfiguration extends Configuration {

    @Valid
    private MessagesConfiguration messages;

    public MessagesConfiguration getMessages() {
        return messages;
    }

    public void setMessages(MessagesConfiguration messages) {
        this.messages = messages;
    }
}
