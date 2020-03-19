package com.itzyzx.gmall.service;

import com.itzyzx.gmall.bean.UmsMember;
import com.itzyzx.gmall.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {
	/**
	 *
	 * @return
	 */
	List<UmsMember> getAllUser();

	/**
	 *
	 * @param memberId
	 * @return
	 */
	List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);
}
