package daoImp;

import java.util.List;

import model.UserInfo;

public interface IUserInfoDAO {

	public abstract void save(UserInfo transientInstance);

	public abstract void delete(UserInfo persistentInstance);

	public abstract UserInfo findById(java.lang.Long id);

	public abstract List findByExample(UserInfo instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract UserInfo merge(UserInfo detachedInstance);

	public abstract void attachDirty(UserInfo instance);

	public abstract void attachClean(UserInfo instance);

}