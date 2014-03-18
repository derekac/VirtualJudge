package com.tzcacm.judge;

import com.tzcacm.bean.Query;
import com.tzcacm.bean.Status;
import com.tzcacm.bean.User;

public interface JudgeClient {
	public abstract Status getStatusZju(int submitId, User query);
	public abstract int submitZju(User user, Query query) throws Exception ;
}
