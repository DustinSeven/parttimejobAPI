package service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import serviceImp.IUserInfoService;

import daoImp.IUserInfoDAO;
import model.UserInfo;

public class UserInfoService implements IUserInfoService
{
	private IUserInfoDAO userInfoDAO;

	/* (non-Javadoc)
	 * @see service.IGetUserInfoService#getUserInfoDAO()
	 */
	@Override
	public IUserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}

	/* (non-Javadoc)
	 * @see service.IGetUserInfoService#setUserInfoDAO(dao.IUserInfoDAO)
	 */
	@Override
	public void setUserInfoDAO(IUserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}
	
	/* (non-Javadoc)
	 * @see service.IGetUserInfoService#getUserInfo(long)
	 */
	@Override
	public UserInfo getUserInfo(long id)
	{
		UserInfo tmpUserInfo = userInfoDAO.findById(id);
		if(tmpUserInfo != null)
			return tmpUserInfo;
		return null;
	}
	
	public void updateUserInfo(UserInfo userInfo)
	{
		userInfoDAO.attachDirty(userInfo);
	}
	
	public UserInfo getUserInfoById(long id)
	{
		UserInfo userInfo = userInfoDAO.findById(id);
		return userInfo;
	}

}
