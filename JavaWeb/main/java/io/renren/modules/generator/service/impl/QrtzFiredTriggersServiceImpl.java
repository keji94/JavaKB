package io.renren.modules.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.generator.dao.QrtzFiredTriggersDao;
import io.renren.modules.generator.entity.QrtzFiredTriggersEntity;
import io.renren.modules.generator.service.QrtzFiredTriggersService;



@Service("qrtzFiredTriggersService")
public class QrtzFiredTriggersServiceImpl implements QrtzFiredTriggersService {
	@Autowired
	private QrtzFiredTriggersDao qrtzFiredTriggersDao;
	
	@Override
	public QrtzFiredTriggersEntity queryObject(String schedName){
		return qrtzFiredTriggersDao.queryObject(schedName);
	}
	
	@Override
	public List<QrtzFiredTriggersEntity> queryList(Map<String, Object> map){
		return qrtzFiredTriggersDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return qrtzFiredTriggersDao.queryTotal(map);
	}
	
	@Override
	public void save(QrtzFiredTriggersEntity qrtzFiredTriggers){
		qrtzFiredTriggersDao.save(qrtzFiredTriggers);
	}
	
	@Override
	public void update(QrtzFiredTriggersEntity qrtzFiredTriggers){
		qrtzFiredTriggersDao.update(qrtzFiredTriggers);
	}
	
	@Override
	public void delete(String schedName){
		qrtzFiredTriggersDao.delete(schedName);
	}
	
	@Override
	public void deleteBatch(String[] schedNames){
		qrtzFiredTriggersDao.deleteBatch(schedNames);
	}
	
}
