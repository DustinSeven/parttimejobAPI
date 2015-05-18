package daoImp;

import java.util.List;

import model.UserSetting;

public interface IUserSettingDAO {

	public abstract void save(UserSetting transientInstance);

	public abstract void delete(UserSetting persistentInstance);

	public abstract UserSetting findById(java.lang.Long id);

	public abstract List findByExample(UserSetting instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract UserSetting merge(UserSetting detachedInstance);

	public abstract void attachDirty(UserSetting instance);

	public abstract void attachClean(UserSetting instance);

}