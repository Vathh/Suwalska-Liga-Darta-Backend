package pl.liga.infrastructure.security;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

    UserEntity findByUserName(String name);

}
