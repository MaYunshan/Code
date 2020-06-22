package com.mys.service;

import java.io.IOException;
import java.util.List;

import com.mys.bean.People;

public interface PeopleService {
	public List<People> show() throws IOException;
}
