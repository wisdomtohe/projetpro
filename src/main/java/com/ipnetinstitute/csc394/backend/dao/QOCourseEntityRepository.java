package com.ipnetinstitute.csc394.backend.dao;

import com.ipnetinstitute.csc394.backend.entity.QOCourse;

import javax.transaction.Transactional;

@Transactional
public interface QOCourseEntityRepository extends BaseEntityRepository<QOCourse> {
}
