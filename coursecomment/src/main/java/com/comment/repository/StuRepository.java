package com.comment.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.comment.domain.Student;

@Mapper
public interface StuRepository {

	@Results(id="studentMap", value={ 
	    @Result(property = "sid", column = "s_id",  jdbcType=JdbcType.INTEGER), 
	    @Result(property = "password", column = "s_password"),
	    @Result(property = "name", column = "s_name"),
	    @Result(property = "headImg", column = "s_headImg"),
	    @Result(property = "sclass", column = "s_class"),
	    @Result(property = "school", column = "s_school"),
	    @Result(property = "phone", column = "s_phone"),
	    @Result(property = "email", column = "s_email")
	})

	@Select("select * from student where s_id=#{sid} and s_password=md5(#{password})")
	public Student validStudent(@Param("sid")String sid,@Param("password")String password);
	
	@Update( "update student set s_phone=#{phone},s_email=#{email},s_class=#{sclass} where s_id=#{id}")
	public int updateStudent(@Param("phone")String phone,@Param("email")String email,@Param("sclass")String sclass,@Param("id")String id);

	@Update( "update student set s_password=md5(#{newpassword}) where s_id=#{id}")
	public int updatePwd(@Param("newpassword")String newpassword,@Param("id")String id);

}
