package com.drajer.bsa.dao.impl;

import com.drajer.bsa.dao.KarExecutionStateDao;
import com.drajer.bsa.model.KarExecutionState;
import com.drajer.ecrapp.dao.AbstractDao;
import java.util.List;
import java.util.UUID;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class KarExecutionStateDaoImpl extends AbstractDao implements KarExecutionStateDao {

  @Override
  public KarExecutionState saveOrUpdate(KarExecutionState kar) {
    getSession().saveOrUpdate(kar);
    return kar;
  }

  @Override
  public KarExecutionState getKarExecutionStateById(UUID id) {

    return getSession().get(KarExecutionState.class, id);
  }

  @Override
  public List<KarExecutionState> getAllKarExecutionStates() {
    Criteria criteria = getSession().createCriteria(KarExecutionState.class);
    return criteria.addOrder(Order.desc("id")).list();
  }
}