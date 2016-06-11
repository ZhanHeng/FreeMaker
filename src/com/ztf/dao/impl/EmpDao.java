package com.ztf.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ztf.bean.EmpBean;
import com.ztf.dao.IEmpDao;

public class EmpDao extends HibernateDaoSupport implements IEmpDao {

	public List<EmpBean> queryDao() {
		SessionFactory sf = this.getHibernateTemplate().getSessionFactory();
		Session session = sf.openSession();
		String hql="from EmpBean";
		Query query = session.createQuery(hql);
		List<EmpBean> list = query.list();
		return list;
	}

}
