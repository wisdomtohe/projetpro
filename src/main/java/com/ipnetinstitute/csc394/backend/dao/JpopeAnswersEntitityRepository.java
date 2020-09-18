package com.ipnetinstitute.csc394.backend.dao;

import com.ipnetinstitute.csc394.backend.entity.JpopeAnswers;
import com.ipnetinstitute.csc394.backend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;


@Transactional
public interface JpopeAnswersEntitityRepository extends JpaRepository<JpopeAnswers, Long> {

    @Query(value = "select sum(course_survey) from jpope_answers ", nativeQuery = true)
    int totalCS();

    @Query(value = "select sum(doctor_help) from jpope_answers ", nativeQuery = true)
    int totalDH();

    @Query(value = "select sum(piigo) from jpope_answers ", nativeQuery = true)
    int totalPiigo();

    @Query(value = "select sum(ahoe_gnoe) from jpope_answers ", nativeQuery = true)
    int totalAH();

    @Query(value = "select sum(cisco_ise) from jpope_answers ", nativeQuery = true)
    int totalCI();

    @Query(value = "select sum(detection_intrusion) from jpope_answers ", nativeQuery = true)
    int totalDI();

    @Query(value = "select sum(mayaki) from jpope_answers ", nativeQuery = true)
    int totalMK();

    @Query(value = "select sum(nessus) from jpope_answers ", nativeQuery = true)
    int totalNS();

    @Query(value = "select sum(siem) from jpope_answers ", nativeQuery = true)
    int totalSiem();

    @Query(value = "select sum(to_ip) from jpope_answers ", nativeQuery = true)
    int totalTI();


}
