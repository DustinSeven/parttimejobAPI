package daoImp;

import java.util.List;

import model.EnterpriseInfo;

public interface IEnterpriseInfoDAO {

	public abstract void save(EnterpriseInfo transientInstance);

	public abstract void delete(EnterpriseInfo persistentInstance);

	public abstract EnterpriseInfo findById(java.lang.Long id);

	public abstract List findByExample(EnterpriseInfo instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract EnterpriseInfo merge(EnterpriseInfo detachedInstance);

	public abstract void attachDirty(EnterpriseInfo instance);

	public abstract void attachClean(EnterpriseInfo instance);

}