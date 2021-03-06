package com.hui.cloud.txlcn;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <code>TxLcnApplication</code>
 * <desc>
 * <p>
 * <desc/>
 * Creation Time: 2019/9/21 0:01.
 *
 * @author Gary.Hu
 */
@EnableTransactionManagerServer
@SpringBootApplication
@EnableDiscoveryClient
public class TxLcnApplication {
    public static void main(String[] args) {
        SpringApplication.run(TxLcnApplication.class, args);
    }
}
