package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.UserAccount;

import org.apache.struts2.ServletActionContext;

import serviceImp.ILoginService;
import serviceImp.IUserSettingService;
import tool.ResultUtil;

public class GetUserSettingAction {
	
	private IUserSettingService userSettingService;
	private ILoginService loginService;
	private String mobile;
	private String pwd;
	private long userid;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public ILoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	public IUserSettingService getUserSettingService() {
		return userSettingService;
	}

	public void setUserSettingService(IUserSettingService userSettingService) {
		this.userSettingService = userSettingService;
	}
	
	public String execute() {

		UserAccount tmpAccount = new UserAccount();
		tmpAccount.setMobile(mobile);
		tmpAccount.setPassword(pwd);

		String result = loginService.checkAccount(tmpAccount);

		if (result.equals("password wrong"))
			ResultUtil.returnJsonWithCode500(
					ServletActionContext.getResponse(), null, "�������");
		else if (result.equals("mobile wrong"))
			ResultUtil.returnJsonWithCode500(
					ServletActionContext.getResponse(), null, "�û��˺Ų����ڣ�");
		else {
			
			int privacy = userSettingService.getUserPrivacy(userid);
			List list = new ArrayList();
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("opentoalumnus", privacy);
			list.add(map);
			ResultUtil.returnJsonWithCode200(
					ServletActionContext.getResponse(), list, "��ȡ�ɹ���");
		}
		
		return null;
	}

}
