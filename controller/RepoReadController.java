package controller;

import service.RepoService;

public class RepoReadController{
	RepoService repoService = new RepoService();
	public void showAvail(){
		repoService.printAvailSlots();
	}

	public void showAvail(String type){
		repoService.printAvailSlots(type);
	}	
}
