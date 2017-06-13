import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Twitter {
	   // Host
    private static final String BRONTO_HOST = "https://api.twitter.com"; // "http://rest.bronto.com";

    // Paths - Includes Add Cart, Update Cart, and Abandon Cart because you will complete all of these actions in this tutorial.
    private static final String GET_TOKEN_PATH = "oauth2/token";
    private static final String ADD_CART_PATH = "carts";
    private static final String GET_CART_PATH = "carts/{cartId}";
    private static final String UPDATE_CART_PATH = "carts/{cartId}";
    private static final String CART_ID = "cartId";
    private static final String CREATE_CONTACT = "createContact";
    private static final String IGNORE_INVALID_TRACKING = "ignoreInvalidTracking";

    // OAuth Request property names
    private static final String GRANT_TYPE = "grant_type";
    private static final String CLIENT_ID = "client_id";
    private static final String CLIENT_SECRET = "client_secret";

    // OAuth Request property values
    private static final String CLIENT_CREDENTIALS = "client_credentials";
    private static final String EXAMPLE_CLIENT_ID = "7LuUEJxzr54zjZWKQ33Xbh9Mp";
    private static final String EXAMPLE_CLIENT_SECRET = "BBtcoOlA03jNKZzxAkgoNeaWuTmG9eWqmVP8ci3s7p79jemuDE";
    private static final String REASON_HEADER = "X-Reason";

    private static final String ACCESS_TOKEN = "access_token";
    
	public static void main(String[] args) {
	    Client client = ClientBuilder.newClient();
	
	    // To be able to access Orders Rest API, you need an access token.
	    // First, we build the request data needed to gain an access token
	    Form requestData = new Form();
	    requestData.param(GRANT_TYPE, CLIENT_CREDENTIALS);
	    requestData.param(CLIENT_ID, EXAMPLE_CLIENT_ID);
	    requestData.param(CLIENT_SECRET, EXAMPLE_CLIENT_SECRET);
	
	    // Then build and send the request
	    Response oauthResponse = client.target(BRONTO_HOST)
	            .path(GET_TOKEN_PATH)
	            .request(MediaType.APPLICATION_JSON)
	            .post(Entity.form(requestData));
	
	    if (oauthResponse.getStatus() != Response.Status.OK.getStatusCode()) {
	        throw new RuntimeException("Unable to get access token.");
	    }
	
	    // Retrieve the access token from the response
	    Map<String, Object> responseData = oauthResponse.readEntity(Map.class);
	    String accessToken = (String) responseData.get(ACCESS_TOKEN);
	   // UUID accessToken = UUID.fromString((String) at); //responseData.get(ACCESS_TOKEN));
	    System.out.print("accessToken : " + accessToken);
	    
	     // Add the Cart
	    //https://api.twitter.com/1.1/search/tweets.json?q=%40twitterapi
        Response getResponse = client.target("https://api.twitter.com")
                .path("1.1/search/tweets.json")
                .queryParam("q", "%40twitterapi")
                //.queryParam(IGNORE_INVALID_TRACKING, true)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + accessToken)
                .get();

             

        if (getResponse.getStatus() != 200 /*Response.Status.CREATED.getStatusCode()*/) {
            String reason = getResponse.getHeaderString(REASON_HEADER);
            throw new RuntimeException("Unable to add Cart. Reason=" + reason);
        }
        
        // Retrieve the Cart from the response
        Map<String, Object> existing = getResponse.readEntity(Map.class);
        System.out.println(existing);

   }
}
