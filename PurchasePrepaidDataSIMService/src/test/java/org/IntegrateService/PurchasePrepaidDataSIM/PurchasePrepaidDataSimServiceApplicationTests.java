package org.IntegrateService.PurchasePrepaidDataSIM;

import org.IntegrateService.PurchasePrepaidDataSIM.ApplicationLogic.HistoryPurchase.HistoryPurchaseReaderImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class PurchasePrepaidDataSimServiceApplicationTests {
  @Autowired
  private ApplicationContext context;

  @Test
  public void testService() {
    Assertions.assertTrue(context.getBean(HistoryPurchaseReaderImpl.class) != null);
  }

}
