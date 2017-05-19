package framework.services;

public class UserService {

	
	public User getCurrentUser(){
		User u = new User();
		u.setEmail("kureem@gmail.com");
		u.setFirstName("Kureem");
		u.setLastName("Rossaye");
		u.setId(23l);
		u.setProfilePic("http://demo.interface.club/limitless/layout_1/LTR/default/assets/images/demo/users/face11.jpg");
		u.setUsername("kureem@gmail.com");
		u.setAddressLine1("Tagore Lane");
		u.setAddressLine2("Mesnil");
		u.setCity("Phoenix");
		u.setCountry("Mauritius");
		u.setPostalCode("3245");
		return u;
	}
}
