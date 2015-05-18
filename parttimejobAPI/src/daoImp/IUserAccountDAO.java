package daoImp;

import java.util.List;

import model.UserAccount;

public interface IUserAccountDAO {

	public abstract void save(UserAccount transientInstance);

	public abstract void delete(UserAccount persistentInstance);

	public abstract UserAccount findById(java.lang.Long id);

	public abstract List findByExample(UserAccount instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract UserAccount merge(UserAccount detachedInstance);

	public abstract void attachDirty(UserAccount instance);

	public abstract void attachClean(UserAccount instance);

}