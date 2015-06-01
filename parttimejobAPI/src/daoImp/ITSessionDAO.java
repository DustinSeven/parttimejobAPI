package daoImp;

import java.util.List;

import model.TSession;

public interface ITSessionDAO {

	//property constants
	public static final String ENTERMOBILE = "entermobile";
	public static final String USERMOBILE = "usermobile";
	public static final String TEXT = "text";
	public static final String ISFROMENTER = "isfromenter";

	public abstract void save(TSession transientInstance);

	public abstract void delete(TSession persistentInstance);

	public abstract TSession findById(java.lang.Long id);

	public abstract List findByExample(TSession instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByEntermobile(Object entermobile);

	public abstract List findByUsermobile(Object usermobile);

	public abstract List findByText(Object text);

	public abstract List findByIsfromenter(Object isfromenter);

	public abstract List findAll();

	public abstract TSession merge(TSession detachedInstance);

	public abstract void attachDirty(TSession instance);

	public abstract void attachClean(TSession instance);

}