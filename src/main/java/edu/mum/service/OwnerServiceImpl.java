package edu.mum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.IGenericDao;
import edu.mum.domain.User;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class OwnerServiceImpl implements IOwnerService {

	@Autowired
	IGenericDao<User, Integer> ownerDao;

	@Override
	public List<User> getOwner() {
		return ownerDao.findAll(User.class);
	}

	@Override
	public int getUserByName(String userName) {
		// TODO Auto-generated method stub
		return 0;
	}

}
