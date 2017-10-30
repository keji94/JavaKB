package io.renren.modules.generator.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.QrtzFiredTriggersEntity;
import io.renren.modules.generator.service.QrtzFiredTriggersService;
import io.renren.modules.generator.utils.PageUtils;
import io.renren.modules.generator.utils.Query;
import io.renren.modules.generator.utils.R;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-10-20 10:54:53
 */
@RestController
@RequestMapping("qrtzfiredtriggers")
public class QrtzFiredTriggersController {
	@Autowired
	private QrtzFiredTriggersService qrtzFiredTriggersService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("qrtzfiredtriggers:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<QrtzFiredTriggersEntity> qrtzFiredTriggersList = qrtzFiredTriggersService.queryList(query);
		int total = qrtzFiredTriggersService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(qrtzFiredTriggersList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{schedName}")
	@RequiresPermissions("qrtzfiredtriggers:info")
	public R info(@PathVariable("schedName") String schedName){
		QrtzFiredTriggersEntity qrtzFiredTriggers = qrtzFiredTriggersService.queryObject(schedName);
		
		return R.ok().put("qrtzFiredTriggers", qrtzFiredTriggers);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("qrtzfiredtriggers:save")
	public R save(@RequestBody QrtzFiredTriggersEntity qrtzFiredTriggers){
		qrtzFiredTriggersService.save(qrtzFiredTriggers);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("qrtzfiredtriggers:update")
	public R update(@RequestBody QrtzFiredTriggersEntity qrtzFiredTriggers){
		qrtzFiredTriggersService.update(qrtzFiredTriggers);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("qrtzfiredtriggers:delete")
	public R delete(@RequestBody String[] schedNames){
		qrtzFiredTriggersService.deleteBatch(schedNames);
		
		return R.ok();
	}
	
}
