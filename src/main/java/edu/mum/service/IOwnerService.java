package edu.mum.service;

import java.util.List;

import edu.mum.domain.User;

public interface IOwnerService {
	public List<User> getOwner();

	int getUserByName(String userName);
}
