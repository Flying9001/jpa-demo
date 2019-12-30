package com.ljq.demo.jpa.dao;

import com.ljq.demo.jpa.model.entity.RestUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
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

    /**
     * 依据邮箱地址统计用户数量
     *
     * @param email
     * @param delSign
     * @return
     */
    long countByEmailAndDelSign(@Param("email") String email, @Param("delSign") int delSign);

    /**
     * 搜索用户
     *
     * @param restUserEntity
     * @param pageable
     * @return
     */
    @Query(value = "SELECT ru.* " +
            "FROM `rest_user` ru " +
            "WHERE ru.del_sign = 0 " +
            "AND (ru.id = :#{#restUserEntity.id} OR :#{#restUserEntity.id} IS NULL) " +
            "AND (ru.user_name LIKE CONCAT(CONCAT('%', :#{#restUserEntity.userName}), '%') " +
            "    OR :#{#restUserEntity.userName} IS NULL ) " +
            "AND (ru.email = :#{#restUserEntity.email} OR :#{#restUserEntity.email} IS NULL) ",
            countQuery = "SELECT COUNT(*) " +
                    "FROM `rest_user` ru " +
                    "WHERE ru.del_sign = 0 " +
                    "AND (ru.id = :#{#restUserEntity.id} OR :#{#restUserEntity.id} IS NULL) " +
                    "AND (ru.user_name LIKE CONCAT(CONCAT('%', :#{#restUserEntity.userName}), '%') " +
                    "    OR :#{#restUserEntity.userName} IS NULL ) " +
                    "AND (ru.email = :#{#restUserEntity.email} OR :#{#restUserEntity.email} IS NULL) ",
            nativeQuery = true)
    Page<RestUserEntity> search(@Param("restUserEntity") RestUserEntity restUserEntity, @Param("pageable") Pageable pageable);
	
}
