package com.ztf.service.impl;

import java.util.List;

import com.ztf.bean.EmpBean;
import com.ztf.dao.IEmpDao;
import com.ztf.service.IEmpService;

public class EmpServiceImpl implements IEmpService {

	private IEmpDao empDao;
	
	public void setEmpDao(IEmpDao empDao) {
		this.empDao = empDao;
	}

	public List<EmpBean> queryEmp() {
		
		List<EmpBean> list = null;
		try{
			list = empDao.queryDao();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

}
