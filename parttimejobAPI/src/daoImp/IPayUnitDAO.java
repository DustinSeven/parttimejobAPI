package daoImp;

import java.util.List;

import model.PayUnit;

public interface IPayUnitDAO {

	public abstract void save(PayUnit transientInstance);

	public abstract void delete(PayUnit persistentInstance);

	public abstract PayUnit findById(java.lang.Long id);

	public abstract List findByExample(PayUnit instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract PayUnit merge(PayUnit detachedInstance);

	public abstract void attachDirty(PayUnit instance);

	public abstract void attachClean(PayUnit instance);

}