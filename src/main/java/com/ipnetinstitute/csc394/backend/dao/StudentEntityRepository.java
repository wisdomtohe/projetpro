package com.ipnetinstitute.csc394.backend.dao;
import javax.transaction.Transactional;
import com.ipnetinstitute.csc394.backend.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//@NoRepositoryBean
@Transactional
public interface StudentEntityRepository extends BaseEntityRepository<Student> {

    @Query(value = "select u.* , s.id as sid, s.matricule, s.create_date_time scdt, " +
            "s.mod_date_time  smdt from student s inner join  " +
            "users u where s.id_user = u.id ", nativeQuery = true)
    List<Student> findAllStudentWithTheirUser();

//    @Query(value = "select st.* from student st , user_is_student uis"+
//            "where uis.id_student = st.id and uis.id_user = :userId", nativeQuery = true)
    @Query(value = "SELECT st.* from student st inner join user_is_student uis "+
            "on st.id = uis.id_student where uis.id_user = :userId", nativeQuery = true)
    Student findStudentByUserId(@Param("userId") Long userId);

    @Query(value = "select uis.id_student from user_is_student uis where uis.id_user = :userId",
    nativeQuery = true)
    Long studentLoggedIn(@Param("userId") Long userId);

    @Query(value = "select uit.id_teacher from user_is_teacher uit where uit.id_user = :userId",
    nativeQuery = true)
    Long teacherLoggedIn(@Param("userId") Long userId);
}
