package Com.ttn.Services.ServiceInterfaces;


import Com.ttn.Domains.User;

public interface UserService {

	User findById(int id);
	
	User findBySso(String sso);
	
}