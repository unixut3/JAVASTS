package com.itwill.guest;

import java.util.ArrayList;
import java.util.List;

public class GuestServiceImpl implements GuestService {
	
	private GuestDao guestDao;

	public GuestServiceImpl() throws Exception{
		System.out.println("3.### GuestServiceImpl():생성자");
	}
	
	public void setGuestDao(GuestDao guestDao) {
		System.out.println("4.### GuestServiceImpl: setGuestDao("+guestDao+") 메써드호출");
		this.guestDao = guestDao;
	}

	/*
	 * 방명록 리스트
	 */
	/* (non-Javadoc)
	 * @see com.itwill.guest.GuestService#selectAll()
	 */
	@Override
	public List<Guest> selectAll() throws Exception {
		return guestDao.selectAll();
	}
	/*
	 * CREATE
	 */
	/* (non-Javadoc)
	 * @see com.itwill.guest.GuestService#insertGuest(com.itwill.guest.Guest)
	 */
	@Override
	public boolean insertGuest(Guest guest) throws Exception{
		return guestDao.insertGuest(guest);
	}
	/*
	 * READ ONE
	 */
	/* (non-Javadoc)
	 * @see com.itwill.guest.GuestService#selectByNo(int)
	 */
	@Override
	public Guest selectByNo(int no) throws Exception{
		return guestDao.selectByNo(no);
	}
	/*
	 * DELETE
	 */
	/* (non-Javadoc)
	 * @see com.itwill.guest.GuestService#deleteGuest(int)
	 */
	@Override
	public boolean deleteGuest(int no) throws Exception{
		return guestDao.deleteGuest(no);
	}
	/*
	 * UPDATE
	 */
	/* (non-Javadoc)
	 * @see com.itwill.guest.GuestService#updateGuest(com.itwill.guest.Guest)
	 */
	@Override
	public boolean updateGuest(Guest updateGuest) throws Exception{
		return guestDao.updateGuest(updateGuest);
	}
	
	
	

}
