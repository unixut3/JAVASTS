package com.itwill.guest;

import java.util.ArrayList;

public class GuestDao {
	
	public GuestDao() throws Exception {
		
	}

	/*
	 * READ ALL
	 */
	public ArrayList<Guest> selectAll() throws Exception {
		ArrayList<Guest> guestList = new ArrayList<Guest>();
		
		return guestList;
		
	}

	/*
	 * CREATE
	 */
	public boolean insertGuest(Guest guest) throws Exception {
		boolean isSuccess = false;
		
		return isSuccess;
	}

	/*
	 * READ ONE
	 */
	public Guest selectByNo(int no) throws Exception {
		Guest guest = null;
		
		return guest;
	}

	
	/*
	 * DELETE
	 */
	public boolean deleteGuest(int no) throws Exception{
		boolean deleteOK=false;
		
		return deleteOK;
	}
	/*
	 * UPDATE
	 */
	public boolean updateGuest(Guest updateGuest) throws Exception{
		boolean updateOK=true;
		
		return updateOK;
	}

}
