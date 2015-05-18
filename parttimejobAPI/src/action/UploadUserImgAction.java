package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import serviceImp.ILoginService;
import serviceImp.IUserInfoService;

import model.UserAccount;
import model.UserInfo;

import org.apache.struts2.ServletActionContext;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tool.ResultUtil;

public class UploadUserImgAction 
{
	private File userimage;
	private IUserInfoService userInfoService;
	private ILoginService loginService;
	private String mobile;
	private String pwd;

	public File getUserimage() {
		return userimage;
	}

	public void setUserimage(File userimage) {
		this.userimage = userimage;
	}

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
	
	public IUserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(IUserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public ILoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	public String execute() {
		
		UserAccount tmpAccount = new UserAccount();
		tmpAccount.setMobile(mobile);
		tmpAccount.setPassword(pwd);
		
		String result = loginService.checkAccount(tmpAccount);

		if(result.equals("password wrong"))
			ResultUtil.returnJsonWithCode500(ServletActionContext.getResponse(), null,"密码错误！");
		else if(result.equals("mobile wrong"))
			ResultUtil.returnJsonWithCode500(ServletActionContext.getResponse(), null,"用户账号不存在！");
		else
		{
			try {
				InputStream is = new FileInputStream(userimage);
				String root = ServletActionContext.getRequest().getRealPath("/userimage");
				File dir = new File(root);
				if(!dir.exists())
				{
					dir.mkdir();
				}
				String fileName = mobile + "&" + System.currentTimeMillis() + ".png";
				File destFile = new File(root,fileName);
				OutputStream os = new FileOutputStream(destFile);
				byte[] buffer = new byte[400];
				int length  = 0 ;
				while((length = is.read(buffer))>0){
				os.write(buffer, 0, length);
				}
				is.close();
				os.close();
				
				UserAccount account = loginService.getAccount(tmpAccount);
				UserInfo userInfo = userInfoService.getUserInfo(account.getUserid());
				if(userInfo != null)
				{
					userInfo.setImg("/parttimejobAPI/userimage/" + fileName);
					userInfoService.updateUserInfo(userInfo);
				}
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("userimage", "/parttimejobAPI/userimage/" + fileName);
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				list.add(map);
				
				ResultUtil.returnJsonWithCode200(ServletActionContext.getResponse(), list,"头像修改成功！");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				ResultUtil.returnJsonWithCode500(ServletActionContext.getResponse(), null,"头像修改失败！");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				ResultUtil.returnJsonWithCode500(ServletActionContext.getResponse(), null,"头像修改失败！");
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
}
