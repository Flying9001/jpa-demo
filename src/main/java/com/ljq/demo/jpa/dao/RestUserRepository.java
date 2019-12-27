package com.ljq.demo.jpa.dao;

import com.ljq.demo.jpa.model.entity.RestUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * REST示例-用户表数据传输仓库
 * 
 * @author junqiang.lu
 * @date 2019-12-26 15:15:33
 */
@Repository()
public interface RestUserRepository extends JpaRepository<RestUserEntity,Long> ,
        JpaSpecificationExecutor<RestUserEntity>{

    /**
     * 依据 id 查询
     *
     * @param id
     * @param delSign
     * @return
     */
    Optional<RestUserEntity> findByIdAndDelSign(@Param("id") long id, @Param("delSign") int delSign);
	
}
