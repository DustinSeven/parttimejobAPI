package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.JobDetail;
import model.JobType;

import org.apache.struts2.ServletActionContext;

import serviceImp.IJobTypeService;
import tool.ResultUtil;

public class GetAllJobTypeAction {

	private IJobTypeService jobTypeService;

	public IJobTypeService getJobTypeService() {
		return jobTypeService;
	}

	public void setJobTypeService(IJobTypeService jobTypeService) {
		this.jobTypeService = jobTypeService;
	}

	public String execute() {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List jobTypes = jobTypeService.getAllJobTyop();
		for (int i = 0; i < jobTypes.size(); ++i) {
			Map<String, Object> map = new HashMap<String, Object>();
			JobType jobType = (JobType) jobTypes.get(i);
			map.put("jobtypeid", jobType.getJobtypeid());
			map.put("jobtypename", jobType.getName());
			list.add(map);
		}

		if (list.size() == 0)
			ResultUtil.returnJsonWithCode300(
					ServletActionContext.getResponse(), null, "�޼�ְ���ͣ�");
		else
			ResultUtil.returnJsonWithCode200(
					ServletActionContext.getResponse(), list, "��ȡ�ɹ���");

		return null;
	}

}
