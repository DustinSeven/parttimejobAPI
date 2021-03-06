package serviceImp;

import model.EnterpriseAccount;
import model.EnterpriseInfo;
import model.UserAccount;
import daoImp.IEnterpriseAccountDAO;
import daoImp.IEnterpriseInfoDAO;

public interface IEnterpriseLoginService {

	public abstract IEnterpriseAccountDAO getEnterpriseAccountDAO();

	public abstract void setEnterpriseAccountDAO(
			IEnterpriseAccountDAO enterpriseAccountDAO);

	public abstract String checkAccount(EnterpriseAccount account);
	
	public abstract IEnterpriseInfoDAO getEnterpriseInfoDAO();
	public abstract void setEnterpriseInfoDAO(IEnterpriseInfoDAO enterpriseInfoDAO);
	public abstract EnterpriseInfo getEnterpriseInfo(String id);
	public abstract boolean addAccount(EnterpriseAccount account);
	public abstract void changePwd(EnterpriseAccount Account);
	public abstract EnterpriseAccount getAccount (EnterpriseAccount account);
	public abstract void updateUserInfo(EnterpriseInfo userInfo);
}