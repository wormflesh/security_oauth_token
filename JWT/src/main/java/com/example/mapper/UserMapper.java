package com.example.mapper;

import com.example.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wormflesh
 * @since 2022-12-01
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT *\n" +
            "FROM wf_user\n" +
            "WHERE user_login = #{userLogin}")
    User selectByUserLogin(@Param("userLogin") String userLogin);
}
