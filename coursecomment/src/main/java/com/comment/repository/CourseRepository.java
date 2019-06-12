package com.comment.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.comment.domain.StuCourse;

@Mapper
public interface CourseRepository {

	
	@Select("select c.c_name cname,t.t_name teacher,c.c_score credit,c.c_time ctime,sc.score scores from student_course sc,course c,teacher t where c.c_id=sc.c_id and t.t_id=sc.t_id and s_id=#{sid} ;")
	public List<StuCourse> findCourseByStuId(@Param("sid")String sid);
	
}
