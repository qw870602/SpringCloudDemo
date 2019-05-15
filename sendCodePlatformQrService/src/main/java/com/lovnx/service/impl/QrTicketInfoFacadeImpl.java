package com.lovnx.service.impl;



import com.lovnx.entity.QrTicketInfo;
import com.lovnx.mapper.QrTicketInfoMapper;
import com.lovnx.service.QrTicketInfoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(rollbackFor = Exception.class)
public class QrTicketInfoFacadeImpl implements QrTicketInfoFacade {

   @Autowired
   private QrTicketInfoMapper qrTicketInfoMapper;

   @Override
   public void saveQrTicketInfos() {
      QrTicketInfo q1=new QrTicketInfo();
      q1.setQrNo("2018110501");
      q1.setUserNo("mahuateng");
      qrTicketInfoMapper.saveQrTicketInfo(q1);
   }
}
