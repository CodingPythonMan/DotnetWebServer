package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.domain.Item;
import com.project.domain.Member;
import com.project.domain.PayCoin;
import com.project.domain.UserItem;
import com.project.mapper.CoinMapper;
import com.project.mapper.UserItemMapper;

@Service
public class UserItemServiceImpl implements UserItemService {
	@Autowired
	private UserItemMapper mapper;
	
	@Autowired
	private CoinMapper coinMapper;

	// 구매 상품 등록 처리
	@Transactional
	@Override
	public void register(Member member, Item item) throws Exception {
		int userNo = member.getUserNo();
		
		int itemId = item.getItemId();
		int price = item.getPrice();
		
		UserItem userItem = new UserItem();
		
		userItem.setUserNo(userNo);
		userItem.setItemId(itemId);
		
		PayCoin payCoin = new PayCoin();
		
		payCoin.setUserNo(userNo);
		payCoin.setItemId(itemId);
		payCoin.setAmount(price);
	}

	@Override
	public UserItem read(Integer userItemNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserItem> list(Integer userNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
