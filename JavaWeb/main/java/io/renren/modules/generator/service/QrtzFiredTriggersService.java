package io.renren.modules.generator.service;

import io.renren.modules.generator.entity.QrtzFiredTriggersEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-10-20 10:54:53
 */
public interface QrtzFiredTriggersService {
	
	QrtzFiredTriggersEntity queryObject(String schedName);
	
	List<QrtzFiredTriggersEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(QrtzFiredTriggersEntity qrtzFiredTriggers);
	
	void update(QrtzFiredTriggersEntity qrtzFiredTriggers);
	
	void delete(String schedName);
	
	void deleteBatch(String[] schedNames);
}
