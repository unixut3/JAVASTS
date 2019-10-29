package com.mybatis3.dao;

public class AddressDaoMain {

	public static void main(String[] args) {
		/*******************AddressDao.findAddressById()**************/
		AddressDao addressDao=new AddressDao();
		System.out.println("###"+addressDao.findAddressById(1));
		System.out.println("###"+addressDao.findAddressByIdResultMap(2));
	}

}
