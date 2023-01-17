package com.library.demo.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.library.demo.service.Payment;

@Service
public class PaymentServiceImpl implements Payment {
	
	private static Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

	@Override
	public void printDetail() {
		// TODO Auto-generated method stub
		logger.info("This is PaymentServiceImpl Class");
	}

}
