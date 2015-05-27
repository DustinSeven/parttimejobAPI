package daoImp;

import java.util.List;

import model.UserJobLongSignin;

public interface IUserJobLongSigninDAO {

	public abstract void save(UserJobLongSignin transientInstance);

	public abstract void delete(UserJobLongSignin persistentInstance);

	public abstract UserJobLongSignin findById(java.lang.Long id);

	public abstract List findByExample(UserJobLongSignin instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract UserJobLongSignin merge(UserJobLongSignin detachedInstance);

	public abstract void attachDirty(UserJobLongSignin instance);

	public abstract void attachClean(UserJobLongSignin instance);

}