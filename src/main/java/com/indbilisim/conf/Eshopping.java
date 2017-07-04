package com.indbilisim.conf;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by semih on 04.07.2017.
 */

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableTransactionManagement
//@ImportResource("classpath:spring-config.xml")
public class Eshopping {

}
