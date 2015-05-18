package serviceImp;

import daoImp.IAdviceDAO;
import daoImp.IUserAccountDAO;

public interface IAdviceService {

	public abstract IUserAccountDAO getUserAccountDAO();

	public abstract void setUserAccountDAO(IUserAccountDAO userAccountDAO);

	public abstract IAdviceDAO getAdviceDAO();

	public abstract void setAdviceDAO(IAdviceDAO adviceDAO);

	public abstract void saveAdvice(long userId, String content);

}