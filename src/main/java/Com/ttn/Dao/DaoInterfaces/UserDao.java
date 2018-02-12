package Com.ttn.Dao.DaoInterfaces;


import Com.ttn.Domains.User;

public interface UserDao {

	User findById(int id);
	
	User findBySSO(String sso);
	
}

