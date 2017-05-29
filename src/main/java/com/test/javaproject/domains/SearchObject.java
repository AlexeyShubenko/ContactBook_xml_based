package com.test.javaproject.domains;

import com.test.javaproject.dto.ContactDto;

import java.util.ArrayList;
import java.util.List;

public class SearchObject {

	private String searcher;
	private boolean flag;
	
	public SearchObject(){}

	public SearchObject(String searcher, boolean flag) {
		super();
		this.searcher = searcher;
		this.flag = flag;
	}
	
	public String getSearcher() {
		return searcher;
	}

	public void setSearcher(String searcher) {
		this.searcher = searcher;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public List<ContactDto> searchByName(SearchObject s, List<ContactDto> list){
		List<ContactDto> byname = new ArrayList<>();
		for(ContactDto c: list){
				if(c.getFirstName().regionMatches(true, 0, s.getSearcher(), 0, s.getSearcher().length())
						|| c.getLastName().regionMatches(true, 0, s.getSearcher(), 0, s.getSearcher().length())){
					byname.add(c);
				}			
		}
		return byname;
	}
	
	public List<ContactDto> searchByNumber(SearchObject s, List<ContactDto> list){
		List<ContactDto> bynum = new ArrayList<>();
		for(ContactDto c: list){
				if(c.getMobPhoneNumber().regionMatches(true, 0, s.getSearcher(), 0, s.getSearcher().length()))
					bynum.add(c);
		}
		return bynum;
	}
	
}
