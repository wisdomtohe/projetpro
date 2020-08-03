package com.ipnetinstitute.csc394.backend.dao;

import com.ipnetinstitute.csc394.backend.entity.QInfos;

import javax.transaction.Transactional;

@Transactional
public interface QInfosEntityRepository extends BaseEntityRepository<QInfos> {
}
