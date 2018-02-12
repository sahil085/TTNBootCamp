package Com.ttn.Dao.DaoClasses;


import Com.ttn.Dao.DaoInterfaces.UserDao;
import Com.ttn.Domains.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	public User findById(int id) {
		return getByKey(id);
	}

	public User findBySSO(String email) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("userName", email));
		return (User) crit.uniqueResult();
	}

	
}
