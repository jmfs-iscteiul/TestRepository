package facebookexample;

import java.util.List;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.Post;
import com.restfb.types.User;

public class FacebookMain {
	public static void main(String[] args) {
		/* 
		 * Facebook API Tutorials in Java # 1 | Setup Development Environment 
		 * https://www.youtube.com/watch?v=m14hYs1T3FA&index=1&list=PLYPFxrXyK0BwiXNe09hTPjFqYbsWv8gxb
		 */
		/* 
		 * Facebook API Tutorials in Java # 2 | Get User Access Token
		 * https://www.youtube.com/watch?v=GwbO_PdwK_4&index=2&list=PLYPFxrXyK0BwiXNe09hTPjFqYbsWv8gxb
		 */
		String accessToken = "EAAEdPLJA8d0BAAWQEvACzKgkYZAOI9gPxsZBzpKEzdZBX37IUpoIbl4AMFEv5CNnxsvPn57ffzmEq1HDGE70jEjU9vTH8jwIphJbm2OXyBj2GR58UeOZC00Nsk0xAUNEZBdYsbxgs4G1lWkXQu3HM3ANyDyUc82kNSTwewjwqFfZCzuQ7C2JwFRlCVK2Ao19KEpBcluX3jmwZDZD";
		@SuppressWarnings("deprecation")
		FacebookClient fbClient = new DefaultFacebookClient(accessToken);
		User me2 = fbClient.fetchObject("me", User.class);
		System.out.println("Facebook:");
		System.out.println("Id: " + me2.getId());
		System.out.println("Name: " + me2.getName());

		/* 
		 * Facebook API Tutorials in Java # 4 | Create Your Own Fb APP & Extend User Access Token  
		 * https://www.youtube.com/watch?v=qFZazZ1JXsM&list=PLYPFxrXyK0BwiXNe09hTPjFqYbsWv8gxb&index=5
		 */
		String accessToken4 = "EAAGZBEccjciEBACLQCLnTN82o8ZBa7EtfC80jeEkPFSrZAZB8zunAsYFgo9g0CSWN7jFcXSVuIaqQlN09RBe4IIaQAGc7SqQdedtTQ0wz3Oug6VZAgZA6jNxeWkGE7mjp06s3t3nSgGmTOa4zaV3ZCaZCBPV5PjfcvLQ0rZB1ISq2zNoBjjLs5C7uz6c5e0d6ogItNRM0KbRJQwZDZD";
		FacebookClient fbClient4 = new DefaultFacebookClient(accessToken4);
		AccessToken extendedAccessToken4 = fbClient4.obtainExtendedAccessToken("490458541421089","b4b0922f88578643b1c3795ed4cde605");
		System.out.println("ExtendedAccessToken: "+extendedAccessToken4.getAccessToken());
		System.out.println("Expires: " + extendedAccessToken4.getExpires());
		
		//FEITO

		/* 
		 * Facebook API Tutorials in Java # 5 | Get User Timeline Posts
		 * https://www.youtube.com/watch?v=wiFif4gOdFE&index=6&list=PLYPFxrXyK0BwiXNe09hTPjFqYbsWv8gxb
		*/ 
		String accessToken5 ;//= "EAAGZBEccjciEBAJ37ZAIbHKiL1Mo1HHex2pQTcs41dq8azfBvFGgt4eGgKBq12kSssOof51FKO0niKu7AaVKs3dy8W1ilqp4xcjFD1F9mmjJpVyeDnZAffUXRfh7zXL06BuSwQtfHMJbmJ079qCnkT844brHx966cz73JZBZBFy2Bv1rWu7T1rQddZCVpxywZCO6lDxoWDk2gZDZD";
		accessToken5 = "EAAGZBEccjciEBACLQCLnTN82o8ZBa7EtfC80jeEkPFSrZAZB8zunAsYFgo9g0CSWN7jFcXSVuIaqQlN09RBe4IIaQAGc7SqQdedtTQ0wz3Oug6VZAgZA6jNxeWkGE7mjp06s3t3nSgGmTOa4zaV3ZCaZCBPV5PjfcvLQ0rZB1ISq2zNoBjjLs5C7uz6c5e0d6ogItNRM0KbRJQwZDZD";	
		FacebookClient fbClient5 = new DefaultFacebookClient(accessToken5);

		Connection<Post> result = fbClient5.fetchConnection("me/feed",Post.class);
		System.out.println("\nPosts:");
		int counter5 = 0;
		int counterTotal = 0;
		for (List<Post> page : result) {
			for (Post aPost : page) {
				// Filters only posts that contain the word "Inform"
				if (aPost.getMessage() != null && aPost.getMessage().contains("Mestrado")) {
					System.out.println("---- Post "+ counter5 + " ----");
					System.out.println("Id: "+"fb.com/"+aPost.getId());
					System.out.println("Message: "+aPost.getMessage());
					System.out.println("Created: "+aPost.getCreatedTime());
					counter5++;
				}
				counterTotal++;
			}
		}
		System.out.println("-------------\nN� of Results: " + counter5+"/"+counterTotal);		
	}
}
