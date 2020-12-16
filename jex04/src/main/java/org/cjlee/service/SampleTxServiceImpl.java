package org.cjlee.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.cjlee.mapper.Sample1Mapper;
import org.cjlee.mapper.Sample2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j
@RequiredArgsConstructor
public class SampleTxServiceImpl implements SampleTxService {

    private final Sample1Mapper mapper1;
    private final Sample2Mapper mapper2;

    @Transactional // 트랜잭션으로 만들기
    @Override
    public void addData(String data) {
        log.info("mapper 1 ..");
        mapper1.insertCol1(data);

        log.info("mapper 2 ..");
        mapper2.insertCol2(data);

        log.info("end of transaction");

    }
}
