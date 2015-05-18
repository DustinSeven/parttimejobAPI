package serviceImp;

import model.UserAccount;
import daoImp.IUserAccountDAO;
import daoImp.IUserInfoDAO;

public interface ILoginService {

	public abstract IUserAccountDAO getUserAccountDAO();

	public abstract void setUserAccountDAO(IUserAccountDAO userAccountDAO);

	public abstract String checkAccount(UserAccount account);
	
	public abstract UserAccount getAccount (UserAccount account);
	
	public abstract boolean addAccount(UserAccount userAccount);

	public abstract IUserInfoDAO getUserInfoDAO();
	
	public abstract void setUserInfoDAO(IUserInfoDAO userInfoDAO);
	
	public abstract void changePwd(UserAccount userAccount);

}