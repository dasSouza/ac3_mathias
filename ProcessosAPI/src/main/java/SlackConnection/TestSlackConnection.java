package SlackConnection;

import java.io.IOException;
import org.json.JSONObject;

public class TestSlackConnection {

    public static void main(String[] args) throws IOException, InterruptedException, Exception {

        Slack slack = new Slack();
        JSONObject json = new JSONObject();

        json.put("text", "Funcionou :shrug:");

        slack.sendMessage(json);
    }
}
