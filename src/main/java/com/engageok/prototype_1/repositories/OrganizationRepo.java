package com.engageok.prototype_1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.engageok.prototype_1.models.Organization;

public interface OrganizationRepo extends CrudRepository<Organization, Long> {
	public List<Organization> findAll();
	public Organization save(Organization o);
	public Organization findOne(Long id);
}
