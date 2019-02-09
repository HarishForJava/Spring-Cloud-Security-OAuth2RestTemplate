package com.hfj.cloud.restTemplate.web;
/**
 * @author HFJ
 *
 */
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

public class RestApiUtill {
	public static String BASE_URL = "http://192.168.4.2:8887/resource";
	public static String BASE_OAUTH_URL = "http://192.168.4.2:8886/service/oauth/token";

	public ResourceOwnerPasswordResourceDetails loadDetails() {
		ResourceOwnerPasswordResourceDetails resourceOwnerDetails = new ResourceOwnerPasswordResourceDetails();
		resourceOwnerDetails.setAccessTokenUri(BASE_OAUTH_URL);
		resourceOwnerDetails.setClientId("HarishForJava");
		resourceOwnerDetails.setClientSecret("SorryNoSecret");
		resourceOwnerDetails.setGrantType("password");
		resourceOwnerDetails.setUsername("HFJ");
		resourceOwnerDetails.setPassword("FJH");
		resourceOwnerDetails.setAuthenticationScheme(AuthenticationScheme.header);
		return resourceOwnerDetails;
	}

	public <T> void getRequestUri(String url, Class<T> responseType) throws Exception {
		OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(loadDetails());
		T response = oAuth2RestTemplate.getForObject(BASE_URL + url, responseType);
		System.out.println("OUTPUT" + response);
	}

}
