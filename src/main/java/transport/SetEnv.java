/**
 * This has all the test cases and examples to send mails.
 * @author shruti.sinha
 *
 */
package transport;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * <br>
 * This class sets up the environment with BASE_URL and METHOD <br>
 * It uses descriptor.json file to set up the data.<br>
 *
 */
public class SetEnv {
    public static String BASE_URL	=	null;
    public static String METHOD		=	null;

    static {
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(new FileReader(new File("src\\descriptor.json").getAbsolutePath()));

            JSONObject jsonObject   =   (JSONObject)obj;
            jsonObject              =   (JSONObject)jsonObject.get("service");
            String host             =   (String) jsonObject.get("host");
            jsonObject              =   (JSONObject)jsonObject.get("endpoints");
            jsonObject              =   (JSONObject)jsonObject.get("SendEmail");
            String method           =   (String) jsonObject.get("method");
            String requestUri       =   (String) jsonObject.get("requestUri");

            BASE_URL                =   host + requestUri;
            METHOD                  =   method;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
