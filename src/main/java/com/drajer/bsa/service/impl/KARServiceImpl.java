package com.drajer.bsa.service.impl;

import com.drajer.bsa.dao.KarDao;
import com.drajer.bsa.model.KAR;
import com.drajer.bsa.service.KarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KARServiceImpl implements KarService {

  @Autowired KarDao karDao;

  @Override
  public KAR saveOrUpdate(KAR kar) {
    karDao.saveOrUpdate(kar);
    return kar;
  }

  @Override
  public KAR getKARById(Integer id) {
    return karDao.getKARById(id);
  }

  @Override
  public KAR getKARByUrl(String url) {
    return karDao.getKARByUrl(url);
  }

  @Override
  public List<KAR> getAllKARs() {
    return karDao.getAllKARs();
  }
}