package com.springmvcstudy.ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
class TxServiceB {
    @Autowired B1Dao b1Dao;

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void insertB1WithTx() throws Exception {
        b1Dao.insert(1,100);    // ok
        b1Dao.insert(1,200);    // false
    }

}
@Service
public class TxService {
    @Autowired A1Dao a1Dao;
    @Autowired B1Dao b1Dao;

    @Autowired TxServiceB txServiceB;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertA1WithTx() throws Exception {
        a1Dao.insert(1,100);    // ok
        txServiceB.insertB1WithTx();
        a1Dao.insert(2,200);    // ok
    }


    public void insertA1WithoutTx() throws Exception {
        a1Dao.insert(1, 100);
        a1Dao.insert(1, 100);
    }

    //    @Transactional // runtime 에러만 rollback
    @Transactional(rollbackFor = Exception.class)  // - Exception을 롤백
    public void insertA1WithTxFail() throws  Exception{
        a1Dao.insert(1, 100);
    //        throw new RuntimeException();
    //    throw new Exception();
        a1Dao.insert(1, 200);
    }

    @Transactional
    public void insertA1WithTxSuccess() throws  Exception{
        a1Dao.insert(1, 100);
        a1Dao.insert(2, 100);
    }

}
