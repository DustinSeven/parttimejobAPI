package service;

import serviceImp.IAdviceService;
import model.Advice;
import model.UserAccount;
import daoImp.IAdviceDAO;
import daoImp.IUserAccountDAO;

public class AdviceService implements IAdviceService {
	
	private IAdviceDAO adviceDAO;
	private IUserAccountDAO userAccountDAO;
	
	

	/* (non-Javadoc)
	 * @see service.IAdviceService#getUserAccountDAO()
	 */
	@Override
	public IUserAccountDAO getUserAccountDAO() {
		return userAccountDAO;
	}

	/* (non-Javadoc)
	 * @see service.IAdviceService#setUserAccountDAO(daoImp.IUserAccountDAO)
	 */
	@Override
	public void setUserAccountDAO(IUserAccountDAO userAccountDAO) {
		this.userAccountDAO = userAccountDAO;
	}

	/* (non-Javadoc)
	 * @see service.IAdviceService#getAdviceDAO()
	 */
	@Override
	public IAdviceDAO getAdviceDAO() {
		return adviceDAO;
	}

	/* (non-Javadoc)
	 * @see service.IAdviceService#setAdviceDAO(daoImp.IAdviceDAO)
	 */
	@Override
	public void setAdviceDAO(IAdviceDAO adviceDAO) {
		this.adviceDAO = adviceDAO;
	}
	
	/* (non-Javadoc)
	 * @see service.IAdviceService#saveAdvice(long, java.lang.String)
	 */
	@Override
	public void saveAdvice(long userId,String content)
	{
		UserAccount user = userAccountDAO.findById(userId);
		Advice advice = new Advice();
		advice.setUserAccount(user);
		advice.setContent(content);
		
		adviceDAO.save(advice);
	}

}
