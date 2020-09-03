package com.ipnetinstitute.csc394.backend.dao;

import com.ipnetinstitute.csc394.backend.entity.Response;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ResponseEntityRepository extends BaseEntityRepository<Response>{

    List<Response> getResponses();
}
