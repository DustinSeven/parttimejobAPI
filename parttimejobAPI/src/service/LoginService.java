package service;

import java.util.List;

import serviceImp.ILoginService;

import daoImp.IUserAccountDAO;
import daoImp.IUserInfoDAO;
import daoImp.IUserSettingDAO;
import model.UserAccount;
import model.UserInfo;
import model.UserSetting;

public class LoginService implements ILoginService 
{
	private IUserAccountDAO userAccountDAO;
	private IUserInfoDAO userInfoDAO;
	private IUserSettingDAO userSettingDAO;
	

	public IUserSettingDAO getUserSettingDAO() {
		return userSettingDAO;
	}

	public void setUserSettingDAO(IUserSettingDAO userSettingDAO) {
		this.userSettingDAO = userSettingDAO;
	}

	public IUserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}

	public void setUserInfoDAO(IUserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}

	/* (non-Javadoc)
	 * @see service.ILoginService#getUserAccountDAO()
	 */
	@Override
	public IUserAccountDAO getUserAccountDAO() {
		return userAccountDAO;
	}

	/* (non-Javadoc)
	 * @see service.ILoginService#setUserAccountDAO(dao.IUserAccountDAO)
	 */
	@Override
	public void setUserAccountDAO(IUserAccountDAO userAccountDAO) {
		this.userAccountDAO = userAccountDAO;
	}
	
	/* (non-Javadoc)
	 * @see service.ILoginService#checkAccount(model.UserAccount)
	 */
	@Override
	public String checkAccount (UserAccount account)
	{
		
		List accountList = userAccountDAO.findByProperty("mobile", account.getMobile());
		if(accountList.size() == 0)
			return "mobile wrong";
		for(int i = 0;i<accountList.size();++i)
		{
			UserAccount tmpAccount = (UserAccount)accountList.get(i);
			if(tmpAccount.getPassword().equals(account.getPassword()))
				return String.valueOf(tmpAccount.getUserid());
		}
		return "password wrong";
	}
	
	public UserAccount getAccount (UserAccount account)
	{
		
		List accountList = userAccountDAO.findByProperty("mobile", account.getMobile());
		if(accountList.size() == 0)
			return null;
		for(int i = 0;i<accountList.size();++i)
		{
			UserAccount tmpAccount = (UserAccount)accountList.get(i);
			if(tmpAccount.getPassword().equals(account.getPassword()))
				return (UserAccount) accountList.get(0);
		}
		return null;
	}
	
	public boolean addAccount(UserAccount userAccount)
	{
		if(userAccountDAO.findByProperty("mobile", userAccount.getMobile()).size() == 0)
		{
			userAccountDAO.save(userAccount);
			
			UserAccount account = (UserAccount) userAccountDAO.findByProperty("mobile",  userAccount.getMobile()).get(0);
			UserInfo userInfo = new UserInfo();
			userInfo.setUserid(account.getUserid());
			userInfoDAO.save(userInfo);
			
			UserSetting userSetting = new UserSetting();
			userSetting.setUserid(account.getUserid());
			userSetting.setPrivacy(0);
			userSettingDAO.save(userSetting);
			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void changePwd(UserAccount userAccount)
	{
		userAccountDAO.merge(userAccount);
	}
}
