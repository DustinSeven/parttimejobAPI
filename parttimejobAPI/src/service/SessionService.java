package service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import serviceImp.ISessionService;

import model.EnterpriseAccount;
import model.EnterpriseInfo;
import model.TSession;
import model.UserAccount;
import model.UserInfo;

import daoImp.IEnterpriseAccountDAO;
import daoImp.IEnterpriseInfoDAO;
import daoImp.ITSessionDAO;
import daoImp.IUserAccountDAO;
import daoImp.IUserInfoDAO;

public class SessionService implements ISessionService {
	
	private ITSessionDAO sessionDAO;
	private IUserAccountDAO userAccountDAO;
	private IUserInfoDAO userInfoDAO;
	private IEnterpriseInfoDAO enterpriseInfoDAO;
	private IEnterpriseAccountDAO enterpriseAccountDAO;
	
	
	/* (non-Javadoc)
	 * @see service.ISessionService#getUserInfoDAO()
	 */
	@Override
	public IUserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}
	/* (non-Javadoc)
	 * @see service.ISessionService#setUserInfoDAO(daoImp.IUserInfoDAO)
	 */
	@Override
	public void setUserInfoDAO(IUserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}
	/* (non-Javadoc)
	 * @see service.ISessionService#getEnterpriseAccountDAO()
	 */
	@Override
	public IEnterpriseAccountDAO getEnterpriseAccountDAO() {
		return enterpriseAccountDAO;
	}
	/* (non-Javadoc)
	 * @see service.ISessionService#setEnterpriseAccountDAO(daoImp.IEnterpriseAccountDAO)
	 */
	@Override
	public void setEnterpriseAccountDAO(IEnterpriseAccountDAO enterpriseAccountDAO) {
		this.enterpriseAccountDAO = enterpriseAccountDAO;
	}
	/* (non-Javadoc)
	 * @see service.ISessionService#getSessionDAO()
	 */
	@Override
	public ITSessionDAO getSessionDAO() {
		return sessionDAO;
	}
	/* (non-Javadoc)
	 * @see service.ISessionService#setSessionDAO(daoImp.ITSessionDAO)
	 */
	@Override
	public void setSessionDAO(ITSessionDAO sessionDAO) {
		this.sessionDAO = sessionDAO;
	}
	/* (non-Javadoc)
	 * @see service.ISessionService#getUserAccountDAO()
	 */
	@Override
	public IUserAccountDAO getUserAccountDAO() {
		return userAccountDAO;
	}
	/* (non-Javadoc)
	 * @see service.ISessionService#setUserAccountDAO(daoImp.IUserAccountDAO)
	 */
	@Override
	public void setUserAccountDAO(IUserAccountDAO userAccountDAO) {
		this.userAccountDAO = userAccountDAO;
	}
	/* (non-Javadoc)
	 * @see service.ISessionService#getEnterpriseInfoDAO()
	 */
	@Override
	public IEnterpriseInfoDAO getEnterpriseInfoDAO() {
		return enterpriseInfoDAO;
	}
	/* (non-Javadoc)
	 * @see service.ISessionService#setEnterpriseInfoDAO(daoImp.IEnterpriseInfoDAO)
	 */
	@Override
	public void setEnterpriseInfoDAO(IEnterpriseInfoDAO enterpriseInfoDAO) {
		this.enterpriseInfoDAO = enterpriseInfoDAO;
	}
	
	/* (non-Javadoc)
	 * @see service.ISessionService#saveSession(model.TSession)
	 */
	@Override
	public HashMap<String,Object> saveSession(TSession session)
	{
		HashMap<String,Object> map = new HashMap<String,Object>();
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = f.format(date);
		Timestamp ts = Timestamp.valueOf(dateStr);
		session.setCreatetime(ts);
		sessionDAO.save(session);
		List users = userAccountDAO.findByProperty("mobile", session.getUsermobile());
		if(users.size() > 0)
		{
			UserAccount userAccount = (UserAccount) users.get(0);
			UserInfo userInfo = userInfoDAO.findById(userAccount.getUserid());
			map.put("username", userInfo.getAccount());
			map.put("userimg", userInfo.getImg());
		}
		List enters = enterpriseAccountDAO.findByProperty("mobile", session.getEntermobile());
		if(enters.size() > 0)
		{
			EnterpriseAccount enter = (EnterpriseAccount) enters.get(0);
			EnterpriseInfo enterInfo = enterpriseInfoDAO.findById(enter.getEnterpriseid());
			map.put("entername", enterInfo.getCompany()+"-"+enterInfo.getAccount());
			map.put("enterimg", enterInfo.getImg());
		}
		
		return map;
	}

}
