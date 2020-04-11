package com.example.cloud.democloud.dao;

import com.example.cloud.democloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Description:
 * User: zhangll
 * Date: 2020-04-11
 * Time: 10:59
 */
@Repository
public interface UserRespository extends JpaRepository<User,Long> {

}
