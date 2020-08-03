package com.ipnetinstitute.csc394.backend.dao;

import com.ipnetinstitute.csc394.backend.entity.QRemarks;

import javax.transaction.Transactional;

@Transactional
public interface QRemarksEntityRepository extends BaseEntityRepository<QRemarks> {
}
