package com.engageok.prototype_1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.engageok.prototype_1.models.Issuetag;

public interface IssuetagRepo extends CrudRepository<Issuetag, Long>{
	public List<Issuetag> findAll();
	public Issuetag save(Issuetag it);
	public Issuetag findOne(Long id);
}
