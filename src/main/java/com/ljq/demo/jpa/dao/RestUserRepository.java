package com.ljq.demo.jpa.dao;

import com.ljq.demo.jpa.model.entity.RestUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * REST示例-用户表数据传输仓库
 * 
 * @author junqiang.lu
 * @date 2019-12-26 15:15:33
 */
@Repository()
public interface RestUserRepository extends JpaRepository<RestUserEntity,Long> ,
        JpaSpecificationExecutor<RestUserEntity>{
	
}
