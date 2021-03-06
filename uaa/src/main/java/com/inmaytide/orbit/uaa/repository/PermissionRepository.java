package com.inmaytide.orbit.uaa.repository;

import com.inmaytide.orbit.uaa.domain.Permission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends CrudRepository<Permission, Long> {

    @Query(nativeQuery = true, value = "select code from permission where id in (select permission_id from role_permission where role_id in (select role_id from user_role where user_id=?1))")
    List<String> getCodesByUser(Long id);

}
