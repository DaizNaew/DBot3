package net.daiznaew.dbot3.util.twitter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import net.daiznaew.dbot3.util.twitter.TwitterReferences;

public class TwitterAuth {

	public static void main(String[] args) throws Exception {
 		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(TwitterReferences.CONSUMER_KEY, TwitterReferences.CONSUMER_SECRET);
		RequestToken requestToken = twitter.getOAuthRequestToken();
		AccessToken accessToken = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (null == accessToken) {
			System.out.println("Open the following URL and grant access to your account:");
			System.out.println(requestToken.getAuthorizationURL());
			System.out.print("Enter the PIN (if available) or just hit enter.[PIN]:");
			String pin = br.readLine();
 			try {
				if (pin.length() > 0) {
					accessToken = twitter.getOAuthAccessToken(requestToken, pin);
				} else {
					accessToken = twitter.getOAuthAccessToken();
				}
			} catch (TwitterException e) {
				if (401 == e.getStatusCode()) {
					System.err.println("Unable to get the access token.");
				} else {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Access Token: " + accessToken.getToken());
		System.out.println("Access Token Secret: " + accessToken.getTokenSecret());
	}
}
