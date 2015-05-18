package daoImp;

import java.util.List;

import model.EnterpriseAccount;

public interface IEnterpriseAccountDAO {

	public abstract void save(EnterpriseAccount transientInstance);

	public abstract void delete(EnterpriseAccount persistentInstance);

	public abstract EnterpriseAccount findById(java.lang.Long id);

	public abstract List findByExample(EnterpriseAccount instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract EnterpriseAccount merge(EnterpriseAccount detachedInstance);

	public abstract void attachDirty(EnterpriseAccount instance);

	public abstract void attachClean(EnterpriseAccount instance);

}