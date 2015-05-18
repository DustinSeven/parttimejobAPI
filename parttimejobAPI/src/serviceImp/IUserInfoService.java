package serviceImp;

import model.UserInfo;
import daoImp.IUserInfoDAO;

public interface IUserInfoService {

	public abstract IUserInfoDAO getUserInfoDAO();

	public abstract void setUserInfoDAO(IUserInfoDAO userInfoDAO);

	public abstract UserInfo getUserInfo(long id);
	
	public abstract void updateUserInfo(UserInfo userInfo);
	
	public abstract UserInfo getUserInfoById(long id);

}